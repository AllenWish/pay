package cn.cgy.pojo;

public class AwUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_user.id
     *
     * @mbggenerated Tue Nov 21 16:06:07 GMT+08:00 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_user.username
     *
     * @mbggenerated Tue Nov 21 16:06:07 GMT+08:00 2017
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_user.flag
     *
     * @mbggenerated Tue Nov 21 16:06:07 GMT+08:00 2017
     */
    private String flag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_user.id
     *
     * @return the value of aw_user.id
     *
     * @mbggenerated Tue Nov 21 16:06:07 GMT+08:00 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_user.id
     *
     * @param id the value for aw_user.id
     *
     * @mbggenerated Tue Nov 21 16:06:07 GMT+08:00 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_user.username
     *
     * @return the value of aw_user.username
     *
     * @mbggenerated Tue Nov 21 16:06:07 GMT+08:00 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_user.username
     *
     * @param username the value for aw_user.username
     *
     * @mbggenerated Tue Nov 21 16:06:07 GMT+08:00 2017
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_user.flag
     *
     * @return the value of aw_user.flag
     *
     * @mbggenerated Tue Nov 21 16:06:07 GMT+08:00 2017
     */
    public String getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_user.flag
     *
     * @param flag the value for aw_user.flag
     *
     * @mbggenerated Tue Nov 21 16:06:07 GMT+08:00 2017
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}