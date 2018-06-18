import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Autorization extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public int attempts;

	JFrame frame;
	void setFrame(){
		frame = this;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autorization frame = new Autorization();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String convert(char[] arg){
		String res = "";
		for (int i = 0;i<arg.length;i++){
			res+=arg[i];
		}
		return res;
	}
	/**
	 * Create the frame.
	 */
	public Autorization() {
		setTitle("\u0410\u0432\u0442\u043E\u0440\u0438\u0437\u0430\u0446\u0438\u044F");
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 680, 545);
		panel.setBackground(new Color(0,65,101));
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(248, 154, 243, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u041F\u043E\u0436\u0430\u043B\u0443\u0439\u0441\u0442\u0430, \u0430\u0432\u0442\u043E\u0440\u0438\u0437\u0438\u0440\u0443\u0439\u0442\u0435\u0441\u044C \u0432 \u0441\u0438\u0441\u0442\u0435\u043C\u0435");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(173, 59, 372, 64);
		lblNewLabel.setForeground(new Color(0,159,218));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(new Color(0,159,218));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(200, 163, 38, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(0,159,218));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(173, 224, 65, 14);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 215, 243, 34);
		panel.add(passwordField);
		
		JButton button = new JButton("\u0412\u043E\u0439\u0442\u0438");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//test er= new test();
				//er.setVisible(true);
				//setFrame();
				//frame.setVisible(false);
				//НЕ работает подключение к БД!!!
				try{
					Connection con = DriverManager.getConnection("jdbc:mysql://172.29.212.115:3306/ws08?serverTimezone = UTC","ws08","ws08");
					String sql = "select * from user where email = '"+textField.getText()+"'";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					System.out.println("query executed");
					if (rs.isBeforeFirst()){
						while (rs.next())
						{
							String psw = convert(passwordField.getPassword());
							if (rs.getString(3).equals(psw)){
								System.out.println("logged as customer");
							}
							else
							{
								System.out.println("error");
								Error er= new Error();
								er.setVisible(true);
							}
						}
					}
					else{
						sql = "select * from admin where email = '"+textField.getText()+"'";
						st = con.createStatement();
						rs = st.executeQuery(sql);
						System.out.println("query executed");
						while (rs.next())
						{
							if (rs.getString(3).equals(convert(passwordField.getPassword()))){
								System.out.println("logged as admin");
								AdminMenu er= new AdminMenu();
								er.setVisible(true);
								setFrame();
								frame.setVisible(false);
							}
							else
							{
								System.out.println("error");
								Error er= new Error();
								er.setVisible(true);
								System.out.println("error");
							}
						}
					}
					
				}
				catch (SQLException e)
				{
					System.out.println(e);
				}
			}
		});
		button.setBackground(new Color(0,65,101));
		button.setForeground(new Color(0,159,218));
		button.setFont(new Font("Arial", Font.BOLD, 16));
		button.setBounds(309, 285, 108, 49);
		panel.add(button);
		
		JButton btnNewButton = new JButton("\u0417\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u043E\u0432\u0430\u0442\u044C\u0441\u044F");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(0,159,218));
		btnNewButton.setBounds(414, 466, 220, 49);
		panel.add(btnNewButton);
	}
	
	
}
