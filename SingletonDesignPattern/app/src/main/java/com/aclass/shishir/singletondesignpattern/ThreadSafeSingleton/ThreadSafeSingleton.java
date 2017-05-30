package com.aclass.shishir.singletondesignpattern.ThreadSafeSingleton;

import android.util.Log;

/**
 * Created by pc on 5/30/2017.
 */

// The easier way to create a thread-safe singleton class is to make the global
// access method synchronized, so that only one thread can execute this method at a time.

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    // make the method synchronized, but it may reduce the performance cost
    // due to method is synchronized.
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
            Log.e("Object Creation only Once"," 00 ");
        }
        Log.e("Everytime Calling but new object not create"," 11 ");

        return instance;
    }

    // To avoid this extra overhead every time, double checked locking principle is used.
    // In this approach, the synchronized block is used inside the if condition
    // with an additional check to ensure that only one instance of singleton class is created.
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public void checkThisWorking(int h){

        for(int i=0;i<1000;i++)
        Log.e("check this is working here --> ", h*i + "");
    }

}
