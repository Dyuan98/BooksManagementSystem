package util;
/**
 * 字符串工具类
 * @author yuan
 *
 */
public class Stringutils {
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			// 判断字符串是否为空，或是由空格组成
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * 判断字符串是否不是空
	 */
	public static boolean isNotEmpty(String str) {
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}

}
