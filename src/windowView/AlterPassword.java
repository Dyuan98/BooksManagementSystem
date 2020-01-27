package windowView;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import jdbcDao.UserAlterDao;
import model.User;
import util.Stringutils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterPassword extends JInternalFrame {
	 UserAlterDao  useralter = new UserAlterDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField passd01;
	private JTextField passd02;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterPassword frame = new AlterPassword();
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
	public AlterPassword() {
		setTitle("修改密码");
		getContentPane().setForeground(new Color(192, 192, 192));
		
		JLabel lblNewLabel = new JLabel("新密码");
		lblNewLabel.setIcon(new ImageIcon(AlterPassword.class.getResource("/icon/钥匙01.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("请确认");
		lblNewLabel_1.setIcon(new ImageIcon(AlterPassword.class.getResource("/icon/重复.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		passd01 = new JTextField();
		passd01.setColumns(10);
		
		passd02 = new JTextField();
		passd02.setColumns(10);
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ReSetPassword resetpassword = new ReSetPassword();
				// 修改密码事件
				ReSetPassword(e);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancleAlter(e);
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("修改密码界面");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 32));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(8)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(passd01, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(passd02, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
					.addGap(131))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(165)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel_2)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passd01, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(passd02, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(27))
		);
		getContentPane().setLayout(groupLayout);
		setIconifiable(true);
		
		setClosable(true);
		setBounds(100, 100, 573, 300);

	}



	protected void CancleAlter(ActionEvent e) {
		// TODO Auto-generated method stub
		/**
		 * 取消修改密码
		 */
		dispose();
	}

	protected void ReSetPassword(ActionEvent evt) {
		/**
		 * 重新设置密码
		 */
		// TODO Auto-generated method stub
		
		String passd01 = this.passd01.getText();
		String passd02 = this.passd02.getText();

		if(Stringutils.isEmpty(passd01)) {
			// 使用工具类Stringutils检测用户输入的用户名是否为空
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		if(Stringutils.isEmpty(passd02)) {
			// 使用工具类Stringutils检测用户输入的用户名是否为空
			JOptionPane.showMessageDialog(null, "请重复输入新密码！");
			return;
		}
		User  user = new User(Login.name, passd01);
		int rs = useralter.alter(user);
			if(rs ==1) {
			JOptionPane.showMessageDialog(null, "修改成功！");
			dispose();
			Login.main.setVisible(false);
			 new Login().setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(null, "两次输入不相同，请重新输入！");
		}

	}
}
