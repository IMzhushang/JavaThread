package com.zs.tss;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 使用 TSS 模式的随机数生成器
 * 
 * @author Administrator
 *
 */
public class ThreadSpecificSecureRandom {

	public static final ThreadSpecificSecureRandom INSTANCE = new ThreadSpecificSecureRandom();

	public static final ThreadLocal<SecureRandom> THREAD_LOCAL = new ThreadLocal<SecureRandom>() {
		@SuppressWarnings("static-access")
		protected SecureRandom initialValue() {
			SecureRandom src = null;
			try {
				src = new SecureRandom().getInstance("SHA1PRNG");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				src = new SecureRandom();
			}
			return src;
		};
	};

	private ThreadSpecificSecureRandom() {
	}

	public static ThreadSpecificSecureRandom getInstance() {
		return INSTANCE;
	}
	
	public int  nextInt(int upperBound) {
		   SecureRandom src  =  THREAD_LOCAL.get();
		   return src.nextInt(upperBound);
	}
	
	public void setSeed(int seed) {
		SecureRandom src = THREAD_LOCAL.get();
		src.setSeed(seed);
	}

}
