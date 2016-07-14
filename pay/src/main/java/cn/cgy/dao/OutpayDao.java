package cn.cgy.dao;

import java.util.List;

import cn.cgy.pojo.Outpay;
/**
 * @author AllenWish-CGy
 * @since 2016年5月10日 下午9:54:31
 */
public interface OutpayDao {
	/**
	 * 查询所有Outpay
	 * @return Outpay
	 * @throws Exception
	 */
	public List<Outpay> queryOutpay() throws Exception;
	/**
	 * 根据条件查询所有Outpay
	 * @return Outpay
	 * @throws Exception
	 */
	public List<Outpay> queryOutpay(Outpay outpay) throws Exception;
	/**
	 * 根据id查询记录
	 * @param id
	 * @return outpay
	 * @throws Exception
	 */
	public Outpay queryOutpayById(int id) throws Exception;
	/**
	 * 插入一条记录
	 * @param outpay
	 * @throws Exception
	 */
	public void insert(Outpay outpay) throws Exception;
	/**
	 * 更新一条记录
	 * @param outpay
	 * @throws Exception
	 */
	public void update(Outpay outpay) throws Exception;
	/**
	 * 根据id删除一条记录
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception;
}
