package com.mine.dubbo.example.common.model.autocode;

import java.io.Serializable;
import java.util.Date;

public class TUserAccount implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.account_id
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    private String accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.user_id
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.account_type
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    private String accountType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.account_amount
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    private Integer accountAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.account_balance
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    private Integer accountBalance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.crc_info
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    private String crcInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.create_time
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.status
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_account
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.account_id
     *
     * @return the value of t_user_account.account_id
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.account_id
     *
     * @param accountId the value for t_user_account.account_id
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.user_id
     *
     * @return the value of t_user_account.user_id
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.user_id
     *
     * @param userId the value for t_user_account.user_id
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.account_type
     *
     * @return the value of t_user_account.account_type
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.account_type
     *
     * @param accountType the value for t_user_account.account_type
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.account_amount
     *
     * @return the value of t_user_account.account_amount
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public Integer getAccountAmount() {
        return accountAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.account_amount
     *
     * @param accountAmount the value for t_user_account.account_amount
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public void setAccountAmount(Integer accountAmount) {
        this.accountAmount = accountAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.account_balance
     *
     * @return the value of t_user_account.account_balance
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public Integer getAccountBalance() {
        return accountBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.account_balance
     *
     * @param accountBalance the value for t_user_account.account_balance
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.crc_info
     *
     * @return the value of t_user_account.crc_info
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public String getCrcInfo() {
        return crcInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.crc_info
     *
     * @param crcInfo the value for t_user_account.crc_info
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public void setCrcInfo(String crcInfo) {
        this.crcInfo = crcInfo == null ? null : crcInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.create_time
     *
     * @return the value of t_user_account.create_time
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.create_time
     *
     * @param createTime the value for t_user_account.create_time
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.status
     *
     * @return the value of t_user_account.status
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.status
     *
     * @param status the value for t_user_account.status
     *
     * @mbggenerated Tue Jan 10 15:42:19 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}