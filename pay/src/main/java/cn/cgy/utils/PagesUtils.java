package cn.cgy.utils;
/**
 * 页面地址
 * @author AllenWish-CGy
 * @since 2016年5月10日 下午9:46:11
 */
public class PagesUtils {
	/**
	 * 跳转到首页
	 */
	public static final String TO_INDEX = "index";
	public static final String MY_PAGE = "mypage";
	
	/**
	 * 对比
	 */
	public static final String COMPLATE = "complate";
	
	/**
	 * 管理
	 */
	public static final String MANAGE = "manage";
	/**
	 * 关于
	 */
	public static final String ABOUT = "about";
	/**
	 * 插入一条支出数据
	 */
	public static final String INSERT_OUTPAY = "insertOutpay";
	/**
	 * 更新支出数据
	 */
	public static final String UPDATE_OUTPAY = "updateOutpay";
	/**
	 * 删除支出数据
	 */
	public static final String DELETE_OUTPAY = "deleteOutpay";
	/**
	 * 显示所有支出
	 */
	public static final String SHOW_OUTPAY = "showOutpay";
	
	
	
	/**
	 * 重定向
	 * @param redirect
	 * @return redirect
	 */
	public static String redirect(String redirect){
		return "redirect:"+redirect;
	}
}
