package java76.pms.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java76.pms.domain.Event;
import java76.pms.service.MemberService;
 
public class abc {
		public abc() {}
		@Autowired MemberService memberService;
		public static void main(String[] args) {
			abc set = new abc();
			set.start();
		}
		public void start() {


    			try {
    				// 엑셀파일
    				//File file = new File("/Users/ohora/wecando/wecando/sql/school.xlsx");
    				File file = new File("C:/Users/IEUser/Documents/wecando/wecando/sql/event.xlsx");
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
    					
    					memberService.event_insert(event);
    				}
    			} catch (Exception e) {
    			}
		}
}
