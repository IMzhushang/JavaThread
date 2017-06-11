package com.zs.immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ‘
 * 
 * @author Administrator
 *
 *         更具号码路由到彩信中心
 *
 */
public class MMSCRouter {
	/**
	 * 保障多线程下的可见性
	 */
	private static volatile MMSCRouter instance = new MMSCRouter();

	private final Map<String, MMSCInfo> routerMap;

	public MMSCRouter() {
		this.routerMap = getMapFromDb();
	}

	private Map<String, MMSCInfo> getMapFromDb() {
		// TODO Auto-generated method stub
		return null;
	}

	public static MMSCRouter getInstance() {
		return instance;
	}

	public static void setInstance(MMSCRouter instance) {
		instance = instance;
	}

	public MMSCInfo getMMSC(String phone) {
		return this.routerMap.get(phone);
	}

	public static Map<String, MMSCInfo> deepCopy(Map<String, MMSCInfo> map) {
		Map<String, MMSCInfo> result = new HashMap<>();
		for (Map.Entry<String, MMSCInfo> entry : map.entrySet()) {
			result.put(entry.getKey(), new MMSCInfo(entry.getValue()));
		}
		return result;
	}

	public Map<String, MMSCInfo> getRouterMap() {
		return Collections.unmodifiableMap(deepCopy(routerMap));
	}
}
