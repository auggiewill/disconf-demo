/**
 * Project Name:disconf-demo
 * File Name:ReloadCallback.java
 * Package Name:com.auggie.config
 * Date:2017年8月31日上午10:42:50
 * Copyright (c) 2017, All Rights Reserved.
 * Company:东方金融-上海房产
 *
*/

package com.auggie.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;

/**
 * Describe:(描述).
 * ClassName:ReloadCallback <br/>
 * Date:     2017年8月31日 上午10:42:50 <br/>
 * @author   auggie
 * @version  
 * @since    JDK 1.8	 
 */
@Service
@Scope("singleton")
@DisconfUpdateService(confFileKeys = "application.properties")
public class ReloadCallback implements IDisconfUpdate {
	
	@Override
	public void reload() throws Exception {
		System.out.println("emem,reload");
	}

}

