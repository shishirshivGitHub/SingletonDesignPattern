package com.aclass.shishir.singletondesignpattern.LazyInitialization;

import android.util.Log;

/**
 * Created by pc on 5/30/2017.
 */

// Lazy initialization method to implement Singleton pattern creates
// the instance in the global access method. Implementation works fine
// incase of single threaded environment.

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton insatnce;

    private LazyInitializedSingleton(){}

    public static LazyInitializedSingleton getInsatnce(){

        if(insatnce == null){ // check if the instance is not exist.
            insatnce = new LazyInitializedSingleton();
            Log.e("Object Creation only Once"," 00 ");
        }
        Log.e("Everytime Calling but new object not create"," 11 ");

        return insatnce;
    }

    public void checkThisWorking(){
        Log.e("check this is working here --> ", " yes this is working fine ");
    }
}
