package windowView;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import jdbcDao.SubMoneyDao;
import jdbcDao.BorrowBookDao;
import jdbcDao.ReturnBookDao;
import model.BorrowInfo;
import model.Vip;
import util.Stringutils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrowReturnBook extends JInternalFrame {
	
	BorrowBookDao borrowbookdao = new BorrowBookDao();
	ReturnBookDao returnbookdao = new ReturnBookDao();
	SubMoneyDao altermoneydao = new SubMoneyDao();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField vipVidTxt;
	private JTextField bookNumTxt;
	private JTextField vipPassdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowReturnBook frame = new BorrowReturnBook();
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
	public BorrowReturnBook() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 698, 500);
		
		JLabel lblNewLabel = new JLabel("图书借阅界面");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 32));
		
		JLabel lblNewLabel_1 = new JLabel("会员编号：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		vipVidTxt = new JTextField();
		vipVidTxt.setFont(new Font("宋体", Font.BOLD, 18));
		vipVidTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("图书编号：");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		bookNumTxt = new JTextField();
		bookNumTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookNumTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("借阅图书");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowBookPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 重置功能
				resetValueActionPerfored(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton btnNewButton_2 = new JButton("归还图书");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 归还图书
				returnBookPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_3 = new JLabel("会员密码");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 18));
		
		vipPassdTxt = new JTextField();
		vipPassdTxt.setFont(new Font("宋体", Font.BOLD, 18));
		vipPassdTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(173)
							.addComponent(lblNewLabel_1)
							.addGap(16)
							.addComponent(vipVidTxt, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(213)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(171)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(19)
									.addComponent(bookNumTxt, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(vipPassdTxt)))))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(lblNewLabel)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(lblNewLabel_1)
							.addGap(43)
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addComponent(vipVidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(bookNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(vipPassdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(45)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addGap(2))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(4)))
					.addGap(82))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * 归还图书
	 * @param evt
	 */
	private void returnBookPerformed(ActionEvent evt) {
		String vid = this.vipVidTxt.getText();
		String bnum = this.bookNumTxt.getText();
		String vpassd = this.vipPassdTxt.getText();

		if(Stringutils.isEmpty(vpassd)) {
			//判断是否为空
			JOptionPane.showMessageDialog(null, "不能有空选项");
			return;
		}
		if(Stringutils.isEmpty(vid)) {
			//判断是否为空
			JOptionPane.showMessageDialog(null, "不能有空选项");
			return;
		}
		if(Stringutils.isEmpty(bnum)) {
			//判断是否为空
			JOptionPane.showMessageDialog(null, "不能有空选项");
			return;
		}
		
		int vid1 = Integer.valueOf(vid).intValue();
		int bnum1 = Integer.valueOf(bnum).intValue();
		BorrowInfo borrowinfo = new BorrowInfo(vid1, bnum1,vpassd);
		
		try {
			int rs = returnbookdao.add(borrowinfo);
			if(rs == 1) {
				JOptionPane.showMessageDialog(null, "归还成功");
				resetValue(); 	//添加成功后自动重置
			}else {
				JOptionPane.showMessageDialog(null, "归还失败！请确认输入的信息是否正确！");
				resetValue(); 	//添加成功后自动重置
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 借书
	 * @param evt
	 */
	private void borrowBookPerformed(ActionEvent evt) {

		try {
			String vid = this.vipVidTxt.getText();
			String bnum = this.bookNumTxt.getText();
			String vpassd = this.vipPassdTxt.getText();
		
			if(Stringutils.isEmpty(vpassd)) {
				//判断是否为空
				JOptionPane.showMessageDialog(null, "不能有空选项");
				return;
			}
			if(Stringutils.isEmpty(vid)) {
				//判断是否为空
				JOptionPane.showMessageDialog(null, "不能有空选项");
				return;
			}
			if(Stringutils.isEmpty(bnum)) {
				//判断是否为空
				JOptionPane.showMessageDialog(null, "不能有空选项");
				return;
			}
			
			int vid1 = Integer.valueOf(vid).intValue();
			int bnum1 = Integer.valueOf(bnum).intValue();
			
			BorrowInfo borrowinfo = new BorrowInfo(vid1, bnum1,vpassd);
			Vip vip = new Vip(vid1);
			int rs = borrowbookdao.add(borrowinfo);
			if(rs == 1) {
				JOptionPane.showMessageDialog(null, "借阅成功,余额扣除五元！");
				altermoneydao.alter(vip);
				resetValue(); 	//添加成功后自动重置
			}else {
				JOptionPane.showMessageDialog(null, "借阅失败！请确认输入的信息是否正确！");
				resetValue(); 	//自动重置
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValue() {
//		this.vipVidTxt.setText("");
		this.bookNumTxt.setText("");
		this.vipPassdTxt.setText("");
	}
	private void resetValueActionPerfored(ActionEvent evt) { 
		this.resetValue();
	}
}
