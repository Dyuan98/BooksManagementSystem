package windowView;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import util.Stringutils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import jdbcDao.RechargeDao;
import model.Vip;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recharge extends JInternalFrame {
	
	RechargeDao rechargedao = new RechargeDao();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField vipIdTxt;
	private JTextField rechargeMoneyTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recharge frame = new Recharge();
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
	public Recharge() {
		getContentPane().setFont(new Font("宋体", Font.BOLD, 18));
		setTitle("用户充值");
		setClosable(true);
		setBounds(100, 100, 777, 502);
		
		JLabel lblNewLabel = new JLabel("会员充值界面");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 32));
		
		JLabel lblNewLabel_1 = new JLabel("会员编号：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		vipIdTxt = new JTextField();
		vipIdTxt.setFont(new Font("宋体", Font.BOLD, 18));
		vipIdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("充值金额：");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		rechargeMoneyTxt = new JTextField();
		rechargeMoneyTxt.setFont(new Font("宋体", Font.BOLD, 18));
		rechargeMoneyTxt.setColumns(10);
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vipRechargePerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 resetValueActionPerfored(e);
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(265)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(228)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
								.addComponent(button, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(rechargeMoneyTxt)
									.addComponent(vipIdTxt, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(261, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(102)
					.addComponent(lblNewLabel)
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(vipIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(rechargeMoneyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void vipRechargePerformed(ActionEvent e) {
		String vid = this.vipIdTxt.getText();
		String money = this.rechargeMoneyTxt.getText();
		

		if(Stringutils.isEmpty(vid)) {
			//判断是否为空
			JOptionPane.showMessageDialog(null, "不能有空选项");
			return;
		}
		if(Stringutils.isEmpty(money)) {
			//判断是否为空
			JOptionPane.showMessageDialog(null, "不能有空选项");
			return;
		}
		int vid1 = Integer.valueOf(vid).intValue();
		Double money1=Double.parseDouble(money);
		
		Vip vip = new Vip(vid1);
		
		int rs =  rechargedao.alter(vip, money1);
		if(rs == 1) {
			JOptionPane.showMessageDialog(null, "充值成功！");
			resetValue(); 	//充值成功后自动重置
		}else {
			JOptionPane.showMessageDialog(null, "充值失败，请确认会员编号是否正确！");
			resetValue(); 	//充值成功后自动重置
		}
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValue() {
//		this.vipVidTxt.setText("");
		this.rechargeMoneyTxt.setText("");
		this.vipIdTxt.setText("");
	}
	private void resetValueActionPerfored(ActionEvent evt) { 
		this.resetValue();
	}
}
