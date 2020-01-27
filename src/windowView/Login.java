package windowView;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import jdbcDao.UserQueryDao;
import model.User;
import util.Stringutils;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	public static  String name= null; 
	public static Main main  =new Main();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	private UserQueryDao  userQuery = new UserQueryDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 622, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("图书管理系统");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/icon/图书01.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 32));
		
		JLabel lblNewLabel_1 = new JLabel("账户");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/icon/人物.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/icon/钥匙.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		user = new JTextField();
		user.setFont(new Font("宋体", Font.BOLD, 16));
		user.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/icon/登录.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerfored(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton_1.setIcon(new ImageIcon(Login.class.getResource("/icon/刷新.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(146)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(155)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(138)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(password, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(user, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))))
					.addGap(164))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(lblNewLabel)
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(user)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	/**
	 * 登陆事件处理
	 * @param e
	 */
	private void registerActionPerformed(ActionEvent evt) {


		name = this.user.getText(); // 获取用户输入的用户名
		String passd = new String(this.password.getPassword());  // 获取用户输入的密码，由于收到的为char类型，这里重新转为String
		
		if(Stringutils.isEmpty(name)) {
			// 使用工具类Stringutils检测用户输入的用户名是否为空
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(Stringutils.isEmpty(passd)) {
			// 使用工具类Stringutils检测用户输入的密码是否为空
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		
		User user1 = new User(name, passd);
		// 将从主界面得到的用户名和密码传到User对象中
		User currentUser = userQuery.login(user1);
		//将user对象当作参数传入到userQuery中
		if(currentUser!=null) {
			// 查询在数据库中存在与之对应的账户和密码，关闭当前页面，
			dispose();
			//显示系统主界面
			main.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(null, "用户名或密码错误！");
		}
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerfored(ActionEvent evt) {
		this.user.setText("");
		this.password.setText("");
	}
}
