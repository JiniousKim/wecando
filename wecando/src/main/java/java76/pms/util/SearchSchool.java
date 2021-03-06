package java76.pms.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java76.pms.domain.AjaxResult;
import java76.pms.domain.School;
 
public class SearchSchool {
		public SearchSchool() {}
		
		public Object searchForSchool(String sch_name) {
    		HashMap<String, Object> resultMap = new HashMap<>();
    		List<School> schools = new ArrayList<School>();
    		int count = 0;
    		try {
    			File file = new File("C:/Users/IEUser/Documents/wecando/wecando/sql/School.xlsx");
    			
    			// 엑셀 파일 오픈
    			@SuppressWarnings("resource")
    			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
    			Cell cell = null;
    			for (Row row : wb.getSheetAt(0)) { 
    				if(row.getCell(1) == null){
    					break;
    				}
    				cell = row.getCell(0);
    				if (cell.toString().matches(".*" + sch_name + ".*")) {
    					School school = new School();
    					school.setSch_name(row.getCell(0).toString());
    					school.setSch_location(row.getCell(1).toString());
    					school.setSch_tel(row.getCell(2).toString());
    					schools.add(school);
    				}
    				count++;
    			}
    		} catch (Exception e) {
    			return new AjaxResult("failure", null);
    		}
    		if (count <= 0 ) {
    			resultMap.put("count", "not");
    		}
    		resultMap.put("status", "success");
    		resultMap.put("schools", schools);
    		return resultMap;
    }
		
		public School getSchool(String sch_name) {
			School school = new School();
			try {
  			// 엑셀파일
	  		//File file = new File("/Users/ohora/wecando/wecando/sql/school.xlsx");
	  			File file = new File("C:/Users/IEUser/Documents/wecando/wecando/sql/School.xlsx");
	  			
	  			// 엑셀 파일 오픈
	  			@SuppressWarnings("resource")
	  			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
	  			Cell cell = null;
	  			for (Row row : wb.getSheetAt(0)) { 
	  				if(row.getCell(1) == null){
	  					break;
	  				}
	  				cell = row.getCell(0);
	  				if (cell.toString().matches(".*" + sch_name + ".*")) {
	  					school.setSch_name(row.getCell(0).toString());
	  					school.setSch_location(row.getCell(1).toString());
	  					school.setSch_tel(row.getCell(2).toString());
	  				}
	  			}
	  		} catch (Exception e) {
	  			return null;
	  		}
			return school;
		}
}
