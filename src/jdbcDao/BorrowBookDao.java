package jdbcDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import model.BorrowInfo;

public class BorrowBookDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	int rs = 0;
	ResultSet rs1 =null;

	
	/**
	 * 	图书借阅
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(  BorrowInfo borrowinfo)throws Exception{

		try {
			//1.注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.获取Connection对象
			String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
			String user1 = "root";
			String password = "111" ;
			conn = DriverManager.getConnection(url, user1, password);			
			
			
			// 判断用户密码是否正确
			String sql1 = "select vid, vpassd from vips where vid = ? and vpassd = ?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, borrowinfo.getVid());
			pstmt.setString(2, borrowinfo.getVpassd());
			
			rs1 = pstmt.executeQuery();
			
			if(rs1.next()) {
				long time = System.currentTimeMillis();
				DateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currenttime = date.format(time);
				System.out.println(currenttime);
//				String borrowtime = currenttime.substring(0, 10);  //借书日期
				
			String sql = "insert into borrowinfo values(?,?,?)";	
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, borrowinfo.getVid());
			pstmt.setInt(2, borrowinfo.getBnum());
			pstmt.setString(3, currenttime);
			
			rs = pstmt.executeUpdate();  	// 执行语句，得到返回的int值，可以判断是否添加成功
			
			}else {
				rs = -1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
