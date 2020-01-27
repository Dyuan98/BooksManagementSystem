package jdbcDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Vip;

public class RechargeDao {
	
	/**
	 *  会员充值
	 * @param vip
	 * @param rs 
	 */
	public int alter(Vip vip, double money) {
		Connection conn = null;
		int rs =0;
		PreparedStatement pstmt = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.获取Connection对象
			String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
			String user1 = "root";
			String password = "111" ;
			conn = DriverManager.getConnection(url, user1, password);
	
			
			//3.定义sql语句
			String sql = "update vips set vmoney = vmoney +"+money+"  where vid =?";
			
			//4. 获取执行sql的对象 prepareStatement
			pstmt = conn.prepareStatement(sql);
			// 调用pstmt的方法setXXX设置?占位
			
//			pstmt.setObject(1, user.getPassword());
//			pstmt.setObject(2, user.getUser());
			pstmt.setInt(1, vip.getVid());
			
			
			//5. 执行sql语句
			rs = pstmt.executeUpdate();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//释放资源
			if(pstmt != null) {
				//判断stmt是否为空，避免空指针异常
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rs;
	}

}
