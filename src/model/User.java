package model;
/**
 * 用户实体
 * @author yuan
 *
 */
public class User {
	private int id;  //编号
	private String username;   //用户名
	private String password;    //密码
	
	
	
	
	public User() {
		// 无参的构造方法
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	public User(String username, String password) {
		// 含有 user，password 两个参数的构造方法
		super();
		this.password = password;
		this.username = username;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String user) {
		this.username = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
