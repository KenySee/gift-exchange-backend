/**
 * 
 */
package com.bootdo.common.social.qq.config;

import com.bootdo.common.social.core.properties.QQProperties;
import com.bootdo.common.social.qq.api.QQ;
import com.bootdo.common.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/** @author https://gitee.com/YYDeament/88ybg
 * @date 2017/10/1 **/
@Configuration
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

	@Value("${qq.client_ID:}")
	private String client_ID;
	@Value("${qq.client_SERCRET:}")
	private String client_SERCRET;
	@Override
	protected ConnectionFactory<QQ> createConnectionFactory() {
		QQProperties qqConfig = new QQProperties();
		qqConfig.setAppId(client_ID);
		qqConfig.setAppSecret(client_SERCRET);
		return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
	}
}
