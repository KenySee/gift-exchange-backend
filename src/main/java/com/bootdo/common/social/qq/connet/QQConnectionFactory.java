package com.bootdo.common.social.qq.connet;

import com.bootdo.common.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/** @author https://gitee.com/YYDeament/88ybg
 * @date 2017/10/1 **/
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {
	
	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
	}
}
