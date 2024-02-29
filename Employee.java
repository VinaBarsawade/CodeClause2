package codeclause;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.Statement;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Employee extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	
	private JLabel lblNewLabel_2;
	private JTextField id;
	private JLabel lblpic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	new Employee();
		
			
		}
	
	/**
	 * Create the frame.
	 */
	public Employee() {
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(164, 130, 198));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Employee Section");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(154, 24, 696, 75);
		contentPane.add(lblNewLabel);
		//Attendencenum=0;
		btnNewButton = new JButton("Mark Attendence");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/EmployeeDetails1";
					String user="root";
					String pass="Sanjay@417";
					Connection con=DriverManager.getConnection(url,user,pass);
					
					try {
							int employeeId = Integer.parseInt(id.getText());
							String query = "UPDATE EmployeeInfo2 SET Attendence = Attendence + 1 WHERE ID = '" + employeeId + "'";
							Statement stmt = con.createStatement();
							int rowsUpdated = stmt.executeUpdate(query);
							if (rowsUpdated > 0) {
								JOptionPane.showMessageDialog(Employee.this," Attendence Marked successfully");
							 
							} else {
								JOptionPane.showMessageDialog(Employee.this," Invalid Id\n Try again");
							}
							
							String queUpdatePay="UPDATE EmployeeInfo2 SET PaymentDet= Attendence*2000 WHERE ID = '" + employeeId + "'";
							stmt.executeUpdate(queUpdatePay);
							EmployeeManagement emp = new EmployeeManagement();
		                    emp.setVisible(true);
		                    Employee.this.dispose();
				           
					}
					catch(Exception e1) {
						System.out.println(e1);
					}
					
					
				}
				
				catch(Exception e1) {
					System.out.println(e1);
				}
					
				}
				
				
			
		});
		btnNewButton.setBounds(661, 332, 164, 57);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Enter your Id to Mark attendence");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(614, 136, 295, 30);
		contentPane.add(lblNewLabel_2);
		
		id = new JTextField();
		
		id.setBounds(695, 202, 96, 30);
		contentPane.add(id);
		id.setColumns(10);
		
		lblpic = new JLabel("");
		lblpic.setBackground(new Color(180, 175, 207));
		Image img=new ImageIcon(this.getClass().getResource("/atd.png")).getImage();
		lblpic.setIcon(new ImageIcon(img));
		lblpic.setBounds(0, 93, 566, 370);
		contentPane.add(lblpic);
	
	}
}
