package windowView;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbcDao.VipQueryDao;
import model.Vip;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VipQuery extends JInternalFrame {
	VipQueryDao vipquerydao = new VipQueryDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField vipIdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VipQuery frame = new VipQuery();
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
	public VipQuery() {
		setClosable(true);
		setBounds(100, 100, 731, 602);
		
		JLabel lblNewLabel = new JLabel("会员信息查询界面");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 32));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("会员编号：");
		label.setFont(new Font("宋体", Font.BOLD, 18));
		
		vipIdTxt = new JTextField();
		vipIdTxt.setFont(new Font("宋体", Font.BOLD, 18));
		vipIdTxt.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vipIdQueryPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(205)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(175)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(vipIdTxt, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(lblNewLabel)
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(vipIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4F1A\u5458\u7F16\u53F7", "\u4F1A\u5458\u59D3\u540D", "\u501F\u4E66\u5BC6\u7801", "\u4F1A\u5458\u7535\u8BDD", "\u4F1A\u5458\u4F59\u989D"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		try {
			Vip vip = new Vip();
			this.fillTable(vip);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected void vipIdQueryPerformed(ActionEvent e) {
		String vid = this.vipIdTxt.getText();
		if(vid.equals("")) {
			Vip vip = new Vip();
			try {
				this.fillTable(vip);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			int vid1 =  Integer.valueOf(vid).intValue();
			Vip vip = new Vip(vid1,"vid");
			try {
				this.fillTable(vip);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	/**
	 * 将信息填充到表格
	 */
	public void fillTable( Vip vip ) throws Exception {

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
			ResultSet rs =  vipquerydao.list(conn, vip); //获取查询的结果集

			while(rs.next()) {  //遍历结果集
				Vector<String> v = new Vector<String>();   //定义一个集合
				v.add(rs.getString("vid"));
				v.add(rs.getString("vname"));
				v.add(rs.getString("vpassd"));
				v.add(rs.getString("vphone"));
				v.add(rs.getString("vmoney"));
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
