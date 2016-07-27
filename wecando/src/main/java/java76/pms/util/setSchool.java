package java76.pms.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java76.pms.domain.Event;
import java76.pms.service.MemberService;


public class setSchool {
	@Autowired MemberService memberService;
		public setSchool() {}
		public static void main(String[] args) {
			setSchool set = new setSchool();
			set.start();
		}
		public void start() {
			try {
				// 엑셀파일
				File file = new File("/Users/ohora/wecando/wecando/sql/event.xlsx");
				//File file = new File("C:/Users/IEUser/Documents/wecando/wecando/sql/event.xlsx");
				Event event = new Event();
				// 엑셀 파일 오픈
				@SuppressWarnings("resource")
				XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
				for (Row row : wb.getSheetAt(0)) { 
					if(row.getCell(1) == null){
						break;
					}
					event.setEvent_code(row.getCell(0).toString());
					event.setEvent_name(row.getCell(1).toString());
					event.setEvent_price(Integer.parseInt(row.getCell(2).toString().replace(".0",	"")));
					event.setEvent_max(Integer.parseInt(row.getCell(3).toString().replace(".0",	"")));
					memberService.insert_event(event);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
