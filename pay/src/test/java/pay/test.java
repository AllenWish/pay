package pay;

import cn.cgy.pojo.Outpay;
import cn.cgy.pojo.User;
import cn.cgy.utils.DateUtils;

public class test {
	public static void main(String[] args) {
		String date = DateUtils.getCurrentTime(DateUtils.date_19_1);
		System.out.println(date);
		
		Integer i = null;
		
		Outpay pay = new Outpay();
		
		User uer = new User();
		
		System.out.println(pay);
		System.out.println(uer);
		
	}
}
