package windowView;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import jdbcDao.BookAddDao;
import model.Book;
import util.Stringutils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAdd extends JInternalFrame {
	
	private BookAddDao bookadddao = new BookAddDao();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField bookIdTxt;
	private JTextField bookNmaeTxt;
	private JTextField bookTypeTxt;
	private JTextField bookWriterTxt;
	private JTextField bookPriceTxt;
	private JLabel lblNewLabel_5;
	private JTextField bookNumberTxt;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAdd frame = new BookAdd();
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
	public BookAdd() {
		setTitle("添加图书");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 666, 520);
		
		JLabel lblNewLabel = new JLabel("图书编号：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		
		bookIdTxt = new JTextField();
		bookIdTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookIdTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("图书名称：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("图书类型：");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_3 = new JLabel("图书作者：");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_4 = new JLabel("图书价格：");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 18));
		
		bookNmaeTxt = new JTextField();
		bookNmaeTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookNmaeTxt.setColumns(10);
		
		bookTypeTxt = new JTextField();
		bookTypeTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookTypeTxt.setColumns(10);
		
		bookWriterTxt = new JTextField();
		bookWriterTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookWriterTxt.setColumns(10);
		
		bookPriceTxt = new JTextField();
		bookPriceTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookPriceTxt.setColumns(10);
		
		lblNewLabel_5 = new JLabel("图书数量：");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 18));
		
		bookNumberTxt = new JTextField();
		bookNumberTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookNumberTxt.setColumns(10);
		
		label = new JLabel("添加图书界面");
		label.setFont(new Font("宋体", Font.BOLD, 24));
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			// 点击添加按钮，执行事件
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			// 点击重置按钮，执行事件
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerfored(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(105)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_4))
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(bookNumberTxt, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(bookPriceTxt, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(bookIdTxt, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(bookNmaeTxt, 233, 233, Short.MAX_VALUE)
								.addComponent(bookTypeTxt, 233, 233, Short.MAX_VALUE)
								.addComponent(bookWriterTxt, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))))
					.addGap(211))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(221)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addComponent(label)
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookNmaeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(bookTypeTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookWriterTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(bookPriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(bookNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(49))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	
	/**
	 *  图书添加事件
	 * @param e
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		try {
			// 获取用户输入的文本
			String bookId = this.bookIdTxt.getText();
			String bookName = this.bookNmaeTxt.getText();
			String bookType = this.bookTypeTxt.getText();
			String bookWriter = this.bookWriterTxt.getText();
			String bookPrice = this.bookPriceTxt.getText();
			String bookNumber = this.bookNumberTxt.getText();

	
			if(Stringutils.isEmpty(bookId)) {
				//判断是否为空
				JOptionPane.showMessageDialog(null, "不能有空选项");
				return;
			}
			if(Stringutils.isEmpty(bookName)) {
				//判断是否为空
				JOptionPane.showMessageDialog(null, "不能有空选项");
				return;
			}
			if(Stringutils.isEmpty(bookType)) {
				//判断是否为空
				JOptionPane.showMessageDialog(null, "不能有空选项");
				return;
			}
			if(Stringutils.isEmpty(bookWriter)) {
				//判断是否为空
				JOptionPane.showMessageDialog(null, "不能有空选项");
				return;
			}
			if(Stringutils.isEmpty(bookPrice)) {
				//判断是否为空
				JOptionPane.showMessageDialog(null, "不能有空选项");
				return;
			}
			if(Stringutils.isEmpty(bookNumber)) {
				//判断是否为空
				JOptionPane.showMessageDialog(null, "不能有空选项");
				return;
			}

			int bookId1 = Integer.valueOf(bookId).intValue();
			Double bookPrice1=Double.parseDouble(bookPrice);
			int bookNumber1 = Integer.valueOf(bookNumber).intValue();
			
			
			
			// 实例化一个Book对象，将获取的值当作参数传输。
			Book book = new Book(bookId1,bookName,bookType,bookWriter,bookPrice1,bookNumber1);
			int rs = bookadddao.add(book);
			if(rs == 1) {
				JOptionPane.showMessageDialog(null, "图书添加成功");
				resetValue(); 	//添加成功后自动重置
			}else {
				JOptionPane.showMessageDialog(null, "图书添加失败,请确认图书编号是否重复！");
				resetValue(); 	//添加成功后自动重置
			}
		
		}catch (NumberFormatException e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败,请检查图书编号、图书价格、图书数量，是否由非数字字符");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败");
		}
		
		
			
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	
	private void resetValue() {
		this.bookIdTxt.setText("");
		this.bookNmaeTxt.setText("");
		this.bookTypeTxt.setText("");
		this.bookWriterTxt.setText("");
		this.bookPriceTxt.setText("");
		this.bookNumberTxt.setText("");
	}
		
	private void resetValueActionPerfored(ActionEvent evt) { 
		this.resetValue();
	}
}
