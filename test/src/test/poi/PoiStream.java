package test.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

public class PoiStream {

	public static void main(String[] args) throws Exception {
		System.out.println("query");
		
		for(int i=0; i<10; i++) {
			readExcel();
		}
	}

	private static void readExcel() throws FileNotFoundException, IOException {
		InputStream is = new FileInputStream("C:\\Users\\chuzhen\\Desktop\\temp\\能源线实习生邮箱、OA开通.xls");
		
		POIFSFileSystem fileSystem = new POIFSFileSystem(is);
		HSSFWorkbook wb = new HSSFWorkbook(fileSystem);
		
		HSSFSheet sheet = wb.getSheetAt(0);
		
		// 得到总行数
        int lastRowNum = sheet.getLastRowNum();
        // 正文内容应该从第二行开始,第一行为表头的标题
        List<User> userList = new ArrayList<User>();
        for (int row = 1; row <= lastRowNum; row++) {
        	HSSFRow hssfRow = sheet.getRow(row);
            
            int lastCellNum = hssfRow.getLastCellNum();
            User user = new User();
            for(int col=0; col<lastCellNum; col++) {
            	
            	HSSFCell cell = hssfRow.getCell(col);
            	String cellValue = getCellValue(cell);
            	System.out.println(cellValue);
            	
            	new User();
            	
            	if(col == 0) {
            		user.setCode(cellValue);
            	} else if(col == 1) {
            		user.setTitle(cellValue);
            	} else if(col == 2) {
            		user.setEmail(cellValue);
            	} else if(col == 3) {
            		user.setPassword(cellValue);
            	}
            	
            }
            
            userList.add(user);
        }
	}
	
	private static String getCellValue(HSSFCell cell) {
		if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			return cell.getNumericCellValue() + "";
		} else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			return cell.getCellFormula();
		}
		
		return null;
	}

}

class User {
	String code;
	String title;
	String password;
	String email;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}