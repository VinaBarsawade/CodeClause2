package codeclause;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Manager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	public static void main(String[] args) {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1157, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea lblinfo = new JTextArea();
		lblinfo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane(lblinfo);
		scrollPane.setBounds(10, 10, 1123, 326);
		contentPane.add(scrollPane);
		
		
		JButton btndis = new JButton("Display");
		btndis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/EmployeeDetails1";
					String user="root";
					String pass="Sanjay@417";
					Connection con=DriverManager.getConnection(url,user,pass);
					System.out.println("Database Connected successfully");
					
					try {
						
						Statement stmt = con.createStatement();
			            String query = "SELECT * FROM EmployeeInfo2";
			            ResultSet rs = stmt.executeQuery(query);
			            
			            while (rs.next()) {
			                int id = rs.getInt(1);
			                String name = rs.getString(2);
			                String eid=rs.getString(3);
			                String post=rs.getString(4);
			                int atd=rs.getInt(5);
			                int pay=rs.getInt(6);
			                
			                lblinfo.append("ID: " + id + "\n");
			                lblinfo.append("Name: " + name + "\n");
			                lblinfo.append("Email: " + eid + "\n");
			                lblinfo.append("Post: " + post + "\n");
			                lblinfo.append("Worked Days: " + atd + "\n");
			                lblinfo.append("PayRoll: " + pay + "\n\n");
			            }
			            
			            con.close(); 
			        } catch (Exception ex) {
			            System.out.println(ex);
			        }
				}
					catch(Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btndis.setBackground(new Color(0, 255, 64));
		btndis.setBounds(498, 519, 163, 62);
		contentPane.add(btndis);
		
		JButton btnadd = new JButton("Add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Addentry anotherFrame =new Addentry();
				 anotherFrame.setVisible(true);
				 Manager.this.setVisible(false);
				 btnadd.setEnabled(false);
			}
		});
		btnadd.setBounds(284, 522, 163, 56);
		contentPane.add(btnadd);
		
		JButton btndel = new JButton("Delete");
		btndel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addentry anotherFrame=new Addentry();
				 anotherFrame.setVisible(true);
				Manager.this.setVisible(false);
				btndel.setEnabled(false);
			}
		});
		btndel.setBounds(693, 522, 163, 56);
		contentPane.add(btndel);
		
		JButton btnNewButton = new JButton("Back <--");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 EmployeeManagement anotherFrame =new  EmployeeManagement ();
				 anotherFrame.setVisible(true);
				 Manager.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 582, 90, 30);
		contentPane.add(btnNewButton);
	}
}
