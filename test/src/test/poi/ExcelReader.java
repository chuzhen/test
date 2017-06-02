package test.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader {
	private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;

    /**
     * ��ȡExcel����ͷ������
     * @param InputStream
     * @return String ��ͷ���ݵ�����
     */
    public String[] readExcelTitle(InputStream is) {
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // ����������
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            //title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = getCellFormatValue(row.getCell((short) i));
        }
        return title;
    }

    /**
     * ��ȡExcel��������
     * @param InputStream
     * @return Map ������Ԫ���������ݵ�Map����
     */
    public Map<Integer, String> readExcelContent(InputStream is) {
        Map<Integer, String> content = new HashMap<Integer, String>();
        String str = "";
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // �õ�������
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
                // ÿ����Ԫ�������������"-"�ָ���Ժ���Ҫʱ��String���replace()������ԭ����
                // Ҳ���Խ�ÿ����Ԫ����������õ�һ��javabean�������У���ʱ��Ҫ�½�һ��javabean
                // str += getStringCellValue(row.getCell((short) j)).trim() +
                // "-";
                str += getCellFormatValue(row.getCell((short) j)).trim() + "    ";
                j++;
            }
            content.put(i, str);
            str = "";
        }
        return content;
    }
    
    /**
     * ��ȡExcelָ������������
     * @param InputStream
     * @return Map ������Ԫ���������ݵ�Map����
     */
    public Map<Integer, String> readExcelColContent(InputStream is, int col) {
        Map<Integer, String> content = new HashMap<Integer, String>();
        String str = "";
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // �õ�������
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        // ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            str += getCellFormatValue(row.getCell((short) col)).trim() + "    ";
            content.put(i, str);
            str = "";
        }
        return content;
    }

    /**
     * ��ȡ��Ԫ����������Ϊ�ַ������͵�����
     * 
     * @param cell Excel��Ԫ��
     * @return String ��Ԫ����������
     */
    private String getStringCellValue(HSSFCell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
        case HSSFCell.CELL_TYPE_STRING:
            strCell = cell.getStringCellValue();
            break;
        case HSSFCell.CELL_TYPE_NUMERIC:
            strCell = String.valueOf(cell.getNumericCellValue());
            break;
        case HSSFCell.CELL_TYPE_BOOLEAN:
            strCell = String.valueOf(cell.getBooleanCellValue());
            break;
        case HSSFCell.CELL_TYPE_BLANK:
            strCell = "";
            break;
        default:
            strCell = "";
            break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }

    /**
     * ��ȡ��Ԫ����������Ϊ�������͵�����
     * 
     * @param cell
     *            Excel��Ԫ��
     * @return String ��Ԫ����������
     */
    private String getDateCellValue(HSSFCell cell) {
        String result = "";
        try {
            int cellType = cell.getCellType();
            if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
                Date date = cell.getDateCellValue();
                result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
                        + "-" + date.getDate();
            } else if (cellType == HSSFCell.CELL_TYPE_STRING) {
                String date = getStringCellValue(cell);
                result = date.replaceAll("[����]", "-").replace("��", "").trim();
            } else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
                result = "";
            }
        } catch (Exception e) {
            System.out.println("���ڸ�ʽ����ȷ!");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ����HSSFCell������������
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // �жϵ�ǰCell��Type
            switch (cell.getCellType()) {
            // �����ǰCell��TypeΪNUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // �жϵ�ǰ��cell�Ƿ�ΪDate
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // �����Date������ת��ΪData��ʽ
                    
                    //����1�������ӵ�data��ʽ�Ǵ�ʱ����ģ�2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //����2�������ӵ�data��ʽ�ǲ�����ʱ����ģ�2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                    
                }
                // ����Ǵ�����
                else {
                    // ȡ�õ�ǰCell����ֵ
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // �����ǰCell��TypeΪSTRIN
            case HSSFCell.CELL_TYPE_STRING:
                // ȡ�õ�ǰ��Cell�ַ���
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // Ĭ�ϵ�Cellֵ
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    public static void main(String[] args) {
        try {
            
            ExcelReader excelReader = new ExcelReader();
            
            Collection<String> unSync = getUnSyncUser(excelReader);
            int i = 0;
            for (String content:unSync) {
            	i ++;
            	System.out.println(i + "	" + content);
            }
            
            Map<Integer, String> oaUser = getOAUser(excelReader);
            
            
        } catch (FileNotFoundException e) {
            System.out.println("δ�ҵ�ָ��·�����ļ�!");
            e.printStackTrace();
        }
    }

    /**
     * ��ȡͬ��ʧ�ܵĶ��û���oa���У�sr��û�е�
     * @param excelReader
     * @return
     * @throws FileNotFoundException
     */
	private static Collection<String> getUnSyncUser(ExcelReader excelReader)
			throws FileNotFoundException {
		// �Զ�ȡExcel���������
//      InputStream is = new FileInputStream("D:\\�û�\\OA���͵��û�.xls");
//      String[] title = excelReader.readExcelTitle(is);
//      System.out.println("���Excel���ı���:");
//      for (String s : title) {
//          System.out.print(s + " ");
//      }
		
		// �Զ�ȡExcel������ݲ���
		Map<Integer, String> oaMap = getOAUser(excelReader);
		
		Map<Integer, String> srMap = getSRUser(excelReader);
		
//		System.out.println("���OAExcel��������:");
//		Set<String> exist = new HashSet<String>();
//		int repeatCount = 0;
//		for (int i = 1; i <= oaMap.size(); i++) {
//			String content = oaMap.get(i);
//			if(exist.contains(content)) {
//				repeatCount ++;
//				System.out.println("������" + i + "	�ظ�������" + repeatCount + "	�ظ����ݣ�" + oaMap.get(i));
//			}
//			exist.add(content);
//		}
		
		//oa���У�sr��û�е��û�
		Collection<String> all = oaMap.values();
		all.removeAll(srMap.values());
		return all;
	}

	private static Map<Integer, String> getSRUser(ExcelReader excelReader)
			throws FileNotFoundException {
		InputStream is3 = new FileInputStream("D:\\�û�\\����ϵͳ��ʾ�û���Ϣ.xls");
		Map<Integer, String> srMap = excelReader.readExcelColContent(is3, 0);
		return srMap;
	}

	private static Map<Integer, String> getOAUser(ExcelReader excelReader)
			throws FileNotFoundException {
		InputStream is2 = new FileInputStream("D:\\�û�\\OA���͵��û�.xls");
		Map<Integer, String> oaMap = excelReader.readExcelColContent(is2, 2);
		return oaMap;
	}
}