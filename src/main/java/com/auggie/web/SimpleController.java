/**
 * Project Name:disconf-demo
 * File Name:SimpleController.java
 * Package Name:com.auggie.web
 * Date:2017年8月30日下午2:36:19
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package com.auggie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auggie.config.ReloadConfig;
import com.auggie.config.YmlConfig;

/**
 * ClassName:SimpleController <br/>
 * Date:     2017年8月30日 下午2:36:19 <br/>
 * @author   auggie
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@RestController
public class SimpleController {
	
	@Value("${demo.how.are.you}")
	private String mes;
	
	@Autowired
	private ReloadConfig config;
	
	@Autowired
	private YmlConfig ymlConfig;
	
	@RequestMapping("/simple")
	@ResponseBody
	public String simple() {
		System.out.println(config.getMes());
		
		ymlConfig.setYmlsay("123");
		System.out.println(ymlConfig.getYmlsay());
		return "SIMPLE";
	}

}

