package cn.cgy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cgy.dao.ClassificationDao;
import cn.cgy.pojo.Classification;
import cn.cgy.service.ClassificationService;

@Service("ClassificationService")
public class ClassificationServiceImp implements ClassificationService {

	@Autowired
	private ClassificationDao dao;

	public List<Classification> findAllClass() throws Exception {
		return dao.findAllClass();
	}

	public Classification findClassById(int id) throws Exception {
		return dao.findClassById(id);
	}

	public void insert(Classification classification) throws Exception {
		dao.insert(classification);
	}

	public void update(Classification classification) throws Exception {
		dao.update(classification);
	}

	public void deleteById(int id) throws Exception {
		dao.deleteById(id);
	}

}
