/**
 * Project Name:disconf-demo
 * File Name:DisconfConfig.java
 * Package Name:com.auggie.config
 * Date:2017年8月30日下午2:59:47
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package com.auggie.config;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baidu.disconf.client.DisconfMgrBean;
import com.baidu.disconf.client.DisconfMgrBeanSecond;
import com.baidu.disconf.client.addons.properties.ReloadablePropertiesFactoryBean;
import com.baidu.disconf.client.addons.properties.ReloadingPropertyPlaceholderConfigurer;

/**
 * ClassName:DisconfConfig <br/>
 * Date:     2017年8月30日 下午2:59:47 <br/>
 * @author   auggie
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Configuration
public class DisconfConfig {
	
	
	@Bean(destroyMethod = "destroy")
	public DisconfMgrBean disconfMgrBean() {
		DisconfMgrBean bean = new DisconfMgrBean();
		bean.setScanPackage("com.auggie");
		return bean;
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public DisconfMgrBeanSecond disconfMgrBeanSecond() {
		DisconfMgrBeanSecond bean = new DisconfMgrBeanSecond();
		return bean;
	}
	/**
	 * 使用托管方式的disconf配置(无代码侵入, 配置更改会自动reload)
	 * Function: reloadablePropertiesFactoryBean. <br/>
	 * Describe:(描述).
	 *
	 * @author auggie
	 * @return
	 * @since JDK 1.8
	 */
	@Bean
	public ReloadablePropertiesFactoryBean reloadablePropertiesFactoryBean() {
		ReloadablePropertiesFactoryBean bean = new ReloadablePropertiesFactoryBean();
		bean.setLocations(Arrays.asList("classpath*:application.properties"));
		return bean;
	}
	
	@Bean
	public ReloadingPropertyPlaceholderConfigurer reloadingPropertyPlaceholderConfigurer(ReloadablePropertiesFactoryBean bean) throws IOException {
		ReloadingPropertyPlaceholderConfigurer configurer = new ReloadingPropertyPlaceholderConfigurer();
		configurer.setIgnoreResourceNotFound(true);
		configurer.setIgnoreUnresolvablePlaceholders(true);
		bean.getObject();
		configurer.setProperties(bean.getObject());
		return configurer;
	}
	
	/**
	 * 自定义PropertyYamlFactoryBean
	 * 需结合各自callback进行reload
	 * Function: propertyYamlFactoryBean. <br/>
	 * Describe:(描述).
	 *
	 * @author auggie
	 * @return
	 * @since JDK 1.8
	 */
	@Bean
	public PropertyYamlFactoryBean propertyYamlFactoryBean() {
		PropertyYamlFactoryBean factoryBean = new PropertyYamlFactoryBean();
		factoryBean.injectLoactions(Arrays.asList("classpath*:application.yml", "classpath*:testyml.yml"));
		return factoryBean;
	}
	
	

}

