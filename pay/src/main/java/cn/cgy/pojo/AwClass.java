package cn.cgy.pojo;

import java.io.Serializable;

public class AwClass implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_class.id
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_class.class_name
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    private String className;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_class.class_level
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    private String classLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_class.parent_id
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    private Integer parentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_class.id
     *
     * @return the value of aw_class.id
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_class.id
     *
     * @param id the value for aw_class.id
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_class.class_name
     *
     * @return the value of aw_class.class_name
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    public String getClassName() {
        return className;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_class.class_name
     *
     * @param className the value for aw_class.class_name
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_class.class_level
     *
     * @return the value of aw_class.class_level
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    public String getClassLevel() {
        return classLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_class.class_level
     *
     * @param classLevel the value for aw_class.class_level
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel == null ? null : classLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_class.parent_id
     *
     * @return the value of aw_class.parent_id
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_class.parent_id
     *
     * @param parentId the value for aw_class.parent_id
     *
     * @mbggenerated Tue Nov 21 15:56:43 GMT+08:00 2017
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "AwClass{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", classLevel='" + classLevel + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}