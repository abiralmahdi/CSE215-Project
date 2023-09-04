package pack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginGUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton login_bt;
	private JLabel label1, username_lb, pass_lb;
	private JTextField username_tf;
	private JPasswordField pass_pf;
	private String username="admin",pass="asd123";
	
	Font font= new Font("Arial", Font.BOLD,16);
	
	LoginGUI(){
	
	
	//label works
	label1= new JLabel(new ImageIcon("Intro_500x600.png"));
	label1.setBounds(0,0,450,600);
	this.add(label1);
	label1.repaint();
	
	username_lb= new JLabel ("USERNAME");
	username_lb.setBounds(470,100,200,40);
	this.add(username_lb);
	username_lb.setForeground(Color.WHITE);
	username_lb.setFont(font);
	

	username_tf= new JTextField ();
	username_tf.setBounds(470,150,300,40);
	this.add(username_tf);
	
	pass_lb= new JLabel ("PASSWORD");
	pass_lb.setBounds(470,200,200,40);
	this.add(pass_lb);
	pass_lb.setForeground(Color.WHITE);
	pass_lb.setFont(font);
	

	pass_pf= new JPasswordField ();
	pass_pf.setBounds(470,250,300,40);
	this.add(pass_pf);
	
	login_bt = new JButton("Log in");
	login_bt.setBounds(570,320,100,40);
	this.add(login_bt);
	login_bt.addActionListener(this);
	
	
	//Frame works
		this.setLayout(null);
		this.setTitle("Employee Management and ID Card Generation System (CSE215L project)");
		this.setVisible(true);
		
		this.setSize(800,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(0x123456));
		//add image icon
		ImageIcon image = new ImageIcon("icon.png");
		this.setIconImage(image.getImage());
     }
	
	public void grantAccess() {
		GUIDevelopment gui = new GUIDevelopment();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==login_bt)
		{
		String uName= username_tf.getText();
		@SuppressWarnings("deprecation")
		String uPass= pass_pf.getText();
		if(uName.equals(username) && uPass.equals(pass))
		{
			int result = JOptionPane.showOptionDialog(null, "Access Granted", "Authentication Successful", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "OK" }, "OK");
			if (result == JOptionPane.OK_OPTION) {
	            // Call your function here
	            grantAccess();
	            this.setVisible(false);
	        }
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Incorrect credentials!");
		}
		}
	}
}


public class LoginGUI2{
	public static void main(String[] args) {
		LoginGUI interfaces = new LoginGUI();
	}
}