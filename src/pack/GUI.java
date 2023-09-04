package pack;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import exceptionsPack.InvalidInputException;
import exceptionsPack.PrimaryKeyException;

@SuppressWarnings("serial")
class GUIDevelopment extends JFrame{
	 
	public GUIDevelopment(){
		
		// Jubayed and Mashrura
		super.setTitle("Employee Management and ID Card Generation System (CSE215L project)");
		 //Label Work
        JLabel label1 = new JLabel("Employee Management and ID Card Generation System");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Cambria", Font.BOLD, 25));     

        //Frame Work
        this.setBounds(0, 0, 1280, 600);
        this.setSize(520, 500);
        this.setLayout(new BorderLayout(5, 5));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Making Panels
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JTable table = new JTable(); 

        panel2.setLayout(new GridLayout(0, 1));
        panel1.setPreferredSize(new Dimension(100, 50));
        panel2.setPreferredSize(new Dimension(400, 100));
        panel3.setPreferredSize(new Dimension(0, 100));
        panel4.setPreferredSize(new Dimension(0, 0));  
        panel1.add(Box.createVerticalGlue());   
        panel1.add(label1);

        
        /* Tasnim islam plabon*/
     // create table
     Dimension tableSize = new Dimension(800, 500); // Set the size of the table
     Object[] columns = { "No", "Name", "Father Name", "Mother Name", "Contact", "Email", "Designation", "Department" };
     DefaultTableModel model = new DefaultTableModel();
     model.setColumnIdentifiers(columns);
     // set the model to the table
     table.setModel(model);

     table.setPreferredScrollableViewportSize(tableSize);
     // Change A JTable Background Color, Font Size, Font Color, Row Height
     table.setBackground(Color.WHITE);
     table.setForeground(Color.black);
     Font font = new Font("Cambria", 1, 12);
     table.setFont(font);
     table.setRowHeight(50);
     
     // create JScrollPane
     JScrollPane pane = new JScrollPane(table);
     pane.setBounds(0, 0, 980, 200);
     
     
     
     
     // Jubayed and Mashrura
     // Create and add labels and text fields to panel2
     panel2.setLayout(new GridLayout(0, 1));

        JLabel idNoLabel = new JLabel("ID Number:"); //creating Lable
        JTextField idNoField = new JTextField();  //creating textfield
        idNoField.setFont(new Font("Consolas", Font.PLAIN, 15)); //editing textfield
        idNoField.setForeground(Color.BLACK);
        idNoLabel.setForeground(Color.BLACK); //color of label

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Consolas", Font.PLAIN, 15));
        nameLabel.setForeground(Color.BLACK);


        JLabel fathersNameLabel = new JLabel("Father's Name:");
        JTextField fathersNameField = new JTextField();
        fathersNameField.setFont(new Font("Consolas", Font.PLAIN, 15));
        fathersNameLabel.setForeground(Color.BLACK);

        JLabel mothersNameLabel = new JLabel("Mother's Name:");
        JTextField mothersNameField = new JTextField();
        mothersNameField.setFont(new Font("Consolas", Font.PLAIN, 15));
        mothersNameLabel.setForeground(Color.BLACK);

        JLabel contactLabel = new JLabel("Contact:");
        JTextField contactField = new JTextField();
        contactField.setFont(new Font("Consolas", Font.PLAIN, 15));
        contactLabel.setForeground(Color.BLACK);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Consolas", Font.PLAIN, 15));
        emailLabel.setForeground(Color.BLACK);

        JLabel designationLabel = new JLabel("Designation:");
        JTextField designationField = new JTextField();
        designationField.setFont(new Font("Consolas", Font.PLAIN, 15));
        designationLabel.setForeground(Color.BLACK);
        
        String[] options = { "IT Department", "HR Department", "Marketing Department", "Electronic Department" };
        JLabel departmentLabel = new JLabel("Department:");
        JComboBox<String> departmentField = new JComboBox<>(options);
        departmentField.setFont(new Font("Consolas", Font.PLAIN, 15));
        departmentField.setForeground(Color.BLACK);
        departmentField.setSelectedIndex(0);// Set initial selected item

        String selectedOption = (String) departmentField.getSelectedItem();


        panel2.add(idNoLabel);
        panel2.add(idNoField);
        panel2.add(nameLabel);
        panel2.add(nameField);
        panel2.add(fathersNameLabel);
        panel2.add(fathersNameField);
        panel2.add(mothersNameLabel);
        panel2.add(mothersNameField);
        panel2.add(contactLabel);
        panel2.add(contactField);
        panel2.add(emailLabel);
        panel2.add(emailField);
        panel2.add(designationLabel); 
        panel2.add(designationField);
        panel2.add(departmentLabel); 
        panel2.add(departmentField);

        panel2.add(Box.createVerticalStrut(10)); // Create a gap between the "Submit" button and the passwordField

        JButton submitButton = new JButton("Submit and Generate ID Card");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        
        panel2.add(submitButton);
        panel2.add(Box.createVerticalStrut(1));
        panel2.add(deleteButton);
        panel2.add(Box.createVerticalStrut(1));
        panel2.add(updateButton);
        submitButton.setActionCommand("Submit");
        
        // Add Search ID components to panel4
        panel4.setLayout(new FlowLayout(FlowLayout.LEADING)); //so that it stay in top
        
        JLabel searchIdLabel = new JLabel("Search ID:");
        JTextField searchIdField = new JTextField();
        searchIdField.setPreferredSize(new Dimension(150, 30));
        searchIdField.setFont(new Font("Consolas", Font.PLAIN, 15));
        searchIdLabel.setForeground(Color.BLACK);
        
        JButton searchButton = new JButton("Search");
        JButton resetButton = new JButton("Reset Table");
        
        panel4.add(searchIdLabel);
        panel4.add(searchIdField);
        panel4.add(searchButton);
        panel4.add(resetButton);
        panel4.add(pane, BorderLayout.CENTER);
        
        
        // Add components to the frame
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.WEST);
        this.add(panel3, BorderLayout.EAST);
        this.add(panel4, BorderLayout.CENTER);
        
        // Set frame properties
        ((JComponent) this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setSize(1260, 690);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make the frame visible
        this.setVisible(true);
        this.setResizable(false);

        
        
        // Abir Al Mahdi
		setRows(model); // Retrieve the data from excel file and set it to rows upon starting of the program 
  
        
     // Triggers when a row is clicked: shows the data of the row in the form
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            	String dataArr[] = getDataFromSelectedRow(table);
        		idNoField.setText(dataArr[0]);
        		nameField.setText(dataArr[1]);
        		fathersNameField.setText(dataArr[2]);
        		mothersNameField.setText(dataArr[3]);
        		contactField.setText(dataArr[4]);
        		emailField.setText(dataArr[5]);
        		designationField.setText(dataArr[6]);
        		
            }
        });
        
        // Triggers upon pressing the Submit button: Adds data to Excel spreadsheet and generates ID in Word Document.
        submitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try {
					submitAction(idNoField,nameField,fathersNameField,mothersNameField,contactField,emailField,designationField, selectedOption,model);
				} catch (InvalidInputException e1) {
					e1.getMessage();
				} catch (PrimaryKeyException e1) {
					e1.printStackTrace();
				}
			}
        });
        
      // Triggers upon clicking the delete button. Deletes the selected row
        deleteButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try {
					deleteEmployee(Double.parseDouble(idNoField.getText()), model);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
			}
        });
        
     // Triggers upon pressing the Submit button: Adds data to Excel spreadsheet and generates ID in Word Document.
        searchButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String [][] dataArr = AddingEmployees.readExcelData("C:/Users/HP/Desktop/Course Materials/3rd Semester (Spring-23)/CSE215+L/OwnPrac/EmployeeIDGenerator/EmployeeData.xlsx", "Sheet1");
					String [][] selectedData = new String[1][8];
					System.out.print(dataArr[0][0]);
					for (int i=0; dataArr[i][0] != null; i++) {
						if (Double.parseDouble(dataArr[i][0]) == Integer.parseInt(searchIdField.getText())) {
							selectedData[0] = dataArr[i];
						}
					}
					
					model.setRowCount(0);
					
					for (int i=0; i<1; i++) {
						Object[] row = new Object[8];
						row[0] = selectedData[i][0];
						row[1] = selectedData[i][1];
			            row[2] = selectedData[i][3];
			            row[3] = selectedData[i][4];
			            row[4] = selectedData[i][2];
			            row[5] = selectedData[i][5];
			            row[6] = selectedData[i][6];
			            row[7] = selectedData[i][7];
			            model.addRow(row);
					}
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
        });
        
        // Triggers upon clicking the update button. Updates the employee record
        updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateEmployeeData(Double.parseDouble(idNoField.getText()), model, nameField, fathersNameField, mothersNameField, contactField, emailField, selectedOption, designationField);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				
			}
        	
        });
        
        resetButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setRows(model);
        	}
        });

        
  
	}
	public static void setRows(DefaultTableModel model) {
		try {
			String [][] dataArr = AddingEmployees.readExcelData("C:/Users/HP/Desktop/Course Materials/3rd Semester (Spring-23)/CSE215+L/OwnPrac/EmployeeIDGenerator/EmployeeData.xlsx", "Sheet1");
			model.setRowCount(0);
			for (int i=0; dataArr[i][0] != null; i++) {
				Object[] row = new Object[8];
				row[0] = dataArr[i][0];
				row[1] = dataArr[i][1];
	            row[2] = dataArr[i][3];
	            row[3] = dataArr[i][4];
	            row[4] = dataArr[i][2];
	            row[5] = dataArr[i][5];
	            row[6] = dataArr[i][6];
	            row[7] = dataArr[i][7];
	            model.addRow(row);
			}
		}
		catch (Exception e) {}
	}
	
	public static String[] getDataFromSelectedRow(JTable table){
		String [] dataArr = new String[7];
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) { // Check if a row is selected
			for (int i=0; i<7; i++) {
				dataArr[i] = (String) table.getValueAt(selectedRow, i);// Get the data from the selected row
			}
		    
		} else {
		    System.out.println("No row is selected.");
		}
		return dataArr;
	}
	
	// Triggers upon clicking the submit button
	public static void submitAction(JTextField idNoField,JTextField nameField,JTextField fathersNameField,JTextField mothersNameField,JTextField contactField,JTextField emailField,JTextField designationField, String selectedOption,DefaultTableModel model) throws InvalidInputException, PrimaryKeyException{
		try {
			try {
				try {
					int a = Integer.parseInt(contactField.getText());
				}
				catch (NumberFormatException e){
					throw new InvalidInputException("contact");
				}
				try {
					int a = Integer.parseInt(idNoField.getText());
				}
				catch (NumberFormatException e){
					throw new InvalidInputException("ID");
				}
				if (hasDuplicate(Integer.parseInt(idNoField.getText()))) {
					throw new PrimaryKeyException();
				}
				AddingEmployees.addEmployee(Long.parseLong(idNoField.getText()), nameField.getText(), fathersNameField.getText(), mothersNameField.getText(), emailField.getText(), Long.parseLong(contactField.getText()), designationField.getText(), selectedOption);
				setRows(model);
				try {
					CardGenerator.generateID("dp.jpg", nameField.getText(), Long.parseLong(idNoField.getText()), designationField.getText(), "IT Dept.");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				idNoField.setText("0");
	    		nameField.setText("");
	    		fathersNameField.setText("");
	    		mothersNameField.setText("");
	    		contactField.setText("");
		   		emailField.setText("");
		   		designationField.setText("");
			}
			catch (IOException e) {
				e.printStackTrace();;
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}
	}
	
	// checks if duplicate Employee ID exists
	public static boolean hasDuplicate(double id) {
		boolean duplicate = false;
		String[][] dataArr = AddingEmployees.readExcelData("C:/Users/HP/Desktop/Course Materials/3rd Semester (Spring-23)/CSE215+L/OwnPrac/EmployeeIDGenerator/EmployeeData.xlsx", "Sheet1");
		for (int i=0; dataArr[i][0] != null; i++) {
			if (Double.parseDouble(dataArr[i][0]) == (double)id) {
				duplicate = true;
			}
		}
		
		return duplicate;
	}
	
	// deletes an employee data from the record and the employee ID card
	public static void deleteEmployee(double id, DefaultTableModel model) throws IOException {
	    String fileName = "C:/Users/HP/Desktop/Course Materials/3rd Semester (Spring-23)/CSE215+L/OwnPrac/EmployeeIDGenerator/EmployeeData.xlsx";
	    File file = new File(fileName);
	    
	    FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet2 = wb.getSheet("Sheet1");
	    
	    String[][] dataArr = AddingEmployees.readExcelData(fileName, "Sheet1");
	    for (int i = 0; dataArr[i][0] != null; i++) { // Use dataArr.length to determine the number of rows
	        if (Double.parseDouble(dataArr[i][0]) == id) {
	            Row row = sheet2.getRow(i);
	            if (row != null) {
	                sheet2.removeRow(row);
	                boolean isDeleted = deleteWordDocument("C:/Users/HP/Desktop/Course Materials/3rd Semester (Spring-23)/CSE215+L/OwnPrac/EmployeeIDGenerator/ID-"+(int)Double.parseDouble(dataArr[i][0])+".docx");
	                if (isDeleted) {
	                    System.out.println("Word document deleted successfully.");
	                } else {
	                    System.out.println("Failed to delete the Word document.");
	                }
	                
	                try {
	                	sheet2.shiftRows(i + 1, sheet2.getLastRowNum(), -1); // Shift rows above the deleted row up
	                } catch (IllegalArgumentException e) {
	                	System.out.println(e.getMessage());
	                }
	                System.out.println("Row " + (i + 1) + " deleted successfully.");
	            } else {
	                System.out.println("Row " + (i + 1) + " does not exist.");
	            }
	        }
	    }
	    fis.close(); // Close the input stream
	    FileOutputStream fos = new FileOutputStream(file); // Open FileOutputStream after modifications
	    wb.write(fos); // Write changes to the file
	    wb.close();
	    fos.close(); // Close the output stream
	    setRows(model);
	}
	// Function to delete any word document
	public static boolean deleteWordDocument(String filePath) {
        File file = new File(filePath);
        
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }
	
	public static void updateEmployeeData(double id, DefaultTableModel model, JTextField namefield, JTextField fathersNamefield, JTextField mothersNamefield, JTextField contactField, JTextField emailfield, String departmentField, JTextField designationField) throws IOException{
		String fileName = "C:/Users/HP/Desktop/Course Materials/3rd Semester (Spring-23)/CSE215+L/OwnPrac/EmployeeIDGenerator/EmployeeData.xlsx";
	    File file = new File(fileName);
	    
	    FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet2 = wb.getSheet("Sheet1");
	    
	    String[][] dataArr = AddingEmployees.readExcelData(fileName, "Sheet1");
	    for (int i = 0; dataArr[i][0] != null; i++) { // Use dataArr.length to determine the number of rows
	        if (Double.parseDouble(dataArr[i][0]) == id) {
	            Row row = sheet2.getRow(i);
	            if (row != null) {
	                sheet2.removeRow(row);
	                boolean isDeleted = deleteWordDocument("C:/Users/HP/Desktop/Course Materials/3rd Semester (Spring-23)/CSE215+L/OwnPrac/EmployeeIDGenerator/ID-"+(int)Double.parseDouble(dataArr[i][0])+".docx");
	                if (isDeleted) {
	                    System.out.println("Word document deleted successfully.");
	                } else {
	                    System.out.println("Failed to delete the Word document.");
	                }
	                
	                try {
	                	 XSSFRow row2 = sheet2.createRow(i); 
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
	                     name.setCellValue(namefield.getText());
	                     contact.setCellValue(contactField.getText());
	                     fname.setCellValue(fathersNamefield.getText());
	                     mname.setCellValue(mothersNamefield.getText());
	                     email.setCellValue(emailfield.getText());
	                     designation.setCellValue(designationField.getText());
	                     department.setCellValue(departmentField);
	                } catch (IllegalArgumentException e) {
	                	System.out.println(e.getMessage());
	                }
	                System.out.println("Row " + (i + 1) + " updated successfully.");
	            } else {
	                System.out.println("Row " + (i + 1) + " does not exist.");
	            }
	        }
	    }
	    fis.close(); // Close the input stream
	    FileOutputStream fos = new FileOutputStream(file); // Open FileOutputStream after modifications
	    wb.write(fos); // Write changes to the file
	    wb.close();
	    fos.close(); // Close the output stream
	    setRows(model);
	}
}