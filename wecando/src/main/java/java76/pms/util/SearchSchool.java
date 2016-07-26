package java76.pms.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java76.pms.domain.School;
 
public class SearchSchool {
	  School school = new School();
	
		public SearchSchool() {}
		
    public Object searchForSchool(String sch_name) {
    		HashMap<String, Object> resultMap = new HashMap<>();
    		System.out.println(2);
    		try {
    			// 엑셀파일
    			File file = new File("/Users/ohora/wecando/wecando/sql/school.xlsx");
    			
    			// 엑셀 파일 오픈
    			@SuppressWarnings("resource")
    			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
    			Cell cell = null;
    			for (Row row : wb.getSheetAt(0)) { 
    				if (row.getRowNum() < 2) {
    					continue;
    				}
    				if(row.getCell(1) == null){
    					break;
    				}
    				cell = row.getCell(0);
    				if (cell.toString().matches(".*" + sch_name + ".*")) {
    					School school = new School();
    					school.setSch_name(row.getCell(0).toString());
    					school.setSch_location(row.getCell(1).toString());
    					school.setSch_tel(row.getCell(2).toString());
    					resultMap.put(row.getCell(0).toString(), school);
    					System.out.println(resultMap.get(row.getCell(0)));
    				}
    			}
    		} catch (Exception e) {
    			resultMap.put("null", null);
    			return resultMap;
    		}
    		System.out.println(3);
    		return resultMap;
    }
}
