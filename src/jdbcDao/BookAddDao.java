package jdbcDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import model.Book;

/**
 *  图书添加Dao类
 * @author yuan
 *
 */
public class BookAddDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int rs = -0;
	
	/**
	 * 	图书添加
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(  Book book)throws Exception{

		try {
			//1.注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.获取Connection对象
			String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
			String user1 = "root";
			String password = "111" ;
			conn = DriverManager.getConnection(url, user1, password);
			String sql = "insert into books values(?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getBnum());
			pstmt.setString(2,book.getBname() );
			pstmt.setString(3, book.getBtype());
			pstmt.setString(4, book.getBwriter());
			pstmt.setDouble(5, book.getBprice());
			pstmt.setInt(6, book.getBamount());
			
			rs = pstmt.executeUpdate();  	// 执行语句，得到返回的int值，可以判断是否添加成功
			
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
