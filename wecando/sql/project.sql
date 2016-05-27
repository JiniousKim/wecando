-- 기존 BOARD 테이블 삭제
drop table board;

-- AUTO_INCREMENT 생성
create sequence school_incre;
create sequence reply_incre;
create sequence member_incre;
create sequence photo_incre;
create sequence board_incre;
create sequence reserve_incre;

-- 학교
CREATE TABLE SCHOOL (
	SCH_NUM      INTEGER      NOT NULL, -- 학교번호
	SCH_NAME     VARCHAR(50)  NOT NULL, -- 학교명
	SCH_LOCATION VARCHAR(255) NOT NULL, -- 위치
	SCH_TEL      VARCHAR(30)  NOT NULL, -- 전화번호
	MEMBER_NUM   INTEGER      NULL      -- 회원번호
);

-- 학교
ALTER TABLE SCHOOL
	ADD CONSTRAINT PK_SCHOOL -- 학교 기본키
		PRIMARY KEY (
			SCH_NUM -- 학교번호
		);

-- 예약
CREATE TABLE RESERVE (
	RESERVE_NUM    INTEGER     NOT NULL, -- 예약번호
	RESERVE_PERSON INTEGER     NOT NULL, -- 사용인원
	RESERVE_PRO    CHAR(10)    NOT NULL, -- 예약진행여부
	RESERVE_DATE   DATE        NOT NULL, -- 예약신청일
	MEMBER_NUM     INTEGER     NULL,     -- 회원번호
	SCH_NUM        INTEGER     NULL,     -- 학교번호
	EVENT_CODE     CHAR(10)    NULL,     -- 종목코드
	COURT_CODE     VARCHAR(50) NULL,     -- 코트코드
	EVENT_DATE     DATE        NULL      -- 사용날짜
);

-- 예약
ALTER TABLE RESERVE
	ADD CONSTRAINT PK_RESERVE -- 예약 기본키
		PRIMARY KEY (
			RESERVE_NUM -- 예약번호
		);

-- 종목
CREATE TABLE EVENT (
	EVENT_CODE  CHAR(10)    NOT NULL, -- 종목코드
	EVENT_NAME  VARCHAR(50) NOT NULL, -- 종목명
	EVENT_PRICE INTEGER     NOT NULL, -- 사용금액
	EVENT_MAX   INTEGER     NOT NULL  -- 최대수용인원
);

-- 종목
ALTER TABLE EVENT
	ADD CONSTRAINT PK_EVENT -- 종목 기본키
		PRIMARY KEY (
			EVENT_CODE -- 종목코드
		);

-- Q&A
CREATE TABLE BOARD (
	BOARD_NUM     INTEGER      NOT NULL, -- 게시글번호
	BOARD_CONTENT VARCHAR(255) NOT NULL, -- 게시글내용
	BOARD_PWD     VARCHAR(100) NULL,     -- 게시글비밀번호
	MEMBER_NUM    INTEGER      NULL,     -- 회원번호
	SCH_NUM       INTEGER      NULL      -- 학교번호
);

-- Q&A
ALTER TABLE BOARD
	ADD CONSTRAINT PK_BOARD -- Q&A 기본키
		PRIMARY KEY (
			BOARD_NUM -- 게시글번호
		);

-- 사진
CREATE TABLE PHOTO (
	PHOTO_NUM  INTEGER      NOT NULL, -- 사진번호
	PHOTO_NAME VARCHAR(255) NOT NULL, -- 사진명
	SCH_NUM    INTEGER      NULL,     -- 학교번호
	BOARD_NUM  INTEGER      NULL      -- 게시글번호
);

-- 사진
ALTER TABLE PHOTO
	ADD CONSTRAINT PK_PHOTO -- 사진 기본키
		PRIMARY KEY (
			PHOTO_NUM -- 사진번호
		);

-- 회원
CREATE TABLE MEMBER (
	MEMBER_NUM   INTEGER      NOT NULL, -- 회원번호
	MEMBER_GRADE INTEGER      NOT NULL, -- 회원등급
	MEMBER_EMAIL VARCHAR(40)  NOT NULL, -- 이메일
	MEMBER_NAME  VARCHAR(50)  NOT NULL, -- 회원명
	MEMBER_TEL   VARCHAR(30)  NOT NULL, -- 전화번호
	MEMBER_PWD   VARCHAR(100) NOT NULL, -- 비밀번호
	MEMBER_AVA   INTEGER      NOT NULL  -- 예약가능여부
);

-- 회원
ALTER TABLE MEMBER
	ADD CONSTRAINT PK_MEMBER -- 회원 기본키
		PRIMARY KEY (
			MEMBER_NUM -- 회원번호
		);

-- 답글
CREATE TABLE REPLY (
	REPLY_NUM     INTEGER      NOT NULL, -- 답글번호
	REPLY_CONTENT VARCHAR(255) NOT NULL, -- 답글내용
	BOARD_NUM     INTEGER      NULL,     -- 게시글번호
	MEMBER_NUM    INTEGER      NULL      -- 회원번호
);

-- 답글
ALTER TABLE REPLY
	ADD CONSTRAINT PK_REPLY -- 답글 기본키
		PRIMARY KEY (
			REPLY_NUM -- 답글번호
		);

-- 학교종목
CREATE TABLE SCHEVENT (
	SCH_NUM    INTEGER     NOT NULL, -- 학교번호
	EVENT_CODE CHAR(10)    NOT NULL, -- 종목코드
	COURT_CODE VARCHAR(50) NOT NULL, -- 코트코드
	EVENT_DATE DATE        NOT NULL, -- 사용날짜
	T6_8       VARCHAR(1)     NULL,     -- 6-8
	T8_10      VARCHAR(1)     NULL,     -- 8-10
	T10_12     VARCHAR(1)     NULL,     -- 10-12
	T12_14     VARCHAR(1)     NULL,     -- 12-14
	T14_16     VARCHAR(1)     NULL,     -- 14-16
	T16_18     VARCHAR(1)     NULL,     -- 16-18
	T18_20     VARCHAR(1)     NULL,     -- 18-20
	T20_22     VARCHAR(1)     NULL      -- 20-22
);

-- 학교종목
ALTER TABLE SCHEVENT
	ADD CONSTRAINT PK_SCHEVENT -- 학교종목 기본키
		PRIMARY KEY (
			SCH_NUM,    -- 학교번호
			EVENT_CODE, -- 종목코드
			COURT_CODE, -- 코트코드
			EVENT_DATE  -- 사용날짜
		);

-- COURT
CREATE TABLE COURT (
	COURT_CODE VARCHAR(50) NOT NULL, -- 코트코드
	COURT_CNT  INTEGER     NULL,     -- 코트갯수
	EVENT_CODE CHAR(10)    NOT NULL, -- 종목코드
	SCH_NUM    INTEGER     NULL      -- 학교번호
);

-- COURT
ALTER TABLE COURT
	ADD CONSTRAINT PK_COURT -- COURT 기본키
		PRIMARY KEY (
			COURT_CODE -- 코트코드
		);

-- 학교
ALTER TABLE SCHOOL
	ADD CONSTRAINT FK_MEMBER_TO_SCHOOL -- 회원 -> 학교
		FOREIGN KEY (
			MEMBER_NUM -- 회원번호
		)
		REFERENCES MEMBER ( -- 회원
			MEMBER_NUM -- 회원번호
		) ON DELETE CASCADE;

-- 예약
ALTER TABLE RESERVE
	ADD CONSTRAINT FK_MEMBER_TO_RESERVE -- 회원 -> 예약
		FOREIGN KEY (
			MEMBER_NUM -- 회원번호
		)
		REFERENCES MEMBER ( -- 회원
			MEMBER_NUM -- 회원번호
		) ON DELETE CASCADE;

-- 예약
ALTER TABLE RESERVE
	ADD CONSTRAINT FK_SCHEVENT_TO_RESERVE -- 학교종목 -> 예약
		FOREIGN KEY (
			SCH_NUM,    -- 학교번호
			EVENT_CODE, -- 종목코드
			COURT_CODE, -- 코트코드
			EVENT_DATE  -- 사용날짜
		)
		REFERENCES SCHEVENT ( -- 학교종목
			SCH_NUM,    -- 학교번호
			EVENT_CODE, -- 종목코드
			COURT_CODE, -- 코트코드
			EVENT_DATE  -- 사용날짜
		) ON DELETE CASCADE;

-- Q&A
ALTER TABLE BOARD
	ADD CONSTRAINT FK_MEMBER_TO_BOARD -- 회원 -> Q&A
		FOREIGN KEY (
			MEMBER_NUM -- 회원번호
		)
		REFERENCES MEMBER ( -- 회원
			MEMBER_NUM -- 회원번호
		) ON DELETE CASCADE;

-- Q&A
ALTER TABLE BOARD
	ADD CONSTRAINT FK_SCHOOL_TO_BOARD -- 학교 -> Q&A
		FOREIGN KEY (
			SCH_NUM -- 학교번호
		)
		REFERENCES SCHOOL ( -- 학교
			SCH_NUM -- 학교번호
		) ON DELETE CASCADE;

-- 사진
ALTER TABLE PHOTO
	ADD CONSTRAINT FK_SCHOOL_TO_PHOTO -- 학교 -> 사진
		FOREIGN KEY (
			SCH_NUM -- 학교번호
		)
		REFERENCES SCHOOL ( -- 학교
			SCH_NUM -- 학교번호
		) ON DELETE CASCADE;

-- 사진
ALTER TABLE PHOTO
	ADD CONSTRAINT FK_BOARD_TO_PHOTO -- Q&A -> 사진
		FOREIGN KEY (
			BOARD_NUM -- 게시글번호
		)
		REFERENCES BOARD ( -- Q&A
			BOARD_NUM -- 게시글번호
		) ON DELETE CASCADE;

-- 답글
ALTER TABLE REPLY
	ADD CONSTRAINT FK_BOARD_TO_REPLY -- Q&A -> 답글
		FOREIGN KEY (
			BOARD_NUM -- 게시글번호
		)
		REFERENCES BOARD ( -- Q&A
			BOARD_NUM -- 게시글번호
		) ON DELETE CASCADE;

-- 답글
ALTER TABLE REPLY
	ADD CONSTRAINT FK_MEMBER_TO_REPLY -- 회원 -> 답글
		FOREIGN KEY (
			MEMBER_NUM -- 회원번호
		)
		REFERENCES MEMBER ( -- 회원
			MEMBER_NUM -- 회원번호
		) ON DELETE CASCADE;

-- 학교종목
ALTER TABLE SCHEVENT
	ADD CONSTRAINT FK_EVENT_TO_SCHEVENT -- 종목 -> 학교종목
		FOREIGN KEY (
			EVENT_CODE -- 종목코드
		)
		REFERENCES EVENT ( -- 종목
			EVENT_CODE -- 종목코드
		) ON DELETE CASCADE;

-- 학교종목
ALTER TABLE SCHEVENT
	ADD CONSTRAINT FK_SCHOOL_TO_SCHEVENT -- 학교 -> 학교종목
		FOREIGN KEY (
			SCH_NUM -- 학교번호
		)
		REFERENCES SCHOOL ( -- 학교
			SCH_NUM -- 학교번호
		) ON DELETE CASCADE;

-- 학교종목
ALTER TABLE SCHEVENT
	ADD CONSTRAINT FK_COURT_TO_SCHEVENT -- COURT -> 학교종목
		FOREIGN KEY (
			COURT_CODE -- 코트코드
		)
		REFERENCES COURT ( -- COURT
			COURT_CODE -- 코트코드
		) ON DELETE CASCADE;


ALTER TABLE SCHEVENT MODIFY(T6_8 VARCHAR2(1) DEFAULT 0);
ALTER TABLE SCHEVENT MODIFY(T8_10 VARCHAR2(1) DEFAULT 0);
ALTER TABLE SCHEVENT MODIFY(T10_12 VARCHAR2(1) DEFAULT 0);
ALTER TABLE SCHEVENT MODIFY(T12_14 VARCHAR2(1) DEFAULT 0);
ALTER TABLE SCHEVENT MODIFY(T14_16 VARCHAR2(1) DEFAULT 0);
ALTER TABLE SCHEVENT MODIFY(T16_18 VARCHAR2(1) DEFAULT 0);
ALTER TABLE SCHEVENT MODIFY(T18_20 VARCHAR2(1) DEFAULT 0);
ALTER TABLE SCHEVENT MODIFY(T20_22 VARCHAR2(1) DEFAULT 0);

/*
INSERT INTO SCHOOL(SCH_NUM,SCH_NAME,SCH_LOCATION,SCH_TEL)
VALUES (123,'A','AA','AAA');
INSERT INTO EVENT(EVENT_CODE,EVENT_NAME,EVENT_PRICE,EVENT_MAX)
VALUES ('EVENT','EEEE',111,1112);
INSERT INTO COURT(COURT_CODE,EVENT_CODE) VALUES ('COURT','EVENT');


INSERT INTO SCHEVENT(SCH_NUM,EVENT_CODE,COURT_CODE,EVENT_DATE) 
VALUES(123,
'EVENT',
'COURT',
SYSDATE);

INSERT INTO SCHEVENT(EVENT_DATE) 
VALUES(
SYSDATE);
*/

-- COURT
ALTER TABLE COURT
	ADD CONSTRAINT FK_EVENT_TO_COURT -- 종목 -> COURT
		FOREIGN KEY (
			EVENT_CODE -- 종목코드
		)
		REFERENCES EVENT ( -- 종목
			EVENT_CODE -- 종목코드
		) ON DELETE CASCADE;

-- COURT
ALTER TABLE COURT
	ADD CONSTRAINT FK_SCHOOL_TO_COURT -- 학교 -> COURT
		FOREIGN KEY (
			SCH_NUM -- 학교번호
		)
		REFERENCES SCHOOL ( -- 학교
			SCH_NUM -- 학교번호
		) ON DELETE CASCADE;