package windowView;


import java.awt.EventQueue;
//import java.awt.Graphics;
//import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;



public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane ;
//	Image background = GameUtil.getImage("icon/background.jpg");
//	
//	public void paint(Graphics g) {   	 // g相当于画笔
//	g.drawImage(background, 0, 0 , null);  // 画出游戏背景背景
//	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("图书管理系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 1200, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("管理员维护");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("修改密码");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//创建对象
				AlterPassword alterpassword = new AlterPassword();
				
				// 显示出修改密码界面
				alterpassword.setVisible(true);
				
				//添加组件
				contentPane.add(alterpassword);
			}
		});
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("退出登录");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				//	System.out.println(result);
				//返回值为整型，通过判断返回值，可以得知用户选择的按钮
				if(result == 0 ) {
					dispose();
				}
			}
		});
		mnNewMenu.add(menuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("会员管理");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("加入会员");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//创建对象
				VipAdd vipadd = new VipAdd();
				// 显示出修改密码界面
				vipadd.setVisible(true);
				
				//添加组件
				contentPane.add(vipadd);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem_5 = new JMenuItem("借还图书");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//创建对象
				BorrowReturnBook borrowbook = new BorrowReturnBook();
				
				// 显示出修改借阅图书界面
				borrowbook.setVisible(true);
				
				//添加组件
				contentPane.add(borrowbook);
			}
		});
		mnNewMenu_2.add(menuItem_5);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("会员充值");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//创建对象
				Recharge recharge = new Recharge();
				
				// 显示出会员充值界面
				recharge.setVisible(true);
				
				//添加组件
				contentPane.add(recharge);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("借阅查询");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//创建对象
				BorrowQuery borrowquery = new BorrowQuery();
				
				// 显示出修改密码界面
				borrowquery.setVisible(true);
				
				//添加组件
				contentPane.add(borrowquery);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("会员信息查询");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//创建对象
				VipQuery vipquery = new VipQuery();
				
				// 显示出修改密码界面
				vipquery.setVisible(true);
				
				//添加组件
				contentPane.add(vipquery);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("图书管理");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_4 = new JMenuItem("图书添加");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//创建对象
				BookAdd bookadd = new BookAdd();
				
				// 显示出修改密码界面
				bookadd.setVisible(true);
				
				//添加组件
				contentPane.add(bookadd);
			}
		});
		mnNewMenu_1.add(menuItem_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("图书查询");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookQuery bookquery = new BookQuery(); 
				bookquery.setVisible(true);   // 显示图书查询窗口
				contentPane.add(bookquery);   //添加组件
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu menu = new JMenu("");
		menuBar.add(menu);
		
		JMenuItem menuItem_2 = new JMenuItem("借阅图书");
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("归还图书");
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("帮助");
		menuBar.add(menu_1);
		
		JMenuItem mntmHttpwwwhaueeducn = new JMenuItem("http://www.haue.edu.cn");
		menu_1.add(mntmHttpwwwhaueeducn);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(331)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(840, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(229)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(496, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	
	} 

}
