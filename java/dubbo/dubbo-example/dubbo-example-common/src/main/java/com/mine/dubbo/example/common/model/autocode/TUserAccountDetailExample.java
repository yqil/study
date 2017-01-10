package com.mine.dubbo.example.common.model.autocode;

import com.mine.study.whole.util.mybatis.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserAccountDetailExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    protected Page page;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public TUserAccountDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public Page getPage() {
        return page;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAccountDetailIdIsNull() {
            addCriterion("account_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdIsNotNull() {
            addCriterion("account_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdEqualTo(String value) {
            addCriterion("account_detail_id =", value, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdNotEqualTo(String value) {
            addCriterion("account_detail_id <>", value, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdGreaterThan(String value) {
            addCriterion("account_detail_id >", value, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_detail_id >=", value, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdLessThan(String value) {
            addCriterion("account_detail_id <", value, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdLessThanOrEqualTo(String value) {
            addCriterion("account_detail_id <=", value, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdLike(String value) {
            addCriterion("account_detail_id like", value, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdNotLike(String value) {
            addCriterion("account_detail_id not like", value, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdIn(List<String> values) {
            addCriterion("account_detail_id in", values, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdNotIn(List<String> values) {
            addCriterion("account_detail_id not in", values, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdBetween(String value1, String value2) {
            addCriterion("account_detail_id between", value1, value2, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountDetailIdNotBetween(String value1, String value2) {
            addCriterion("account_detail_id not between", value1, value2, "accountDetailId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountIsNull() {
            addCriterion("before_amount is null");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountIsNotNull() {
            addCriterion("before_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountEqualTo(Integer value) {
            addCriterion("before_amount =", value, "beforeAmount");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountNotEqualTo(Integer value) {
            addCriterion("before_amount <>", value, "beforeAmount");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountGreaterThan(Integer value) {
            addCriterion("before_amount >", value, "beforeAmount");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("before_amount >=", value, "beforeAmount");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountLessThan(Integer value) {
            addCriterion("before_amount <", value, "beforeAmount");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("before_amount <=", value, "beforeAmount");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountIn(List<Integer> values) {
            addCriterion("before_amount in", values, "beforeAmount");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountNotIn(List<Integer> values) {
            addCriterion("before_amount not in", values, "beforeAmount");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountBetween(Integer value1, Integer value2) {
            addCriterion("before_amount between", value1, value2, "beforeAmount");
            return (Criteria) this;
        }

        public Criteria andBeforeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("before_amount not between", value1, value2, "beforeAmount");
            return (Criteria) this;
        }

        public Criteria andAfterAmountIsNull() {
            addCriterion("after_amount is null");
            return (Criteria) this;
        }

        public Criteria andAfterAmountIsNotNull() {
            addCriterion("after_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAfterAmountEqualTo(Integer value) {
            addCriterion("after_amount =", value, "afterAmount");
            return (Criteria) this;
        }

        public Criteria andAfterAmountNotEqualTo(Integer value) {
            addCriterion("after_amount <>", value, "afterAmount");
            return (Criteria) this;
        }

        public Criteria andAfterAmountGreaterThan(Integer value) {
            addCriterion("after_amount >", value, "afterAmount");
            return (Criteria) this;
        }

        public Criteria andAfterAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("after_amount >=", value, "afterAmount");
            return (Criteria) this;
        }

        public Criteria andAfterAmountLessThan(Integer value) {
            addCriterion("after_amount <", value, "afterAmount");
            return (Criteria) this;
        }

        public Criteria andAfterAmountLessThanOrEqualTo(Integer value) {
            addCriterion("after_amount <=", value, "afterAmount");
            return (Criteria) this;
        }

        public Criteria andAfterAmountIn(List<Integer> values) {
            addCriterion("after_amount in", values, "afterAmount");
            return (Criteria) this;
        }

        public Criteria andAfterAmountNotIn(List<Integer> values) {
            addCriterion("after_amount not in", values, "afterAmount");
            return (Criteria) this;
        }

        public Criteria andAfterAmountBetween(Integer value1, Integer value2) {
            addCriterion("after_amount between", value1, value2, "afterAmount");
            return (Criteria) this;
        }

        public Criteria andAfterAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("after_amount not between", value1, value2, "afterAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIsNull() {
            addCriterion("change_amount is null");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIsNotNull() {
            addCriterion("change_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChangeAmountEqualTo(Integer value) {
            addCriterion("change_amount =", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotEqualTo(Integer value) {
            addCriterion("change_amount <>", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountGreaterThan(Integer value) {
            addCriterion("change_amount >", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_amount >=", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountLessThan(Integer value) {
            addCriterion("change_amount <", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("change_amount <=", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIn(List<Integer> values) {
            addCriterion("change_amount in", values, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotIn(List<Integer> values) {
            addCriterion("change_amount not in", values, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountBetween(Integer value1, Integer value2) {
            addCriterion("change_amount between", value1, value2, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("change_amount not between", value1, value2, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andSceneIsNull() {
            addCriterion("scene is null");
            return (Criteria) this;
        }

        public Criteria andSceneIsNotNull() {
            addCriterion("scene is not null");
            return (Criteria) this;
        }

        public Criteria andSceneEqualTo(String value) {
            addCriterion("scene =", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotEqualTo(String value) {
            addCriterion("scene <>", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneGreaterThan(String value) {
            addCriterion("scene >", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneGreaterThanOrEqualTo(String value) {
            addCriterion("scene >=", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLessThan(String value) {
            addCriterion("scene <", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLessThanOrEqualTo(String value) {
            addCriterion("scene <=", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLike(String value) {
            addCriterion("scene like", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotLike(String value) {
            addCriterion("scene not like", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneIn(List<String> values) {
            addCriterion("scene in", values, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotIn(List<String> values) {
            addCriterion("scene not in", values, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneBetween(String value1, String value2) {
            addCriterion("scene between", value1, value2, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotBetween(String value1, String value2) {
            addCriterion("scene not between", value1, value2, "scene");
            return (Criteria) this;
        }

        public Criteria andChangeDescIsNull() {
            addCriterion("change_desc is null");
            return (Criteria) this;
        }

        public Criteria andChangeDescIsNotNull() {
            addCriterion("change_desc is not null");
            return (Criteria) this;
        }

        public Criteria andChangeDescEqualTo(String value) {
            addCriterion("change_desc =", value, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescNotEqualTo(String value) {
            addCriterion("change_desc <>", value, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescGreaterThan(String value) {
            addCriterion("change_desc >", value, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescGreaterThanOrEqualTo(String value) {
            addCriterion("change_desc >=", value, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescLessThan(String value) {
            addCriterion("change_desc <", value, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescLessThanOrEqualTo(String value) {
            addCriterion("change_desc <=", value, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescLike(String value) {
            addCriterion("change_desc like", value, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescNotLike(String value) {
            addCriterion("change_desc not like", value, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescIn(List<String> values) {
            addCriterion("change_desc in", values, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescNotIn(List<String> values) {
            addCriterion("change_desc not in", values, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescBetween(String value1, String value2) {
            addCriterion("change_desc between", value1, value2, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andChangeDescNotBetween(String value1, String value2) {
            addCriterion("change_desc not between", value1, value2, "changeDesc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_user_account_detail
     *
     * @mbggenerated do_not_delete_during_merge Tue Jan 10 15:42:50 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_user_account_detail
     *
     * @mbggenerated Tue Jan 10 15:42:50 CST 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}