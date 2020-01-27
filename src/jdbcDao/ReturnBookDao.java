package jdbcDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.BorrowInfo;

public class ReturnBookDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	int rs = -0;
	ResultSet daters = null;
	
	/**
	 * 	图书归还
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(  BorrowInfo borrowinfo)throws Exception{

		try {
			
			long time = System.currentTimeMillis();
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currenttime = date.format(time);
			
			
			//1.注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.获取Connection对象
			String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
			String user1 = "root";
			String password = "111" ;
			conn = DriverManager.getConnection(url, user1, password);
			
			String datesql = "select  date from borrowinfo where vid = ? and bnum = ?";    // 查询此vip借这本书的时间
			pstmt = conn.prepareStatement(datesql);
			pstmt.setInt(1, borrowinfo.getVid());
			pstmt.setInt(2, borrowinfo.getBnum());
			daters = pstmt.executeQuery();    // 执行语句
			if(daters.next()) {
				String borrowdate = daters.getString("date");
//				System.out.println("借书时间为："+ borrowdate);
//				System.out.println("还书时间为："+ currenttime);
				
			    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   // 设置时间格式
			    Date  date1 = simpleDateFormat1.parse(currenttime);    // 转化为Date对象
			    long ts1 = date1.getTime();      // 得到时间戳
//			    String res = String.valueOf(ts);
//			    System.out.println("时间戳为"+ts1);
			    
			    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   // 设置时间格式
			    Date  date2 = simpleDateFormat2.parse(borrowdate);    // 转化为Date对象
			    long ts2 = date2.getTime();      // 得到时间戳
//			    String res = String.valueOf(ts);
//			    System.out.println("时间戳为"+ts2);			    
		
				long subtime = ts1 - ts2;   // 得出借书和还书相差毫秒数
//				System.out.println("借还书相隔时间为："+subtime);
				long day = subtime/86400000;
//				
				JOptionPane.showMessageDialog(null, "借还时间相隔"+day+"天");
				if(day>7) {
					int week = (int)day/7 +1;
					double money =week*5; 
				String moneysql = "update vips set vmoney = vmoney - ?  where vid =?";    // 根据借还书相隔时间扣除vip会员费
				pstmt = conn.prepareStatement(moneysql);
				pstmt.setDouble(1, money);
				pstmt.setInt(2, borrowinfo.getVid());
				@SuppressWarnings("unused")
				int moneyrs = pstmt.executeUpdate();  	// 执行语句，得到返回的int值，可以判断是否添加成功
				JOptionPane.showMessageDialog(null, "借还时间相隔"+day+"天，扣除余额"+money+"元");
				}
			    
			}
			
			String sql = "delete from  borrowinfo where vid = ? and bnum = ?";   // 删除借阅信息的语句
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, borrowinfo.getVid());
			pstmt.setInt(2, borrowinfo.getBnum());
			rs = pstmt.executeUpdate();  	// 执行语句，得到返回的int值，可以判断是否添加成功
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//释放资源
			if(pstmt != null) {
				//判断stmt是否为空，避免空指针异常
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rs;
	}
}
