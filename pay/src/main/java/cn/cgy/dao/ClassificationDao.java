package cn.cgy.dao;

import java.util.List;

import cn.cgy.pojo.Classification;

/**
 * @author AllenWish-CGy
 * @since 2016年5月23日 下午9:54:31
 */
public interface ClassificationDao {
	
	/**
	 * 查询所有类别
	 * @return 所有类别List<Classification>
	 * @throws Exception
	 */
	public List<Classification> findAllClass() throws Exception;
	/**
	 * 根据id查找类别
	 * @param id
	 * @return 类别Classification
	 * @throws Exception
	 */
	public Classification findClassById(int id) throws Exception;
	
	/**
	 * 插入一条类别
	 * @param classification
	 * @throws Exception
	 */
	public void insert(Classification classification) throws Exception;
	/**
	 * 更新类别
	 * @param classification
	 * @throws Exception
	 */
	public void update(Classification classification) throws Exception;
	/**
	 * 根据id删除类别
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(int id) throws Exception;
}
