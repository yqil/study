package com.mine.study.api.dao.autocode;

import com.mine.study.common.model.autocode.TUserAddress;
import com.mine.study.common.model.autocode.TUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    int countByExample(TUserAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    int deleteByExample(TUserAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    int deleteByPrimaryKey(String addrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    int insert(TUserAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    int insertSelective(TUserAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    List<TUserAddress> selectByExample(TUserAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    TUserAddress selectByPrimaryKey(String addrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    int updateByExampleSelective(@Param("record") TUserAddress record, @Param("example") TUserAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    int updateByExample(@Param("record") TUserAddress record, @Param("example") TUserAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    int updateByPrimaryKeySelective(TUserAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_address
     *
     * @mbggenerated Mon Nov 28 14:41:50 CST 2016
     */
    int updateByPrimaryKey(TUserAddress record);
}