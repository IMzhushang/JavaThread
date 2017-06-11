package com.zs.immutable;

/**
 * 和运维中心相互连接， 但彩信中心发生改变是，通知MMSRouter改变路由表
 * 
 * @author Administrator
 *
 */
public class OMCAgent extends Thread {

	boolean isChnage = false;

	@Override
	public void run() {
		while (true) {
			// 省略其他的代码
			while (isChnage) {

				MMSCRouter.setInstance(new MMSCRouter());

			}
		}

	}

}
