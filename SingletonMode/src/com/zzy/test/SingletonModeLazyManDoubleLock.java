package com.zzy.test;
/**
 * 
 * 懒汉模式中的双重锁
 */

public class SingletonModeLazyManDoubleLock {
	private static volatile SingletonModeLazyManDoubleLock singletonModeLazyManDoubleLock;
	private SingletonModeLazyManDoubleLock(){}
	
	public static SingletonModeLazyManDoubleLock getInstance(){
		if( singletonModeLazyManDoubleLock == null ){
			//这个地方可能偶遇多个线程，在这里排队ABCD....
			synchronized (SingletonModeLazyManDoubleLock.class) {
				if( singletonModeLazyManDoubleLock == null ){
					//假设第一次A线程走到这里呈现挂起转态。这个时候单例还没有创建
					//此时B线程也来判断单例对象 ==null成立，但是，因为A线程已经给里层的if上了锁所以B只有等A执行完
					//A被唤醒后 单例就执行下面语句进行赋值，单例对象就创建然后释放锁给B就可以进入
					//B进来后先判断单例对象是否为null发现不是null那么就不需要创建了
					singletonModeLazyManDoubleLock = new SingletonModeLazyManDoubleLock();
				}
			}
		}
		return singletonModeLazyManDoubleLock;
	}
	
	
		
}
