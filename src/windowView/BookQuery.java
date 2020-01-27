package windowView;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
//import java.util.function.IntToDoubleFunction;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbcDao.BookQueryDao;
import model.Book;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BookQuery extends JInternalFrame {
	Book book = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	
	private BookQueryDao  bookquery = new BookQueryDao();
	private JTextField bookTypeTxt;
	private JTextField bookNameTxt;
	private JTextField bookIdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookQuery frame = new BookQuery();
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
	public BookQuery() {
		setTitle("图书查询");
		setClosable(true);
		setBounds(100, 100, 1000, 670);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("按类别查询：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		
		bookTypeTxt = new JTextField();
		bookTypeTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookTypeTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("按书名查询：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		bookNameTxt = new JTextField();
		bookNameTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("按编号查询：");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		bookIdTxt = new JTextField();
		bookIdTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookIdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("确认查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 按类别查询
				try {
					queryBookTypePerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton btnNewButton_1 = new JButton("确认查询");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 按书名查询
				queryBookNamePerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton btnNewButton_2 = new JButton("确认查询");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryBookIdPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(178, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookIdTxt)
								.addComponent(bookNameTxt)
								.addComponent(bookTypeTxt, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(178))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 809, GroupLayout.PREFERRED_SIZE)))
					.addGap(124))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2))
					.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addGap(89))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u4E66\u540D", "\u7C7B\u522B", "\u4F5C\u8005", "\u4EF7\u683C", "\u6570\u91CF"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		try {
			Book  book = new Book();
			this.fillTable(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * 图书编号查询
	 * @param evt
	 */
	private void queryBookIdPerformed(ActionEvent evt) {
		String bookId = this.bookIdTxt.getText();
		Book book = new Book(bookId, "id");
		try {
			this.fillTable(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 *  图书类别查询
	 * @param evt
	 */
		private void queryBookTypePerformed(ActionEvent evt) {
			String bookType = this.bookTypeTxt.getText();
			Book book = new Book(bookType, "type");
			try {
				this.fillTable(book);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	/**
	 *  图书名称查找
	 * @param e
	 */
	private void queryBookNamePerformed(ActionEvent evt) {
		String bookName = this.bookNameTxt.getText();
		Book book = new Book(bookName, "name");
		try {
			this.fillTable(book);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}



	/**
	 * 将信息填充到表格
	 */
	public void fillTable(Book book) throws Exception {

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
	
			ResultSet rs =  bookquery.list(conn, book); //获取查询的结果集
			
			while(rs.next()) {  //遍历结果集
				Vector<String> v = new Vector<String>();   //定义一个集合
				v.add(rs.getString("bnum"));
				v.add(rs.getString("bname"));
				v.add(rs.getString("btype"));
				v.add(rs.getString("bwriter"));
				v.add(rs.getString("bprice"));
				v.add(rs.getString("bamount"));
				int amount = Integer.valueOf(rs.getString("bamount")).intValue();
				if(amount==1) {
					JOptionPane.showMessageDialog(null, "书籍编号为："+rs.getString("bnum")+"的图书库存不足，请及时补充！");
				}
				dtm.addRow(v);   // 将数据添加到表格
			}
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
