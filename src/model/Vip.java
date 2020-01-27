package model;


/**
 * 	vip实体
 * @author yuan
 *
 */
public class Vip {
	private int vid;  
	private String vname;
	private long vphone;
	private String vpassd;
	private double vmoney;
	private String temp;
	
	public Vip() {
		super();
	}
	
	public Vip(int vid, String temp) {
		super();
		this.vid = vid;
		this.temp = temp;
	}

	public Vip(int vid) {
		super();
		this.vid = vid;
	}
	public Vip(int vid, String vname, long vphone, String vpassd, double vmoney) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vphone = vphone;
		this.vpassd = vpassd;
		this.vmoney = vmoney;
	}


	
	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	
public long getVphone() {
		return vphone;
	}


	public void setVphone(long vphone) {
		this.vphone = vphone;
	}


	//	public int getVphone() {
//		return vphone;
//	}
//	public void setVphone(int vphone) {
//		this.vphone = vphone;
//	}
	public String getVpassd() {
		return vpassd;
	}
	public void setVpassd(String vpassd) {
		this.vpassd = vpassd;
	}
	public double getVmoney() {
		return vmoney;
	}
	public void setVmoney(double vmoney) {
		this.vmoney = vmoney;
	}
}
