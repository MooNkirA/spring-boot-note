package com.moon.springboot.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * 自定义监听器测试，实现 ApplicationListener 接口，泛型是 ApplicationEvent 的类型
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-12 10:53
 * @description
 */
// 此监听器，在应用启动开始事件时进行功能追加
public class CustomListener implements ApplicationListener<ApplicationStartingEvent> {

	/**
	 * Handle an application event.
	 *
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("自定义事件处理逻辑, source: " + event.getSource());
	}

}
