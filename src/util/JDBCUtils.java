package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.sql.SQLException;


/**
 * JDBC工具类
 */

public class JDBCUtils {
	/**
	 *  文件的读取，只需要读取一次即可拿到这些值，使用静态代码块
	 */
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
	
	static{
		// 读取资源文件，获取值
		try {
			//1.properties集合类
			Properties pro = new Properties();
			
			// 若是使用绝对路径，代码的可移植性降低，所以采用动态设置配置文件的路径
			// 获取src路径下的文件的方式 --》 ClassLoader类加载器
			
			ClassLoader classloder = JDBCUtils.class.getClassLoader();
			URL resourse = classloder.getResource("jdbc.properties");
			String path = resourse.getPath();
//			System.out.println(path);  由于路径中某个文件名中含有空格，
//			而getPath()对象返回时将空格自动转化为“%20”，与路径名不相同，需要替换回来
			path = path.replace("%20", " ");
			
			//2.加载文件
//			pro.load(new FileReader("D:\\javaEE\\My Worksapce\\DataBase\\src\\jdbc.properties"));
			pro.load(new FileReader(path));
			
			//3.获取数据，赋值
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			driver= pro.getProperty("driver");
			
			//4。注册驱动
			Class.forName(driver);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		//获取连接
		//@return 连接对象
		try {
			return DriverManager.getConnection(url, user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void colse(Statement stmt, Connection conn) {
		//释放资源
		if(stmt != null) {
			//判断stmt是否为空，避免空指针异常
			try {
				stmt.close();
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
	
	public static void colse( ResultSet rs, Statement stmt, Connection conn) {
		//重载
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//释放资源
		if(stmt != null) {
			//判断stmt是否为空，避免空指针异常
			try {
				stmt.close();
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
}
