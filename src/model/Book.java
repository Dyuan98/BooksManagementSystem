package model;

import util.Stringutils;

/**
 *  图书实体
 * @author yuan
 *
 */
public class Book {
	private int bnum;    //图书编号
	private String bname;   //图书名
	private String btype;   // 图书类型
	private String bwriter;  // 图书作者
	private double bprice;    // 图书价格
	private int bamount;     // 图书数量
	private String text;
	public Book() {
		super();
	}
	
	public Book(int bnum) {
		super();
		this.bnum = bnum;
	}

	public Book(String temp, String text) {
		super();
		if(text.equals("type")) {
			System.out.println("type");
			this.btype = temp;
		}else if(text.equals("name")) {
			this.bname = temp;	
		}else if(text.equals("id")&&Stringutils.isNotEmpty(temp)) {
			System.out.println("id测试"+text+temp);
			int temp1 = Integer.valueOf(temp).intValue();
			this.bnum = temp1;
			this.text = text;
		}
	}


	public Book(int bookId, String bname, String btype, String bwriter, Double bookPrice, int bookWriter) {
		super();
		this.bnum = bookId;
		this.bname = bname;
		this.btype = btype;
		this.bwriter = bwriter;
		this.bprice = bookPrice;
		this.bamount = bookWriter;
	}
	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getBprice() {
		return bprice;
	}

	public void setBprice(double bprice) {
		this.bprice = bprice;
	}

	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public int getBamount() {
		return bamount;
	}
	public void setBamount(int bamount) {
		this.bamount = bamount;
	}
	
	
}
