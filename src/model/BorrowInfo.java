package model;

/**
 *  图书借阅信息
 * @author yuan
 *
 */
public class BorrowInfo {
	private int vid;
	private int bnum;
	private String date;
	private String vpassd;
	
	
	private int  info;
	private String temp; 
	public BorrowInfo() {
		super();
	}
	
	
	public int getVid() {
		return vid;
	}
	public BorrowInfo(int info,String temp) {
		// info 用于接收图书编号或会员编号，temp用来判断什么类型的查询
		super();
		this.info = info;
		this.temp = temp;
	}

	public BorrowInfo(int vid, int bnum, String vpassd) {
		super();
		this.vid = vid;
		this.bnum = bnum;
		this.vpassd = vpassd;
	}

	
	
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getVpassd() {
		return vpassd;
	}

	public void setVpassd(String vpassd) {
		this.vpassd = vpassd;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	
	

}
