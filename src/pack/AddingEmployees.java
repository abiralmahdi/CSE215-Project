package pack;
/* 
	For this part of the project, we are storing the employee data in an excel spreadsheet, 
	using the popular Apache POI library for file handling
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

public class AddingEmployees {
	public static void addEmployee(long id, String name2, String fname2, String mname2, String email2, long contact2, String designation2, String department2) throws IOException {
		String fileName = "EmployeeData.xlsx";
        File file = new File(fileName);
        XSSFWorkbook wb;
        XSSFSheet sheet2;
        if (file.exists()) {
            // If file exists, read it
            FileInputStream fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
            sheet2 = wb.getSheet("Sheet1"); // Creating a new sheet
            fis.close();
        } else {
            // If file doesn't exist, create a new workbook
            wb = new XSSFWorkbook();
            sheet2 = wb.createSheet("Sheet1");
        }
        int rownum = sheet2.getLastRowNum(); // Get the last row number of the file
        XSSFRow row2 = sheet2.createRow(rownum + 1); 
        XSSFCell idNumber = row2.createCell(0);
        XSSFCell name = row2.createCell(1);
        XSSFCell contact = row2.createCell(2);
        XSSFCell fname = row2.createCell(3);
        XSSFCell mname = row2.createCell(4);
        XSSFCell email = row2.createCell(5);
        XSSFCell designation = row2.createCell(6);
        XSSFCell department = row2.createCell(7);
        // Setting the values of the cells
        idNumber.setCellValue(id);
        name.setCellValue(name2);
        contact.setCellValue(contact2);
        fname.setCellValue(fname2);
        mname.setCellValue(mname2);
        email.setCellValue(email2);
        designation.setCellValue(designation2);
        department.setCellValue(department2);
        FileOutputStream fos = new FileOutputStream(file);
        wb.write(fos); // Write to the file
        fos.close();
        wb.close();
	}
	
	public static String[][] readExcelData(String filePath, String sheetName) {
		String[][] dataArr = new String[1000][8];
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rows = 0;
            
            for (Row row : sheet) {
            	int cols = 0;
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            dataArr[rows][cols] = cell.getStringCellValue();
                            cols++;
                            break;
                        case NUMERIC:
                            dataArr[rows][cols] = cell.getNumericCellValue()+"";
                            cols++;
                            break;
                        case BOOLEAN:
                            dataArr[rows][cols] = cell.getBooleanCellValue()+"";
                            cols++;
                            break;
                        case BLANK:
                            dataArr[rows][cols] = "";
                            cols++;
                            break;
					default:
						break;
                    }
                }
                rows++;
            }

            workbook.close();
            fis.close();
        } catch (IOException e) {
           e.printStackTrace();
           File f = new File(filePath);
        }
        return dataArr;
    }
	
	
	
    public static void main(String[] args) throws IOException {
    	readExcelData("EmployeeData.xlsx", "Sheet1");
    }
}