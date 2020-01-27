package jdbcDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;

public class UserAlterDao {
	public int alter (User user) {
		
		int rs =0;
		Connection conn = null;
		
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
			String sql = "update user set password = ? where name = ?" ;
			
			//4. 获取执行sql的对象 prepareStatement
			pstmt = conn.prepareStatement(sql);
			// 调用pstmt的方法setXXX设置?占位
//			System.out.println("密码为"+ user.getPassword());
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getUsername());

			//5. 执行sql语句
			rs = pstmt.executeUpdate();
//			System.out.println("rs是："+rs);
	
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
