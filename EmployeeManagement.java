package codeclause;

import java.awt.EventQueue;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class EmployeeManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField eid;
	private JPasswordField epass;
	private JTextField mid;
	private JPasswordField mpass;
	private HashMap<String,String>idPasswordMap;
	private HashMap<String,String>midPasswordMap;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManagement frame = new EmployeeManagement ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**

	/**
	 * Create the frame.
	 */
	public EmployeeManagement() {
		idPasswordMap=new HashMap<>();
		idPasswordMap.put("1","pass@1" );
		idPasswordMap.put("2", "pass@2");
		idPasswordMap.put("3", "pass@3");
		idPasswordMap.put("4", "pass@4");
		idPasswordMap.put("5", "pass@5");
		idPasswordMap.put("6", "pass@6");
		idPasswordMap.put("7", "pass@7");
		idPasswordMap.put("8", "pass@8");
		idPasswordMap.put("9", "pass@9");
		idPasswordMap.put("10","pass@10");
		midPasswordMap=new HashMap<>();
		midPasswordMap.put("man1","pass1");
		midPasswordMap.put("man2","pass2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblpic = new JLabel("");
		lblpic.setBounds(-73, 0, 509, 463);
		 Image img = new ImageIcon(this.getClass().getResource("/emp.png")).getImage();
	        lblpic.setIcon(new ImageIcon(img));
		contentPane.add(lblpic);
		
		eid = new JTextField();
		eid.setBounds(565, 206, 96, 33);
		contentPane.add(eid);
		eid.setColumns(10);
		
		epass = new JPasswordField();
		epass.setBounds(565, 299, 96, 33);
		contentPane.add(epass);
		
		JButton emp = new JButton("Login as Employee");
		emp.setBackground(new Color(255, 0, 128));
		emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=eid.getText();
				String pass= new String(epass.getPassword());
				if(idPasswordMap.containsKey(id)){
					String storepass=idPasswordMap.get(id);
				
				if(pass.equals(storepass)) {
					Employee anotherFrame=new Employee();
					anotherFrame.setVisible(true);
					EmployeeManagement .this.setVisible(false);
	                emp.setEnabled(false);
				} 
				else {
					JOptionPane.showMessageDialog(EmployeeManagement.this,"Invalid Pass!\nTry after sometime");
					System.exit(0);
				}
				}
			}
		});
		emp.setBounds(497, 382, 146, 39);
		contentPane.add(emp);
		
		JLabel id = new JLabel("Id");
		id.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id.setBounds(470, 204, 62, 30);
		contentPane.add(id);
		
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pass.setBounds(455, 297, 77, 30);
		contentPane.add(pass);
		
		mid = new JTextField();
		mid.setBounds(861, 204, 96, 33);
		contentPane.add(mid);
		mid.setColumns(10);
		
		mpass = new JPasswordField();
		mpass.setBounds(861, 299, 96, 33);
		contentPane.add(mpass);
		
		JButton man = new JButton("Login as Maganer");
		man.setBackground(new Color(128, 0, 255));
		man.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Manid=mid.getText();
				String ManPass=new String(mpass.getPassword());
				if(midPasswordMap.containsKey(Manid)) {
					String StoreMPass=midPasswordMap.get(Manid);
					if(ManPass.equals(StoreMPass)) {
					Manager anotherFrame=new Manager();
					anotherFrame.setVisible(true);
					EmployeeManagement .this.setVisible(false);
	                man.setEnabled(false);
					}
					else {
						JOptionPane.showMessageDialog(EmployeeManagement.this,"Invalid Pass!\nTry after sometime");
						System.exit(0);
					}
				}
			}
		});
		man.setBounds(773, 382, 146, 39);
		contentPane.add(man);
		
		JLabel id_1 = new JLabel("Id");
		id_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id_1.setBounds(777, 204, 62, 30);
		contentPane.add(id_1);
		
		JLabel pass_1 = new JLabel("Password");
		pass_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pass_1.setBounds(762, 297, 77, 30);
		contentPane.add(pass_1);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Management "
				+ "\r\nSystem");
		lblNewLabel_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel_1.setBounds(446, 28, 530, 82);
		contentPane.add(lblNewLabel_1);
		
		}
}
