package cn.cgy.dao;

import cn.cgy.pojo.AwClass;
import java.util.List;

public interface AwClassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_class
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_class
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    int insert(AwClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_class
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    AwClass selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_class
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    List<AwClass> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_class
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    int updateByPrimaryKey(AwClass record);
}