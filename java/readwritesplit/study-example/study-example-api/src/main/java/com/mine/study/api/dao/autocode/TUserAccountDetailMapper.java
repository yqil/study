package com.mine.study.api.dao.autocode;

import com.mine.study.common.model.autocode.TUserAccountDetail;
import com.mine.study.common.model.autocode.TUserAccountDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserAccountDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    int countByExample(TUserAccountDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    int deleteByExample(TUserAccountDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    int deleteByPrimaryKey(String accountDetailId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    int insert(TUserAccountDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    int insertSelective(TUserAccountDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    List<TUserAccountDetail> selectByExample(TUserAccountDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    TUserAccountDetail selectByPrimaryKey(String accountDetailId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    int updateByExampleSelective(@Param("record") TUserAccountDetail record, @Param("example") TUserAccountDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    int updateByExample(@Param("record") TUserAccountDetail record, @Param("example") TUserAccountDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    int updateByPrimaryKeySelective(TUserAccountDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Mon Dec 19 15:46:15 CST 2016
     */
    int updateByPrimaryKey(TUserAccountDetail record);
}