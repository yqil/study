package com.mine.dubbo.example.common.model.autocode;

import java.io.Serializable;

public class TUserThird implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_third.id
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_third.user_id
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_third.app_id
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    private String appId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_third.type
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    private Byte type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_third
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_third.id
     *
     * @return the value of t_user_third.id
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_third.id
     *
     * @param id the value for t_user_third.id
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_third.user_id
     *
     * @return the value of t_user_third.user_id
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_third.user_id
     *
     * @param userId the value for t_user_third.user_id
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_third.app_id
     *
     * @return the value of t_user_third.app_id
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    public String getAppId() {
        return appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_third.app_id
     *
     * @param appId the value for t_user_third.app_id
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_third.type
     *
     * @return the value of t_user_third.type
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_third.type
     *
     * @param type the value for t_user_third.type
     *
     * @mbggenerated Tue Jan 10 15:44:52 CST 2017
     */
    public void setType(Byte type) {
        this.type = type;
    }
}