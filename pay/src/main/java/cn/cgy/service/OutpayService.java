package cn.cgy.service;

import java.util.List;

import cn.cgy.pojo.Outpay;

public interface OutpayService {
	/**
	 * 获取所有记录集
	 */
	public List<Outpay> queryOutpay() throws Exception;
	/**
	 * 根据ID获取记录
	 */
	public Outpay queryOutpayById(int id) throws Exception;
	
	/**
	 * 根据条件获取记录
	 */
	public List<Outpay> queryOutpay(Outpay outpay) throws Exception;
	
	/**
	 * 插入一条记录集
	 */
	public void insert(Outpay outpay) throws Exception;
	/**
	 * 更新记录
	 */
	public void update(Outpay outpay) throws Exception;
	/**
	 * 根据ID删除记录
	 */
	public void delete(int id) throws Exception;
}
