package org.yuhang.designpattern.singleton;



/** 懒汉模式优化
 *  volatile+double-check机制实现线程安全的懒汉单例模式
 * Created by chinalife on 2018/5/24.
 */

public class Singleton4 {

    // new 对象时cpu和内存级别发生的操作：
    // 1. 用native方法为对象申请内存空间 ,memory = allocate()
    // 2. 初始化对象
    // 3. 将对象指向分配的内存空间
    // 以上三部可能发生指令重排序,所以需将对象instance用volatile修饰，在进行写操作时会禁止指令重排序，
    // 可能会发生线程A先将对象指向分配的内存空间但还未初始化对象的时候，线程B在第一次判断instance==null时
    // 发现Instance不为空，直接返回了此时的instance实例，但此对象还未初始化!

    private volatile static Singleton4 instance = null;

    // double-check 机制
    public static Singleton4 getInstance(){
        if(instance == null){ //先判断一次instance有没有被实例化，减少不必要的初始化浪费
            synchronized (Singleton4.class){
                if(instance ==null){ // 再判断instance此时有没有被实例化
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
