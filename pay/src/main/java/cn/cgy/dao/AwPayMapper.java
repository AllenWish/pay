package cn.cgy.dao;

import cn.cgy.pojo.AwPay;
import java.util.List;
import java.util.Map;

public interface AwPayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_pay
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_pay
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    int insert(AwPay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_pay
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    AwPay selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_pay
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    List<AwPay> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_pay
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    int updateByPrimaryKey(AwPay record);

    List<Map<String,Object>> getData(Map<String, Object> paramsMap);
}