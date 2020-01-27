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

import jdbcDao.VipAddDao;
import model.Vip;
import util.Stringutils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VipAdd extends JInternalFrame {
	VipAddDao vipadddao = new VipAddDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField vipIdTxt;
	private JTextField vipNameTxt;
	private JTextField vipPhoneTxt;
	private JTextField vipPassdTxt;
	private JTextField vipMoneyTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VipAdd frame = new VipAdd();
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
	public VipAdd() {
		setIconifiable(true);
		setClosable(true);
		setTitle("会员管理界面");
		setBounds(100, 100, 700, 500);
		
		JLabel lblNewLabel = new JLabel("添加会员");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 32));
		
		JLabel lblNewLabel_1 = new JLabel("会员编号：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("会员姓名：");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		vipIdTxt = new JTextField();
		vipIdTxt.setFont(new Font("宋体", Font.BOLD, 18));
		vipIdTxt.setColumns(10);
		
		vipNameTxt = new JTextField();
		vipNameTxt.setFont(new Font("宋体", Font.BOLD, 18));
		vipNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("会员电话：");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 18));
		
		vipPhoneTxt = new JTextField();
		vipPhoneTxt.setFont(new Font("宋体", Font.BOLD, 18));
		vipPhoneTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("会员密码：");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 18));
		
		vipPassdTxt = new JTextField();
		vipPassdTxt.setFont(new Font("宋体", Font.BOLD, 18));
		vipPassdTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("会员余额：");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 18));
		
		vipMoneyTxt = new JTextField();
		vipMoneyTxt.setFont(new Font("宋体", Font.BOLD, 18));
		vipMoneyTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 确认添加会员实现
				vipAddPerformed();
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(254)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(185)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblNewLabel_5)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(vipMoneyTxt)
									.addComponent(vipPassdTxt)
									.addComponent(vipNameTxt)
									.addComponent(vipPhoneTxt)
									.addComponent(vipIdTxt, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGap(70)))
					.addContainerGap(207, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(lblNewLabel)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(vipIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(vipNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(vipPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(vipPassdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(vipMoneyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	/**
	 *  添加会员
	 */
	private void vipAddPerformed() {
		String vipId = this.vipIdTxt.getText();
		String vipName  = this.vipNameTxt.getText();
		String vipphone = this.vipPhoneTxt.getText();
		String vipPassd = this.vipPassdTxt.getText();
		String vipMony = this.vipMoneyTxt.getText();
		
		if(Stringutils.isEmpty(vipId)) {
			//判断是否为空
			JOptionPane.showMessageDialog(null, "不能有空选项");
			return;
		}
		if(Stringutils.isEmpty(vipName)) {
			//判断是否为空
			JOptionPane.showMessageDialog(null, "不能有空选项");
			return;
		}
		if(Stringutils.isEmpty(vipphone)) {
			//判断是否为空
			JOptionPane.showMessageDialog(null, "不能有空选项");
			return;
		}
		if(Stringutils.isEmpty(vipPassd)) {
			//判断是否为空
			JOptionPane.showMessageDialog(null, "不能有空选项");
			return;
		}
		if(Stringutils.isEmpty(vipMony)) {
			//判断是否为空
			JOptionPane.showMessageDialog(null, "不能有空选项");
			return;
		}

		int vipId1 = Integer.valueOf(vipId).intValue();
//		int vipphone1 = Integer.valueOf(vipphone).intValue();
		long vipphone1 = Long.valueOf(vipphone).longValue();
		Double vipMony1=Double.parseDouble(vipMony);
		
		Vip vip = new Vip(vipId1,vipName,vipphone1,vipPassd,vipMony1);
		
		try {
			int rs = vipadddao.add(vip);
			if(rs == 1) {
				JOptionPane.showMessageDialog(null, "会员添加成功");
				resetValue(); 	//添加成功后自动重置
			}else {
				JOptionPane.showMessageDialog(null, "会员添加失败,请确认会员编号是否重复！");
				resetValue(); 	//添加成功后自动重置
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
		this.vipIdTxt.setText("");
		this.vipNameTxt.setText("");
		this.vipPhoneTxt.setText("");
		this.vipPassdTxt.setText("");
		this.vipMoneyTxt.setText("");
	}
	private void resetValueActionPerfored(ActionEvent evt) { 
		this.resetValue();
	}
}
