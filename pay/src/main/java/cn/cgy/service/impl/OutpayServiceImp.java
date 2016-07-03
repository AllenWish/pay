package cn.cgy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cgy.dao.OutpayDao;
import cn.cgy.pojo.Outpay;
import cn.cgy.service.OutpayService;

@Service("OutPayService")
public class OutpayServiceImp implements OutpayService{
	
	@Autowired
	private OutpayDao dao;

	public List<Outpay> queryOutpay() throws Exception {
		return this.dao.queryOutpay();
	}

	public Outpay queryOutpayById(int id) throws Exception {
		return this.dao.queryOutpayById(id);
	}

	public void insert(Outpay outpay) throws Exception {
		this.dao.insert(outpay);
	}

	public void update(Outpay outpay) throws Exception {
		this.dao.update(outpay);
	}

	public void delete(int id) throws Exception {
		this.dao.delete(id);
	}

}
