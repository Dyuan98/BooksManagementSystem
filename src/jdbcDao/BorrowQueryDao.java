package jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.BorrowInfo;



public class BorrowQueryDao {

	/**
	 *  按名字查询书籍借阅信息
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection conn,BorrowInfo borrowinfo)throws Exception {
		ResultSet rs = null;

		PreparedStatement pstmt = null;
		try {
			String sql = "select * from v_binfo"; 
			if(borrowinfo.getTemp()!=null&&borrowinfo.getTemp().equals("booknum")) {
				sql = "select * from v_binfo where bnum = "+ borrowinfo.getInfo();
			}else if(borrowinfo.getTemp()!=null&&borrowinfo.getTemp().equals("vid")) {
				System.out.println(borrowinfo.getInfo());
				sql = "select * from v_binfo where vid = "+ borrowinfo.getInfo();
			}
			pstmt = conn.prepareStatement(sql.toString());
			//5. 执行sql语句
			rs =  pstmt.executeQuery();  //返回结果集

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
