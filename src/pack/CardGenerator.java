package pack;
/* 
	For this part of the project, we have used the popular Apache POI library to write in 
	Word Documents. ID cards are dynamically generated taking the employee data from the Excel file
	and the text is added to the word document using the methods of Apache POI library. 
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

public class CardGenerator { 
    public static void main(String[] args) throws Exception {
        generateID("dp.jpg", "Abir AL Mahdi Akhand", 2221699642L, "Jr Software Engineer", "IT Department");
    }
    
    public static void generateID(String img, String name, long id, String designation, String department) throws Exception {
    	try (XWPFDocument doc = new XWPFDocument()) { // create an instance of the file
            OutputStream os = new FileOutputStream("ID-"+id+".docx"); // Create an instance of FileOutputStream class with the file name

            // Create a new paragraph
            XWPFParagraph paragraph = doc.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER); // Set paragraph alignment to center

            // Add the company name
            XWPFRun companyName = paragraph.createRun();
            companyName.setBold(true);
            companyName.setItalic(false);
            companyName.setFontSize(14);
            companyName.addBreak();
            companyName.setText("XYZ Industries Ltd.");
            companyName.addBreak();
            companyName.addBreak();

            // Add the image
            String imgFile = img; // the image file name
            InputStream is = new FileInputStream(imgFile); // create an instance for the FileInputStream class with the image name passed as an arg
            // method for adding the picture to the word document
            XWPFPicture picture = companyName.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, (int)Math.rint(12700*50), (int)Math.rint(12700*50));
            is.close();
            companyName.addBreak();
            companyName.addBreak();

            // Add the employee name
            XWPFRun employeeName = paragraph.createRun();
            employeeName.setBold(true);
            employeeName.setItalic(false);
            employeeName.setFontSize(10);
            employeeName.setText(name);
            employeeName.addBreak();

            // Add the employee details
            XWPFRun employeeDetails = paragraph.createRun();
            employeeDetails.setText("ID no. "+id);
            employeeDetails.addBreak();
            employeeDetails.setBold(false);
            employeeDetails.setItalic(false);
            employeeDetails.setFontSize(10);
            employeeDetails.setText(designation);
            employeeDetails.addBreak();
            employeeDetails.setText(department);
            employeeDetails.addBreak();
            employeeDetails.addBreak();

            // Add disclaimers
            XWPFRun disclaimers = paragraph.createRun();
            disclaimers.setFontSize(10);
            disclaimers.setBold(true);
            disclaimers.setText("If found, please return it to: ");
            disclaimers.addBreak();

            XWPFRun disclaimers2 = paragraph.createRun();
            disclaimers2.setFontSize(10);
            disclaimers2.setText("XYZ Headquarters,");
            disclaimers2.addBreak();
            disclaimers2.setText("Dhaka, Bangladesh.");
            disclaimers2.addBreak();

            // Add border
            paragraph.setIndentationLeft(3000); // setting up the space horizontally
            paragraph.setIndentationRight(3000);
            paragraph.setBorderBottom(Borders.DOUBLE);
            paragraph.setBorderTop(Borders.DOUBLE);
            paragraph.setBorderLeft(Borders.DOUBLE);
            paragraph.setBorderRight(Borders.DOUBLE);

            // Write the document to file
            doc.write(os);
            os.close(); // Close the file
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}