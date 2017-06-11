package com.zs.immutable;

/**
 * 彩信中心的信息 代表一个彩信中心
 * 
 * @author Administrator
 *
 */
public class MMSCInfo {
	private final String diviceId;
	private final String url;
	private final String size;

	public MMSCInfo(String diviceId, String url, String size) {
		super();
		this.diviceId = diviceId;
		this.url = url;
		this.size = size;
	}

	public MMSCInfo(MMSCInfo m) {
		this.diviceId = m.diviceId;
		this.size = m.size;
		this.url = m.url;
	}

	public String getDiviceId() {
		return diviceId;
	}

	public String getUrl() {
		return url;
	}

	public String getSize() {
		return size;
	}

}
