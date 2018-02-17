/**
 * 
 */
package com.bootdo.common.social.weixin.config;

import com.bootdo.common.social.ImoocConnectView;
import com.bootdo.common.social.core.properties.WeixinProperties;
import com.bootdo.common.social.weixin.api.Weixin;
import com.bootdo.common.social.weixin.connet.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

/** 微信登录配置
 * 
 * @author zhailiang */
@Configuration
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {

	@Value("${weixin.appId:}")
	private String appId;
	@Value("${weixin.client_SERCRET:}")
	private String client_SERCRET;
	
	@Override
	protected ConnectionFactory<Weixin> createConnectionFactory() {
		WeixinProperties weixinConfig = new WeixinProperties();
		weixinConfig.setAppId(appId);
		weixinConfig.setAppSecret(client_SERCRET);
		return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(), weixinConfig.getAppSecret());
	}
	
	@Bean(name = { "connect/weixinConnect", "connect/weixinConnected" })
	public View weixinConnectedView() {
		return new ImoocConnectView();
	}
}
