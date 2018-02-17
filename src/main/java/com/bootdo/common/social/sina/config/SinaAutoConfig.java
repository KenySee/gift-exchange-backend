package com.bootdo.common.social.sina.config;

import com.bootdo.common.social.core.properties.SinaProperties;
import com.bootdo.common.social.sina.api.Sina;
import com.bootdo.common.social.sina.connet.SinaConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/** @author https://gitee.com/YYDeament/88ybg
 * @date 2017/10/1 **/
@Configuration
public class SinaAutoConfig extends SocialAutoConfigurerAdapter {

	@Value("${sina.client_ID:}")
	private String client_ID;
	@Value("${sina.client_SERCRET:}")
	private String client_SERCRET;

	@Override
	protected ConnectionFactory<Sina> createConnectionFactory() {
		SinaProperties sinaConfig = new SinaProperties();
		sinaConfig.setAppId(client_ID);
		sinaConfig.setAppSecret(client_SERCRET);
		return new SinaConnectionFactory(sinaConfig.getProviderId(), sinaConfig.getAppId(), sinaConfig.getAppSecret());
	}
}
