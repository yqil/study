package com.mine.dubbo.example.common.model.autocode;

import java.io.Serializable;
import java.util.Date;

public class TUserAccountDetail implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account_detail.account_detail_id
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    private String accountDetailId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account_detail.account_id
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    private String accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account_detail.before_amount
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    private Integer beforeAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account_detail.after_amount
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    private Integer afterAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account_detail.change_amount
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    private Integer changeAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account_detail.channel
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    private String channel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account_detail.scene
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    private String scene;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account_detail.change_desc
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    private String changeDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account_detail.create_time
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account_detail.account_detail_id
     *
     * @return the value of t_user_account_detail.account_detail_id
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public String getAccountDetailId() {
        return accountDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account_detail.account_detail_id
     *
     * @param accountDetailId the value for t_user_account_detail.account_detail_id
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setAccountDetailId(String accountDetailId) {
        this.accountDetailId = accountDetailId == null ? null : accountDetailId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account_detail.account_id
     *
     * @return the value of t_user_account_detail.account_id
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account_detail.account_id
     *
     * @param accountId the value for t_user_account_detail.account_id
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account_detail.before_amount
     *
     * @return the value of t_user_account_detail.before_amount
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public Integer getBeforeAmount() {
        return beforeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account_detail.before_amount
     *
     * @param beforeAmount the value for t_user_account_detail.before_amount
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setBeforeAmount(Integer beforeAmount) {
        this.beforeAmount = beforeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account_detail.after_amount
     *
     * @return the value of t_user_account_detail.after_amount
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public Integer getAfterAmount() {
        return afterAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account_detail.after_amount
     *
     * @param afterAmount the value for t_user_account_detail.after_amount
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setAfterAmount(Integer afterAmount) {
        this.afterAmount = afterAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account_detail.change_amount
     *
     * @return the value of t_user_account_detail.change_amount
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public Integer getChangeAmount() {
        return changeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account_detail.change_amount
     *
     * @param changeAmount the value for t_user_account_detail.change_amount
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setChangeAmount(Integer changeAmount) {
        this.changeAmount = changeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account_detail.channel
     *
     * @return the value of t_user_account_detail.channel
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public String getChannel() {
        return channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account_detail.channel
     *
     * @param channel the value for t_user_account_detail.channel
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account_detail.scene
     *
     * @return the value of t_user_account_detail.scene
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public String getScene() {
        return scene;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account_detail.scene
     *
     * @param scene the value for t_user_account_detail.scene
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setScene(String scene) {
        this.scene = scene == null ? null : scene.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account_detail.change_desc
     *
     * @return the value of t_user_account_detail.change_desc
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public String getChangeDesc() {
        return changeDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account_detail.change_desc
     *
     * @param changeDesc the value for t_user_account_detail.change_desc
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setChangeDesc(String changeDesc) {
        this.changeDesc = changeDesc == null ? null : changeDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account_detail.create_time
     *
     * @return the value of t_user_account_detail.create_time
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account_detail.create_time
     *
     * @param createTime the value for t_user_account_detail.create_time
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}