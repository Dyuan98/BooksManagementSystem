package jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Vip;

public class VipQueryDao {
	public ResultSet list(Connection conn,Vip vip)throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from vips"; 
			if(vip.getTemp()!=null&&vip.getTemp().equals("vid")) {
				int vid = vip.getVid();
				sql = "select * from vips where vid = ?";
				pstmt = conn.prepareStatement(sql.toString());
				//5. 执行sql语句
				pstmt.setInt(1, vid);
			}else {
				pstmt = conn.prepareStatement(sql.toString());
			}
			rs =  pstmt.executeQuery();  //返回结果集
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
