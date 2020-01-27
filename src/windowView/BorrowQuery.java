package windowView;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbcDao.BookQueryDao;
import jdbcDao.BorrowQueryDao;
import jdbcDao.VipQueryDao;
//import model.Book;
import model.BorrowInfo;
//import model.Vip;
import util.Stringutils;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BorrowQuery extends JInternalFrame {
	BorrowQueryDao borrowquerydao = new BorrowQueryDao();
	BookQueryDao bookquerydao = new BookQueryDao();
	VipQueryDao vipquerydao = new VipQueryDao();
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField bookNumTxt;
	private JTextField vipIdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowQuery frame = new BorrowQuery();
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
	public BorrowQuery() {
		getContentPane().setFont(new Font("宋体", Font.BOLD, 18));
		setClosable(true);
		setTitle("图书借阅查询");
		setBounds(100, 100, 778, 599);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("借阅信息查询界面");
		label.setFont(new Font("宋体", Font.BOLD, 32));
		
		JLabel lblNewLabel = new JLabel("图书编号：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		
		bookNumTxt = new JTextField();
		bookNumTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookNumTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookNumQueryBorrowInfoPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("会员编号：");
		label_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		vipIdTxt = new JTextField();
		vipIdTxt.setFont(new Font("宋体", Font.BOLD, 18));
		vipIdTxt.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vipIdBorrrowQueryPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(215)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(vipIdTxt)
								.addComponent(bookNumTxt, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(label)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(bookNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(vipIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(47)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4F1A\u5458\u7F16\u53F7", "\u4F1A\u5458\u59D3\u540D", "\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u501F\u4E66\u65F6\u95F4"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		try {
			BorrowInfo  borrowinfo = new BorrowInfo();
			this.fillTable(borrowinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过会员编号查询借阅信息
	 * @param evt
	 */
	protected void vipIdBorrrowQueryPerformed(ActionEvent evt) {
		try {
		String vid = this.vipIdTxt.getText();     // 获取用户输入的图书编号
		if(Stringutils.isEmpty(vid)) {
			//判断是否为空,为空则显示所有信息
				BorrowInfo  borrowinfo = new BorrowInfo();
				this.fillTable(borrowinfo);
				return;
		}
		int vid1 = Integer.valueOf(vid).intValue();			// 	转化为int型
		BorrowInfo  borrowinfo = new BorrowInfo(vid1,"vid");   // 实例化一个BorrowInfo对象，将图书编号，和查询种类信息传出
		this.fillTable(borrowinfo);  	// 调用fillTable方法，将得到的借阅信息填充到表格中
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 *  通过图书编号查询借阅图书信息
	 * @param evt
	 */
	private void bookNumQueryBorrowInfoPerformed(ActionEvent evt) {
		try {
		String booknum = this.bookNumTxt.getText();     // 获取用户输入的图书编号
		if(Stringutils.isEmpty(booknum)) {
			//判断是否为空，为空则显示所有信息
				BorrowInfo  borrowinfo = new BorrowInfo();
				this.fillTable(borrowinfo);
				return;
		}
		int booknum1 = Integer.valueOf(booknum).intValue();			// 	转化为int型
		BorrowInfo  borrowinfo = new BorrowInfo(booknum1,"booknum");   // 实例化一个BorrowInfo对象，将图书编号，和查询种类信息传出
		this.fillTable(borrowinfo);  	// 调用fillTable方法，将得到的借阅信息填充到表格中
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 将信息填充到表格
	 */
	public void fillTable( BorrowInfo borrowinfo) throws Exception {

		DefaultTableModel dtm = (DefaultTableModel)table.getModel();    //初始化table
		dtm.setRowCount(0); //将表格设置成零行，清空表格
		Connection conn = null; 
		try {
			//1.注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2.获取Connection对象
			String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
			String user1 = "root";
			String password = "111" ;
			conn = DriverManager.getConnection(url, user1, password);
			
			ResultSet rs =  borrowquerydao.list(conn, borrowinfo); //获取查询的结果集
			
			while(rs.next()) {  //遍历结果集
				Vector<String> v = new Vector<String>();   //定义一个集合，泛型为String
//				
//				String bnum =rs.getString("bnum");    //获取此次循环的图书编号
//				Book book = new Book(bnum,"id");    // 将图书编号传到新建的对象中
//				ResultSet bookrs = bookquerydao.list(conn, book);    // 利用图书编号查询图书信息
//				
//				String vid = rs.getString("vid");
//				int vipid = Integer.valueOf(vid).intValue();
//				Vip vip = new Vip(vipid,"vid");
//				ResultSet viprs =vipquerydao.list(conn, vip);
//				
//				if(bookrs.next()) {
//					if(viprs.next()) {
						v.add(rs.getString("vid"));
						v.add(rs.getString("vname"));
						v.add(rs.getString("bnum"));
						v.add(rs.getString("bname"));
						v.add(rs.getString("date"));
						dtm.addRow(v);   // 将数据添加到表格
					}
//				}
//			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//释放资源
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}
}
