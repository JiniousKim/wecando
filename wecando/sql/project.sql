-- 학교
CREATE TABLE `MY_SCHEMA`.`SCHOOL` (
	`SCH_NUM`      숫자     NOT NULL COMMENT '학교번호', -- 학교번호
	`SCH_NAME`     이름     NOT NULL COMMENT '학교명', -- 학교명
	`SCH_LOCATION` 주소     NOT NULL COMMENT '위치', -- 위치
	`SCH_TEL`      전화번호 NOT NULL COMMENT '전화번호', -- 전화번호
	`SCH_DATE`     날짜     NOT NULL COMMENT '이용가능날짜', -- 이용가능날짜
	`SCH_TIME`     주소     NOT NULL COMMENT '이용가능시간', -- 이용가능시간
	`MEMBER_NUM`   숫자     NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '학교';

-- 학교
ALTER TABLE `MY_SCHEMA`.`SCHOOL`
	ADD CONSTRAINT `PK_SCHOOL` -- 학교 기본키
		PRIMARY KEY (
			`SCH_NUM` -- 학교번호
		);

ALTER TABLE `MY_SCHEMA`.`SCHOOL`
	MODIFY COLUMN `SCH_NUM` 숫자 NOT NULL AUTO_INCREMENT COMMENT '학교번호';

-- 예약
CREATE TABLE `MY_SCHEMA`.`RESERVE` (
	`RESERVE_NUM`    숫자 NOT NULL COMMENT '예약번호', -- 예약번호
	`RESERVE_PERSON` 숫자 NOT NULL COMMENT '사용인원', -- 사용인원
	`RESERVE_PRO`    코드 NOT NULL COMMENT '예약진행여부', -- 예약진행여부
	`RESERVE_DATE`   날짜 NOT NULL COMMENT '예약신청일', -- 예약신청일
	`SCH_NUM`        숫자 NULL     COMMENT '학교번호', -- 학교번호
	`EVENT_CODE`     코드 NULL     COMMENT '종목코드', -- 종목코드
	`MEMBER_NUM`     숫자 NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '예약';

-- 예약
ALTER TABLE `MY_SCHEMA`.`RESERVE`
	ADD CONSTRAINT `PK_RESERVE` -- 예약 기본키
		PRIMARY KEY (
			`RESERVE_NUM` -- 예약번호
		);

ALTER TABLE `MY_SCHEMA`.`RESERVE`
	MODIFY COLUMN `RESERVE_NUM` 숫자 NOT NULL AUTO_INCREMENT COMMENT '예약번호';

-- 종목
CREATE TABLE `MY_SCHEMA`.`EVENT` (
	`EVENT_CODE`  코드 NOT NULL COMMENT '종목코드', -- 종목코드
	`EVENT_NAME`  이름 NOT NULL COMMENT '종목명', -- 종목명
	`EVENT_MAX`   숫자 NOT NULL COMMENT '최대수용인원', -- 최대수용인원
	`EVENT_PRICE` 금액 NOT NULL COMMENT '사용금액' -- 사용금액
)
COMMENT '종목';

-- 종목
ALTER TABLE `MY_SCHEMA`.`EVENT`
	ADD CONSTRAINT `PK_EVENT` -- 종목 기본키
		PRIMARY KEY (
			`EVENT_CODE` -- 종목코드
		);

-- Q&A
CREATE TABLE `MY_SCHEMA`.`BOARD` (
	`BOARD_NUM`     숫자     NOT NULL COMMENT '게시글번호', -- 게시글번호
	`BOARD_CONTENT` 웹주소   NOT NULL COMMENT '게시글내용', -- 게시글내용
	`BOARD_PWD`     비밀번호 NULL     COMMENT '게시글비밀번호', -- 게시글비밀번호
	`MEMBER_NUM`    숫자     NULL     COMMENT '회원번호', -- 회원번호
	`SCH_NUM`       숫자     NULL     COMMENT '학교번호' -- 학교번호
)
COMMENT 'Q&A';

-- Q&A
ALTER TABLE `MY_SCHEMA`.`BOARD`
	ADD CONSTRAINT `PK_BOARD` -- Q&A 기본키
		PRIMARY KEY (
			`BOARD_NUM` -- 게시글번호
		);

ALTER TABLE `MY_SCHEMA`.`BOARD`
	MODIFY COLUMN `BOARD_NUM` 숫자 NOT NULL AUTO_INCREMENT COMMENT '게시글번호';

-- 사진
CREATE TABLE `MY_SCHEMA`.`PHOTO` (
	`PHOTO_NUM`  숫자   NOT NULL COMMENT '사진번호', -- 사진번호
	`PHOTO_NAME` 웹주소 NOT NULL COMMENT '사진명', -- 사진명
	`SCH_NUM`    숫자   NULL     COMMENT '학교번호', -- 학교번호
	`BOARD_NUM`  숫자   NULL     COMMENT '게시글번호' -- 게시글번호
)
COMMENT '사진';

-- 사진
ALTER TABLE `MY_SCHEMA`.`PHOTO`
	ADD CONSTRAINT `PK_PHOTO` -- 사진 기본키
		PRIMARY KEY (
			`PHOTO_NUM` -- 사진번호
		);

ALTER TABLE `MY_SCHEMA`.`PHOTO`
	MODIFY COLUMN `PHOTO_NUM` 숫자 NOT NULL AUTO_INCREMENT COMMENT '사진번호';

-- 회원
CREATE TABLE `MY_SCHEMA`.`MEMBER` (
	`MEMBER_NUM`   숫자     NOT NULL COMMENT '회원번호', -- 회원번호
	`MEMBER_GRADE` 숫자     NOT NULL COMMENT '회원등급', -- 회원등급
	`MEMBER_EMAIL` 이메일   NOT NULL COMMENT '이메일', -- 이메일
	`MEMBER_NAME`  이름     NOT NULL COMMENT '회원명', -- 회원명
	`MEMBER_TEL`   전화번호 NOT NULL COMMENT '전화번호', -- 전화번호
	`MEMBER_PWD`   비밀번호 NOT NULL COMMENT '비밀번호', -- 비밀번호
	`MEMBER_AVA`   숫자     NOT NULL COMMENT '예약가능여부' -- 예약가능여부
)
COMMENT '회원';

-- 회원
ALTER TABLE `MY_SCHEMA`.`MEMBER`
	ADD CONSTRAINT `PK_MEMBER` -- 회원 기본키
		PRIMARY KEY (
			`MEMBER_NUM` -- 회원번호
		);

ALTER TABLE `MY_SCHEMA`.`MEMBER`
	MODIFY COLUMN `MEMBER_NUM` 숫자 NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 답글
CREATE TABLE `MY_SCHEMA`.`REPLY` (
	`REPLY_NUM`     숫자   NOT NULL COMMENT '답글번호', -- 답글번호
	`REPLY_CONTENT` 웹주소 NOT NULL COMMENT '답글내용', -- 답글내용
	`BOARD_NUM`     숫자   NULL     COMMENT '게시글번호', -- 게시글번호
	`MEMBER_NUM`    숫자   NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '답글';

-- 답글
ALTER TABLE `MY_SCHEMA`.`REPLY`
	ADD CONSTRAINT `PK_REPLY` -- 답글 기본키
		PRIMARY KEY (
			`REPLY_NUM` -- 답글번호
		);

ALTER TABLE `MY_SCHEMA`.`REPLY`
	MODIFY COLUMN `REPLY_NUM` 숫자 NOT NULL AUTO_INCREMENT COMMENT '답글번호';

-- 학교종목
CREATE TABLE `MY_SCHEMA`.`SCHEVENT` (
	`EVENT_CODE` 코드 NULL COMMENT '종목코드', -- 종목코드
	`SCH_NUM`    숫자 NULL COMMENT '학교번호' -- 학교번호
)
COMMENT '학교종목';

-- 학교
ALTER TABLE `MY_SCHEMA`.`SCHOOL`
	ADD CONSTRAINT `FK_MEMBER_TO_SCHOOL` -- 회원 -> 학교
		FOREIGN KEY (
			`MEMBER_NUM` -- 회원번호
		)
		REFERENCES `MY_SCHEMA`.`MEMBER` ( -- 회원
			`MEMBER_NUM` -- 회원번호
		);

-- 예약
ALTER TABLE `MY_SCHEMA`.`RESERVE`
	ADD CONSTRAINT `FK_SCHOOL_TO_RESERVE` -- 학교 -> 예약
		FOREIGN KEY (
			`SCH_NUM` -- 학교번호
		)
		REFERENCES `MY_SCHEMA`.`SCHOOL` ( -- 학교
			`SCH_NUM` -- 학교번호
		);

-- 예약
ALTER TABLE `MY_SCHEMA`.`RESERVE`
	ADD CONSTRAINT `FK_EVENT_TO_RESERVE` -- 종목 -> 예약
		FOREIGN KEY (
			`EVENT_CODE` -- 종목코드
		)
		REFERENCES `MY_SCHEMA`.`EVENT` ( -- 종목
			`EVENT_CODE` -- 종목코드
		);

-- 예약
ALTER TABLE `MY_SCHEMA`.`RESERVE`
	ADD CONSTRAINT `FK_MEMBER_TO_RESERVE` -- 회원 -> 예약
		FOREIGN KEY (
			`MEMBER_NUM` -- 회원번호
		)
		REFERENCES `MY_SCHEMA`.`MEMBER` ( -- 회원
			`MEMBER_NUM` -- 회원번호
		);

-- Q&A
ALTER TABLE `MY_SCHEMA`.`BOARD`
	ADD CONSTRAINT `FK_MEMBER_TO_BOARD` -- 회원 -> Q&A
		FOREIGN KEY (
			`MEMBER_NUM` -- 회원번호
		)
		REFERENCES `MY_SCHEMA`.`MEMBER` ( -- 회원
			`MEMBER_NUM` -- 회원번호
		);

-- Q&A
ALTER TABLE `MY_SCHEMA`.`BOARD`
	ADD CONSTRAINT `FK_SCHOOL_TO_BOARD` -- 학교 -> Q&A
		FOREIGN KEY (
			`SCH_NUM` -- 학교번호
		)
		REFERENCES `MY_SCHEMA`.`SCHOOL` ( -- 학교
			`SCH_NUM` -- 학교번호
		);

-- 사진
ALTER TABLE `MY_SCHEMA`.`PHOTO`
	ADD CONSTRAINT `FK_SCHOOL_TO_PHOTO` -- 학교 -> 사진
		FOREIGN KEY (
			`SCH_NUM` -- 학교번호
		)
		REFERENCES `MY_SCHEMA`.`SCHOOL` ( -- 학교
			`SCH_NUM` -- 학교번호
		);

-- 사진
ALTER TABLE `MY_SCHEMA`.`PHOTO`
	ADD CONSTRAINT `FK_BOARD_TO_PHOTO` -- Q&A -> 사진
		FOREIGN KEY (
			`BOARD_NUM` -- 게시글번호
		)
		REFERENCES `MY_SCHEMA`.`BOARD` ( -- Q&A
			`BOARD_NUM` -- 게시글번호
		);

-- 답글
ALTER TABLE `MY_SCHEMA`.`REPLY`
	ADD CONSTRAINT `FK_BOARD_TO_REPLY` -- Q&A -> 답글
		FOREIGN KEY (
			`BOARD_NUM` -- 게시글번호
		)
		REFERENCES `MY_SCHEMA`.`BOARD` ( -- Q&A
			`BOARD_NUM` -- 게시글번호
		);

-- 답글
ALTER TABLE `MY_SCHEMA`.`REPLY`
	ADD CONSTRAINT `FK_MEMBER_TO_REPLY` -- 회원 -> 답글
		FOREIGN KEY (
			`MEMBER_NUM` -- 회원번호
		)
		REFERENCES `MY_SCHEMA`.`MEMBER` ( -- 회원
			`MEMBER_NUM` -- 회원번호
		);

-- 학교종목
ALTER TABLE `MY_SCHEMA`.`SCHEVENT`
	ADD CONSTRAINT `FK_EVENT_TO_SCHEVENT` -- 종목 -> 학교종목
		FOREIGN KEY (
			`EVENT_CODE` -- 종목코드
		)
		REFERENCES `MY_SCHEMA`.`EVENT` ( -- 종목
			`EVENT_CODE` -- 종목코드
		);

-- 학교종목
ALTER TABLE `MY_SCHEMA`.`SCHEVENT`
	ADD CONSTRAINT `FK_SCHOOL_TO_SCHEVENT` -- 학교 -> 학교종목
		FOREIGN KEY (
			`SCH_NUM` -- 학교번호
		)
		REFERENCES `MY_SCHEMA`.`SCHOOL` ( -- 학교
			`SCH_NUM` -- 학교번호
		);