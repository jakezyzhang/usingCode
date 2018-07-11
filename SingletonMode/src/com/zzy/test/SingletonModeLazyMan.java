package com.zzy.test;

/**
 *单例模式中的懒汉模式 
 */
public class SingletonModeLazyMan {
	private static SingletonModeLazyMan singletonModeLazyMan = null;
	private SingletonModeLazyMan(){}
	
	public static synchronized SingletonModeLazyMan getInstance(){
		if(singletonModeLazyMan == null ){
			singletonModeLazyMan = new SingletonModeLazyMan();
			
		}
		return singletonModeLazyMan;
	}
	
}
