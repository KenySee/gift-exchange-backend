package com.bootdo.domain.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNull() {
            addCriterion("userpassword is null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNotNull() {
            addCriterion("userpassword is not null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordEqualTo(String value) {
            addCriterion("userpassword =", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotEqualTo(String value) {
            addCriterion("userpassword <>", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThan(String value) {
            addCriterion("userpassword >", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("userpassword >=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThan(String value) {
            addCriterion("userpassword <", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThanOrEqualTo(String value) {
            addCriterion("userpassword <=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLike(String value) {
            addCriterion("userpassword like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotLike(String value) {
            addCriterion("userpassword not like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIn(List<String> values) {
            addCriterion("userpassword in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotIn(List<String> values) {
            addCriterion("userpassword not in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordBetween(String value1, String value2) {
            addCriterion("userpassword between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotBetween(String value1, String value2) {
            addCriterion("userpassword not between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andUserstatusIsNull() {
            addCriterion("userstatus is null");
            return (Criteria) this;
        }

        public Criteria andUserstatusIsNotNull() {
            addCriterion("userstatus is not null");
            return (Criteria) this;
        }

        public Criteria andUserstatusEqualTo(String value) {
            addCriterion("userstatus =", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotEqualTo(String value) {
            addCriterion("userstatus <>", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusGreaterThan(String value) {
            addCriterion("userstatus >", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusGreaterThanOrEqualTo(String value) {
            addCriterion("userstatus >=", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusLessThan(String value) {
            addCriterion("userstatus <", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusLessThanOrEqualTo(String value) {
            addCriterion("userstatus <=", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusLike(String value) {
            addCriterion("userstatus like", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotLike(String value) {
            addCriterion("userstatus not like", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusIn(List<String> values) {
            addCriterion("userstatus in", values, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotIn(List<String> values) {
            addCriterion("userstatus not in", values, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusBetween(String value1, String value2) {
            addCriterion("userstatus between", value1, value2, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotBetween(String value1, String value2) {
            addCriterion("userstatus not between", value1, value2, "userstatus");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltIsNull() {
            addCriterion("credentialssalt is null");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltIsNotNull() {
            addCriterion("credentialssalt is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltEqualTo(String value) {
            addCriterion("credentialssalt =", value, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltNotEqualTo(String value) {
            addCriterion("credentialssalt <>", value, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltGreaterThan(String value) {
            addCriterion("credentialssalt >", value, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltGreaterThanOrEqualTo(String value) {
            addCriterion("credentialssalt >=", value, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltLessThan(String value) {
            addCriterion("credentialssalt <", value, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltLessThanOrEqualTo(String value) {
            addCriterion("credentialssalt <=", value, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltLike(String value) {
            addCriterion("credentialssalt like", value, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltNotLike(String value) {
            addCriterion("credentialssalt not like", value, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltIn(List<String> values) {
            addCriterion("credentialssalt in", values, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltNotIn(List<String> values) {
            addCriterion("credentialssalt not in", values, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltBetween(String value1, String value2) {
            addCriterion("credentialssalt between", value1, value2, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andCredentialssaltNotBetween(String value1, String value2) {
            addCriterion("credentialssalt not between", value1, value2, "credentialssalt");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andDepotIdIsNull() {
            addCriterion("depot_id is null");
            return (Criteria) this;
        }

        public Criteria andDepotIdIsNotNull() {
            addCriterion("depot_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepotIdEqualTo(Long value) {
            addCriterion("depot_id =", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotEqualTo(Long value) {
            addCriterion("depot_id <>", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdGreaterThan(Long value) {
            addCriterion("depot_id >", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("depot_id >=", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdLessThan(Long value) {
            addCriterion("depot_id <", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdLessThanOrEqualTo(Long value) {
            addCriterion("depot_id <=", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdIn(List<Long> values) {
            addCriterion("depot_id in", values, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotIn(List<Long> values) {
            addCriterion("depot_id not in", values, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdBetween(Long value1, Long value2) {
            addCriterion("depot_id between", value1, value2, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotBetween(Long value1, Long value2) {
            addCriterion("depot_id not between", value1, value2, "depotId");
            return (Criteria) this;
        }

        public Criteria andCreateTmIsNull() {
            addCriterion("create_tm is null");
            return (Criteria) this;
        }

        public Criteria andCreateTmIsNotNull() {
            addCriterion("create_tm is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTmEqualTo(Date value) {
            addCriterion("create_tm =", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmNotEqualTo(Date value) {
            addCriterion("create_tm <>", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmGreaterThan(Date value) {
            addCriterion("create_tm >", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmGreaterThanOrEqualTo(Date value) {
            addCriterion("create_tm >=", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmLessThan(Date value) {
            addCriterion("create_tm <", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmLessThanOrEqualTo(Date value) {
            addCriterion("create_tm <=", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmIn(List<Date> values) {
            addCriterion("create_tm in", values, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmNotIn(List<Date> values) {
            addCriterion("create_tm not in", values, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmBetween(Date value1, Date value2) {
            addCriterion("create_tm between", value1, value2, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmNotBetween(Date value1, Date value2) {
            addCriterion("create_tm not between", value1, value2, "createTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmIsNull() {
            addCriterion("update_tm is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTmIsNotNull() {
            addCriterion("update_tm is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTmEqualTo(Date value) {
            addCriterion("update_tm =", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmNotEqualTo(Date value) {
            addCriterion("update_tm <>", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmGreaterThan(Date value) {
            addCriterion("update_tm >", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmGreaterThanOrEqualTo(Date value) {
            addCriterion("update_tm >=", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmLessThan(Date value) {
            addCriterion("update_tm <", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmLessThanOrEqualTo(Date value) {
            addCriterion("update_tm <=", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmIn(List<Date> values) {
            addCriterion("update_tm in", values, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmNotIn(List<Date> values) {
            addCriterion("update_tm not in", values, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmBetween(Date value1, Date value2) {
            addCriterion("update_tm between", value1, value2, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmNotBetween(Date value1, Date value2) {
            addCriterion("update_tm not between", value1, value2, "updateTm");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateIsNull() {
            addCriterion("last_password_reset_date is null");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateIsNotNull() {
            addCriterion("last_password_reset_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateEqualTo(Date value) {
            addCriterion("last_password_reset_date =", value, "lastPasswordResetDate");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateNotEqualTo(Date value) {
            addCriterion("last_password_reset_date <>", value, "lastPasswordResetDate");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateGreaterThan(Date value) {
            addCriterion("last_password_reset_date >", value, "lastPasswordResetDate");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_password_reset_date >=", value, "lastPasswordResetDate");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateLessThan(Date value) {
            addCriterion("last_password_reset_date <", value, "lastPasswordResetDate");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateLessThanOrEqualTo(Date value) {
            addCriterion("last_password_reset_date <=", value, "lastPasswordResetDate");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateIn(List<Date> values) {
            addCriterion("last_password_reset_date in", values, "lastPasswordResetDate");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateNotIn(List<Date> values) {
            addCriterion("last_password_reset_date not in", values, "lastPasswordResetDate");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateBetween(Date value1, Date value2) {
            addCriterion("last_password_reset_date between", value1, value2, "lastPasswordResetDate");
            return (Criteria) this;
        }

        public Criteria andLastPasswordResetDateNotBetween(Date value1, Date value2) {
            addCriterion("last_password_reset_date not between", value1, value2, "lastPasswordResetDate");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNull() {
            addCriterion("headimage is null");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNotNull() {
            addCriterion("headimage is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimageEqualTo(String value) {
            addCriterion("headimage =", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotEqualTo(String value) {
            addCriterion("headimage <>", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThan(String value) {
            addCriterion("headimage >", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThanOrEqualTo(String value) {
            addCriterion("headimage >=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThan(String value) {
            addCriterion("headimage <", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThanOrEqualTo(String value) {
            addCriterion("headimage <=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLike(String value) {
            addCriterion("headimage like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotLike(String value) {
            addCriterion("headimage not like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageIn(List<String> values) {
            addCriterion("headimage in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotIn(List<String> values) {
            addCriterion("headimage not in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageBetween(String value1, String value2) {
            addCriterion("headimage between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotBetween(String value1, String value2) {
            addCriterion("headimage not between", value1, value2, "headimage");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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