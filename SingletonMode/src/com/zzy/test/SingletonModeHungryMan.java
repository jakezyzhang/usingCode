/**
 * 
 * @author		
 */
package com.zzy.test;

/**
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * @author	
 * @date	
 * @version 
 */
public class SingletonModeHungryMan {
	//饿汉模式
	private SingletonModeHungryMan(){}
	private static SingletonModeHungryMan singletonModeHungryMan = new SingletonModeHungryMan();
	public static SingletonModeHungryMan getInstance(){
		return singletonModeHungryMan;
	}
	
	
	
	
	
	
}
