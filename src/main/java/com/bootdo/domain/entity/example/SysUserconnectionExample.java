package com.bootdo.domain.entity.example;

import java.util.ArrayList;
import java.util.List;

public class SysUserconnectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserconnectionExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andProvideridIsNull() {
            addCriterion("providerId is null");
            return (Criteria) this;
        }

        public Criteria andProvideridIsNotNull() {
            addCriterion("providerId is not null");
            return (Criteria) this;
        }

        public Criteria andProvideridEqualTo(String value) {
            addCriterion("providerId =", value, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridNotEqualTo(String value) {
            addCriterion("providerId <>", value, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridGreaterThan(String value) {
            addCriterion("providerId >", value, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridGreaterThanOrEqualTo(String value) {
            addCriterion("providerId >=", value, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridLessThan(String value) {
            addCriterion("providerId <", value, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridLessThanOrEqualTo(String value) {
            addCriterion("providerId <=", value, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridLike(String value) {
            addCriterion("providerId like", value, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridNotLike(String value) {
            addCriterion("providerId not like", value, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridIn(List<String> values) {
            addCriterion("providerId in", values, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridNotIn(List<String> values) {
            addCriterion("providerId not in", values, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridBetween(String value1, String value2) {
            addCriterion("providerId between", value1, value2, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideridNotBetween(String value1, String value2) {
            addCriterion("providerId not between", value1, value2, "providerid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridIsNull() {
            addCriterion("providerUserId is null");
            return (Criteria) this;
        }

        public Criteria andProvideruseridIsNotNull() {
            addCriterion("providerUserId is not null");
            return (Criteria) this;
        }

        public Criteria andProvideruseridEqualTo(String value) {
            addCriterion("providerUserId =", value, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridNotEqualTo(String value) {
            addCriterion("providerUserId <>", value, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridGreaterThan(String value) {
            addCriterion("providerUserId >", value, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridGreaterThanOrEqualTo(String value) {
            addCriterion("providerUserId >=", value, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridLessThan(String value) {
            addCriterion("providerUserId <", value, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridLessThanOrEqualTo(String value) {
            addCriterion("providerUserId <=", value, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridLike(String value) {
            addCriterion("providerUserId like", value, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridNotLike(String value) {
            addCriterion("providerUserId not like", value, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridIn(List<String> values) {
            addCriterion("providerUserId in", values, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridNotIn(List<String> values) {
            addCriterion("providerUserId not in", values, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridBetween(String value1, String value2) {
            addCriterion("providerUserId between", value1, value2, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andProvideruseridNotBetween(String value1, String value2) {
            addCriterion("providerUserId not between", value1, value2, "provideruserid");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIsNull() {
            addCriterion("displayName is null");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIsNotNull() {
            addCriterion("displayName is not null");
            return (Criteria) this;
        }

        public Criteria andDisplaynameEqualTo(String value) {
            addCriterion("displayName =", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotEqualTo(String value) {
            addCriterion("displayName <>", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameGreaterThan(String value) {
            addCriterion("displayName >", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameGreaterThanOrEqualTo(String value) {
            addCriterion("displayName >=", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLessThan(String value) {
            addCriterion("displayName <", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLessThanOrEqualTo(String value) {
            addCriterion("displayName <=", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLike(String value) {
            addCriterion("displayName like", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotLike(String value) {
            addCriterion("displayName not like", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIn(List<String> values) {
            addCriterion("displayName in", values, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotIn(List<String> values) {
            addCriterion("displayName not in", values, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameBetween(String value1, String value2) {
            addCriterion("displayName between", value1, value2, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotBetween(String value1, String value2) {
            addCriterion("displayName not between", value1, value2, "displayname");
            return (Criteria) this;
        }

        public Criteria andProfileurlIsNull() {
            addCriterion("profileUrl is null");
            return (Criteria) this;
        }

        public Criteria andProfileurlIsNotNull() {
            addCriterion("profileUrl is not null");
            return (Criteria) this;
        }

        public Criteria andProfileurlEqualTo(String value) {
            addCriterion("profileUrl =", value, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlNotEqualTo(String value) {
            addCriterion("profileUrl <>", value, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlGreaterThan(String value) {
            addCriterion("profileUrl >", value, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlGreaterThanOrEqualTo(String value) {
            addCriterion("profileUrl >=", value, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlLessThan(String value) {
            addCriterion("profileUrl <", value, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlLessThanOrEqualTo(String value) {
            addCriterion("profileUrl <=", value, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlLike(String value) {
            addCriterion("profileUrl like", value, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlNotLike(String value) {
            addCriterion("profileUrl not like", value, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlIn(List<String> values) {
            addCriterion("profileUrl in", values, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlNotIn(List<String> values) {
            addCriterion("profileUrl not in", values, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlBetween(String value1, String value2) {
            addCriterion("profileUrl between", value1, value2, "profileurl");
            return (Criteria) this;
        }

        public Criteria andProfileurlNotBetween(String value1, String value2) {
            addCriterion("profileUrl not between", value1, value2, "profileurl");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNull() {
            addCriterion("imageUrl is null");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNotNull() {
            addCriterion("imageUrl is not null");
            return (Criteria) this;
        }

        public Criteria andImageurlEqualTo(String value) {
            addCriterion("imageUrl =", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotEqualTo(String value) {
            addCriterion("imageUrl <>", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThan(String value) {
            addCriterion("imageUrl >", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThanOrEqualTo(String value) {
            addCriterion("imageUrl >=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThan(String value) {
            addCriterion("imageUrl <", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThanOrEqualTo(String value) {
            addCriterion("imageUrl <=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLike(String value) {
            addCriterion("imageUrl like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotLike(String value) {
            addCriterion("imageUrl not like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlIn(List<String> values) {
            addCriterion("imageUrl in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotIn(List<String> values) {
            addCriterion("imageUrl not in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlBetween(String value1, String value2) {
            addCriterion("imageUrl between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotBetween(String value1, String value2) {
            addCriterion("imageUrl not between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andAccesstokenIsNull() {
            addCriterion("accessToken is null");
            return (Criteria) this;
        }

        public Criteria andAccesstokenIsNotNull() {
            addCriterion("accessToken is not null");
            return (Criteria) this;
        }

        public Criteria andAccesstokenEqualTo(String value) {
            addCriterion("accessToken =", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenNotEqualTo(String value) {
            addCriterion("accessToken <>", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenGreaterThan(String value) {
            addCriterion("accessToken >", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenGreaterThanOrEqualTo(String value) {
            addCriterion("accessToken >=", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenLessThan(String value) {
            addCriterion("accessToken <", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenLessThanOrEqualTo(String value) {
            addCriterion("accessToken <=", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenLike(String value) {
            addCriterion("accessToken like", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenNotLike(String value) {
            addCriterion("accessToken not like", value, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenIn(List<String> values) {
            addCriterion("accessToken in", values, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenNotIn(List<String> values) {
            addCriterion("accessToken not in", values, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenBetween(String value1, String value2) {
            addCriterion("accessToken between", value1, value2, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andAccesstokenNotBetween(String value1, String value2) {
            addCriterion("accessToken not between", value1, value2, "accesstoken");
            return (Criteria) this;
        }

        public Criteria andSecretIsNull() {
            addCriterion("secret is null");
            return (Criteria) this;
        }

        public Criteria andSecretIsNotNull() {
            addCriterion("secret is not null");
            return (Criteria) this;
        }

        public Criteria andSecretEqualTo(String value) {
            addCriterion("secret =", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotEqualTo(String value) {
            addCriterion("secret <>", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThan(String value) {
            addCriterion("secret >", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThanOrEqualTo(String value) {
            addCriterion("secret >=", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLessThan(String value) {
            addCriterion("secret <", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLessThanOrEqualTo(String value) {
            addCriterion("secret <=", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLike(String value) {
            addCriterion("secret like", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotLike(String value) {
            addCriterion("secret not like", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretIn(List<String> values) {
            addCriterion("secret in", values, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotIn(List<String> values) {
            addCriterion("secret not in", values, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretBetween(String value1, String value2) {
            addCriterion("secret between", value1, value2, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotBetween(String value1, String value2) {
            addCriterion("secret not between", value1, value2, "secret");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenIsNull() {
            addCriterion("refreshToken is null");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenIsNotNull() {
            addCriterion("refreshToken is not null");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenEqualTo(String value) {
            addCriterion("refreshToken =", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenNotEqualTo(String value) {
            addCriterion("refreshToken <>", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenGreaterThan(String value) {
            addCriterion("refreshToken >", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenGreaterThanOrEqualTo(String value) {
            addCriterion("refreshToken >=", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenLessThan(String value) {
            addCriterion("refreshToken <", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenLessThanOrEqualTo(String value) {
            addCriterion("refreshToken <=", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenLike(String value) {
            addCriterion("refreshToken like", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenNotLike(String value) {
            addCriterion("refreshToken not like", value, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenIn(List<String> values) {
            addCriterion("refreshToken in", values, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenNotIn(List<String> values) {
            addCriterion("refreshToken not in", values, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenBetween(String value1, String value2) {
            addCriterion("refreshToken between", value1, value2, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andRefreshtokenNotBetween(String value1, String value2) {
            addCriterion("refreshToken not between", value1, value2, "refreshtoken");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIsNull() {
            addCriterion("expireTime is null");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIsNotNull() {
            addCriterion("expireTime is not null");
            return (Criteria) this;
        }

        public Criteria andExpiretimeEqualTo(Long value) {
            addCriterion("expireTime =", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotEqualTo(Long value) {
            addCriterion("expireTime <>", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeGreaterThan(Long value) {
            addCriterion("expireTime >", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeGreaterThanOrEqualTo(Long value) {
            addCriterion("expireTime >=", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLessThan(Long value) {
            addCriterion("expireTime <", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLessThanOrEqualTo(Long value) {
            addCriterion("expireTime <=", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIn(List<Long> values) {
            addCriterion("expireTime in", values, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotIn(List<Long> values) {
            addCriterion("expireTime not in", values, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeBetween(Long value1, Long value2) {
            addCriterion("expireTime between", value1, value2, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotBetween(Long value1, Long value2) {
            addCriterion("expireTime not between", value1, value2, "expiretime");
            return (Criteria) this;
        }

        public Criteria andUnionidIsNull() {
            addCriterion("unionid is null");
            return (Criteria) this;
        }

        public Criteria andUnionidIsNotNull() {
            addCriterion("unionid is not null");
            return (Criteria) this;
        }

        public Criteria andUnionidEqualTo(String value) {
            addCriterion("unionid =", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotEqualTo(String value) {
            addCriterion("unionid <>", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidGreaterThan(String value) {
            addCriterion("unionid >", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidGreaterThanOrEqualTo(String value) {
            addCriterion("unionid >=", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLessThan(String value) {
            addCriterion("unionid <", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLessThanOrEqualTo(String value) {
            addCriterion("unionid <=", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLike(String value) {
            addCriterion("unionid like", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotLike(String value) {
            addCriterion("unionid not like", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidIn(List<String> values) {
            addCriterion("unionid in", values, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotIn(List<String> values) {
            addCriterion("unionid not in", values, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidBetween(String value1, String value2) {
            addCriterion("unionid between", value1, value2, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotBetween(String value1, String value2) {
            addCriterion("unionid not between", value1, value2, "unionid");
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