package jdbcDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;


public class UserQueryDao {
	/**
	 * 登陆验证
	 * @param args
	 */
	public User login (User user) {
		// 得到含有用户名和密码的对象user
		User resultUser=null;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.获取Connection对象
			String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
			String user1 = "root";
			String password = "111" ;
			conn = DriverManager.getConnection(url, user1, password);
			
			//3.定义sql语句
			String sql = "select * from user where name=? and password=?";
			
			//4. 获取执行sql的对象 prepareStatement
			pstmt = conn.prepareStatement(sql);
			// 从User类中传来的参数
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			
			//5. 执行sql语句
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// 查到进行实例化
				resultUser = new User();
				resultUser.setId(rs.getInt("id"));
				resultUser.setUsername(rs.getString("name"));
				resultUser.setPassword(rs.getString("password"));
			}
			

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
		return resultUser;
}
}
