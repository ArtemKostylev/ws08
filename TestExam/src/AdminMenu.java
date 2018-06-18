import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminMenu extends JFrame {

	private JPanel contentPane;
	
	public int attempts;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.WEST);
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
		
		JLabel lblNewLabel = new JLabel("\u041C\u0435\u043D\u044E \u0430\u0434\u043C\u0438\u043D\u0438\u0441\u0442\u0440\u0430\u0442\u043E\u0440\u0430");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(230, 60, 216, 64);
		lblNewLabel.setForeground(new Color(0,159,218));
		panel.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		//tabbedPane.add
		tabbedPane.setBounds(90, 233, 501, 224);
		panel.add(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("\u041F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u0435\u043B\u0438", null, scrollPane_1, null);
		
		table = new JTable();
		
		
		scrollPane_1.setColumnHeaderView(table);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("\u041F\u0440\u043E\u0438\u0437\u0432\u043E\u0434\u0441\u0442\u0432\u043E", null, scrollPane_2, null);
	}
	public DefaultTableModel fillRowData()
	{
		DefaultTableModel model = new DefaultTableModel();
		try{
		Connection con = DriverManager.getConnection("jdbc:mysql://172.29.212.115:3306/ws08?serverTimezone = UTC","ws08","ws08");
		String sql = "select * from user ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		} catch(SQLException e){
			
		}
		return model;
	}
	
}
