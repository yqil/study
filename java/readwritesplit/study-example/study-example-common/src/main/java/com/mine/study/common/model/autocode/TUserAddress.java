package com.mine.study.common.model.autocode;

import java.io.Serializable;
import java.util.Date;

public class TUserAddress implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.addr_id
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private String addrId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.user_id
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.province
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.area
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private String area;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.city
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.street
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private String street;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.post_code
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private Integer postCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.phone
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.receiver_name
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private String receiverName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.if_default
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private Integer ifDefault;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.create_time
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_address.status
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.addr_id
     *
     * @return the value of t_user_address.addr_id
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public String getAddrId() {
        return addrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.addr_id
     *
     * @param addrId the value for t_user_address.addr_id
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setAddrId(String addrId) {
        this.addrId = addrId == null ? null : addrId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.user_id
     *
     * @return the value of t_user_address.user_id
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.user_id
     *
     * @param userId the value for t_user_address.user_id
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.province
     *
     * @return the value of t_user_address.province
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.province
     *
     * @param province the value for t_user_address.province
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.area
     *
     * @return the value of t_user_address.area
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.area
     *
     * @param area the value for t_user_address.area
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.city
     *
     * @return the value of t_user_address.city
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.city
     *
     * @param city the value for t_user_address.city
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.street
     *
     * @return the value of t_user_address.street
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public String getStreet() {
        return street;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.street
     *
     * @param street the value for t_user_address.street
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.address
     *
     * @return the value of t_user_address.address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.address
     *
     * @param address the value for t_user_address.address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.post_code
     *
     * @return the value of t_user_address.post_code
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public Integer getPostCode() {
        return postCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.post_code
     *
     * @param postCode the value for t_user_address.post_code
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.phone
     *
     * @return the value of t_user_address.phone
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.phone
     *
     * @param phone the value for t_user_address.phone
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.receiver_name
     *
     * @return the value of t_user_address.receiver_name
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.receiver_name
     *
     * @param receiverName the value for t_user_address.receiver_name
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.if_default
     *
     * @return the value of t_user_address.if_default
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public Integer getIfDefault() {
        return ifDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.if_default
     *
     * @param ifDefault the value for t_user_address.if_default
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setIfDefault(Integer ifDefault) {
        this.ifDefault = ifDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.create_time
     *
     * @return the value of t_user_address.create_time
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.create_time
     *
     * @param createTime the value for t_user_address.create_time
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_address.status
     *
     * @return the value of t_user_address.status
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_address.status
     *
     * @param status the value for t_user_address.status
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}