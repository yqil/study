package com.mine.study.api.dao.autocode;

import com.mine.study.common.model.autocode.TUserThird;
import com.mine.study.common.model.autocode.TUserThirdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserThirdMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    int countByExample(TUserThirdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    int deleteByExample(TUserThirdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    int insert(TUserThird record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    int insertSelective(TUserThird record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    List<TUserThird> selectByExample(TUserThirdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    TUserThird selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    int updateByExampleSelective(@Param("record") TUserThird record, @Param("example") TUserThirdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    int updateByExample(@Param("record") TUserThird record, @Param("example") TUserThirdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    int updateByPrimaryKeySelective(TUserThird record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_third
     *
     * @mbggenerated Mon Nov 28 14:41:56 CST 2016
     */
    int updateByPrimaryKey(TUserThird record);
}