package exceptionsPack;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class PrimaryKeyException extends Exception{
	public PrimaryKeyException(){
		super("Another employee with the same ID exists.");
		JOptionPane.showMessageDialog(null, "Another employee with the same ID exists. Please enter a unique ID");
	}
}