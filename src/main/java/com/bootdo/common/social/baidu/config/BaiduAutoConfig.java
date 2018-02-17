package com.bootdo.common.social.baidu.config;
import com.bootdo.common.social.baidu.api.Baidu;
import com.bootdo.common.social.baidu.connet.BaiduConnectionFactory;
import com.bootdo.common.social.core.properties.BaiduProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/** @author zhailiang */
@Configuration
public class BaiduAutoConfig extends SocialAutoConfigurerAdapter {
	@Value("${baidu.client_ID:}")
	private String client_ID;
	@Value("${baidu.client_SERCRET:}")
	private String client_SERCRET;

	protected ConnectionFactory<Baidu> createConnectionFactory() {
		BaiduProperties baiduConfig = new BaiduProperties();
		baiduConfig.setAppId(client_ID);
		baiduConfig.setAppSecret(client_SERCRET);
		return new BaiduConnectionFactory(baiduConfig.getProviderId(), baiduConfig.getAppId(), baiduConfig.getAppSecret());
	}
}
