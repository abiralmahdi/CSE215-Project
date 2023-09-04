package exceptionsPack;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class InvalidInputException extends Exception {
    public InvalidInputException(String str) {
        super("Invalid input for " + str);
        JOptionPane.showMessageDialog(null, "Invalid input for "+str);
    }
}