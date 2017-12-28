package cn.cgy.pojo;

import java.io.Serializable;

public class AwPay implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_pay.id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_pay.user_id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_pay.big_class_id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    private Integer bigClassId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_pay.sm_class_id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    private Integer smClassId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_pay.j_amount
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    private Double jAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_pay.create_time
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    private String createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_pay.id
     *
     * @return the value of aw_pay.id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_pay.id
     *
     * @param id the value for aw_pay.id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_pay.user_id
     *
     * @return the value of aw_pay.user_id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_pay.user_id
     *
     * @param userId the value for aw_pay.user_id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_pay.big_class_id
     *
     * @return the value of aw_pay.big_class_id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public Integer getBigClassId() {
        return bigClassId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_pay.big_class_id
     *
     * @param bigClassId the value for aw_pay.big_class_id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public void setBigClassId(Integer bigClassId) {
        this.bigClassId = bigClassId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_pay.sm_class_id
     *
     * @return the value of aw_pay.sm_class_id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public Integer getSmClassId() {
        return smClassId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_pay.sm_class_id
     *
     * @param smClassId the value for aw_pay.sm_class_id
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public void setSmClassId(Integer smClassId) {
        this.smClassId = smClassId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_pay.j_amount
     *
     * @return the value of aw_pay.j_amount
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public Double getjAmount() {
        return jAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_pay.j_amount
     *
     * @param jAmount the value for aw_pay.j_amount
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public void setjAmount(Double jAmount) {
        this.jAmount = jAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_pay.create_time
     *
     * @return the value of aw_pay.create_time
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_pay.create_time
     *
     * @param createTime the value for aw_pay.create_time
     *
     * @mbggenerated Tue Nov 21 13:57:04 GMT+08:00 2017
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}