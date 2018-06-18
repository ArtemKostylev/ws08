import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test extends JFrame {

	private JPanel contentPane;
	JFrame frame;
	void setFrame(){
		frame = this;
	}
	

	public test() {
		setTitle("\u041E\u0448\u0438\u0431\u043A\u0430!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminMenu er= new AdminMenu();
				er.setVisible(true);
				setFrame();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(116, 89, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnUser = new JButton("user");
		btnUser.setBounds(116, 40, 89, 23);
		panel.add(btnUser);
	}

}
