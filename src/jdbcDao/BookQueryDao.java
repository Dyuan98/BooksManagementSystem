package jdbcDao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Book;
import util.Stringutils;


public class BookQueryDao {

	/**
	 *  查询图书
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection conn,Book book)throws Exception {
		ResultSet rs = null;

		PreparedStatement pstmt = null;
		try {

			//3.定义sql语句
//			StringBuffer sb = new StringBuffer("select * from books");
			String sql = "select * from books";
			
//			if(Stringutils.isNotEmpty(book.getBtype())) {
////				 使用工具类Stringutils检测用户输入的信息是否为空
//				sb.append("and btype like  '%"+book.getBtype()+"%' ");
//			}
//
//			//4. 获取执行sql的对象 prepareStatement
//			pstmt = conn.prepareStatement(sb.toString().replace("and", "where"));
////			pstmt = conn.prepareStatement("select * from books where bname = '三体'");
			
			if(Stringutils.isNotEmpty(book.getBtype())) {
					// 使用工具类Stringutils检测用户输入的信息是否为空
				System.out.println("测试"+ book.getText());
				sql  = "select * from books where  btype like  '%"+book.getBtype()+"%' " ;
			}else if (Stringutils.isNotEmpty(book.getBname())) {
				sql  = "select * from books where  bname like  '%"+book.getBname()+"%' " ;
			}else if (book.getText()!=null&&book.getText().equals("id")) {
				System.out.println(book.getBnum());
				sql  = "select * from books where  bnum ="+book.getBnum()  ;
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
