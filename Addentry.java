package codeclause;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.awt.event.ActionEvent;
import java.awt.Color;

public class Addentry extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField postField;
	private JTextField atdField;
	private JTextField payField;
	private JTextField editid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addentry frame = new Addentry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Addentry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idField = new JTextField();
		idField.setBounds(186, 46, 113, 32);
		contentPane.add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(186, 135, 113, 32);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(186, 241, 113, 32);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		postField = new JTextField();
		postField.setBounds(703, 46, 113, 32);
		contentPane.add(postField);
		postField.setColumns(10);
		
		atdField = new JTextField();
		atdField.setBounds(703, 135, 113, 32);
		contentPane.add(atdField);
		atdField.setColumns(10);
		
		payField = new JTextField();
		payField.setBounds(703, 241, 113, 32);
		contentPane.add(payField);
		payField.setColumns(10);
		
		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblid.setBounds(55, 45, 76, 29);
		contentPane.add(lblid);
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblname.setBounds(55, 136, 76, 29);
		contentPane.add(lblname);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblemail.setBounds(55, 242, 76, 29);
		contentPane.add(lblemail);
		
		JLabel lblpost = new JLabel("Post");
		lblpost.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpost.setBounds(585, 45, 76, 29);
		contentPane.add(lblpost);
		
		JLabel lblday = new JLabel("Worked Days");
		lblday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblday.setBounds(573, 136,  88, 29);
		contentPane.add(lblday);
		
		JLabel lblpay = new JLabel("Payment");
		lblpay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpay.setBounds(573, 242,  76, 29);
		contentPane.add(lblpay);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/EmployeeDetails1";
					String user="root";
					String pass="Sanjay@417";
					Connection con=DriverManager.getConnection(url,user,pass);
					System.out.println("Database Connected successfully");
			 try {
				                
				   String query = "INSERT INTO EmployeeInfo2 VALUES (?, ?, ?, ?, ?, ?)";
				   PreparedStatement pstmt = con.prepareStatement(query);
				               
				   pstmt.setInt(1, Integer.parseInt(idField.getText()));
				   pstmt.setString(2, nameField.getText());
				   pstmt.setString(3, emailField.getText());
				   pstmt.setString(4, postField.getText());
				   pstmt.setInt(5, Integer.parseInt(atdField.getText()));
				   pstmt.setInt(6, Integer.parseInt(payField.getText()));

				              
				   pstmt.executeUpdate();

				                
				  JOptionPane.showMessageDialog(Addentry.this,"Successfully added");
				 
			            con.close(); 
			            Manager managerFrame = new Manager();
	                    managerFrame.setVisible(true);
	                    Addentry.this.dispose();
			        } catch (Exception ex) {
			            System.out.println(ex);
			        }
			}
					catch(Exception e1) {
						System.out.println(e1);
					}
		
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(433, 412, 127, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/EmployeeDetails1";
					String user="root";
					String pass="Sanjay@417";
					Connection con=DriverManager.getConnection(url,user,pass);
					System.out.println("Database Connected successfully");
				
						  try {
							   String query = "DELETE FROM EmployeeInfo2 WHERE id = ?";
				                PreparedStatement pstmt = con.prepareStatement(query);

				              
				                pstmt.setInt(1, Integer.parseInt(editid.getText()));

				                int rowsAffected = pstmt.executeUpdate();

				                
				                if (rowsAffected > 0) {
				                    JOptionPane.showMessageDialog(Addentry.this,"Successfully deleted");
				                } else {
				                	JOptionPane.showMessageDialog(Addentry.this,"Not Found");
				                }
				                System.out.println("New entry added successfully!");
			            con.close(); 
			            Manager managerFrame = new Manager();
	                    managerFrame.setVisible(true);
	                    Addentry.this.dispose();
			        } catch (Exception ex) {
			            System.out.println(ex);
			        }
			}
					catch(Exception e1) {
						System.out.println(e1);
					}
		
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(172, 412, 127, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setBackground(new Color(255, 128, 64));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/EmployeeDetails1";
					String user="root";
					String pass="Sanjay@417";
					Connection con=DriverManager.getConnection(url,user,pass);
					System.out.println("Database Connected successfully");
				 try {
				 String query = "UPDATE EmployeeInfo2 SET Post=?,Attendence=?,PaymentDet=? WHERE ID=?";
				  PreparedStatement pstmt = con.prepareStatement(query);

				  pstmt.setString(1,(postField.getText()));
				              
				  pstmt.setInt(2,Integer.parseInt(atdField.getText()));
				  pstmt.setInt(3,Integer.parseInt(payField.getText()));
				  pstmt.setInt(4, Integer.parseInt(editid.getText()));
				           

				        int rowsAffected = pstmt.executeUpdate();

				                
				        if (rowsAffected > 0) {
				        	JOptionPane.showMessageDialog(Addentry.this,"Successfully Updated");
				        } else {
				        	JOptionPane.showMessageDialog(Addentry.this,"Not Found");
				        }
				                System.out.println("New entry added successfully!");
			            con.close(); 
			            Manager managerFrame = new Manager();
	                    managerFrame.setVisible(true);
	                    Addentry.this.dispose();
			        } catch (Exception ex) {
			            System.out.println(ex);
			        }
			}
					catch(Exception e1) {
						System.out.println(e1);
					}
		
			}
		});
			
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(695, 412, 121, 41);
		contentPane.add(btnNewButton_2);
		
		editid = new JTextField();
		editid.setBounds(446, 354, 96, 32);
		contentPane.add(editid);
		editid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter ID of Employee you want to Update or Delete");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(323, 320, 350, 24);
		contentPane.add(lblNewLabel);
		
	}
}
