/**
 * 
 */
package com.bootdo.common.social.baidu.connet;

import com.bootdo.common.social.baidu.api.Baidu;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/** 微信连接工厂
 * 
 * @author zhailiang */
public class BaiduConnectionFactory extends OAuth2ConnectionFactory<Baidu> {
	
	/** @param appId
	 * @param appSecret */
	public BaiduConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new BaiduServiceProvider(appId, appSecret), new BaiduAdapter());
	}
}
