package com.aclass.shishir.singletondesignpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aclass.shishir.singletondesignpattern.LazyInitialization.LazyInitializedSingleton;
import com.aclass.shishir.singletondesignpattern.ThreadSafeSingleton.ThreadSafeSingleton;

public class MainActivity extends AppCompatActivity {

    TextView lazyInitialization, threadSafeInitialization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lazyInitialization = (TextView)findViewById(R.id.lazyInitialization);
        threadSafeInitialization = (TextView)findViewById(R.id.threadSafeInitialization);
        lazyInitialization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LazyInitializedSingleton.getInsatnce().checkThisWorking();
            }
        });

        threadSafeInitialization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThreadSafeSingleton.getInstance().checkThisWorking(1);
            }
        });

        Thread thread = new Thread(){

            public void run(){
                ThreadSafeSingleton.getInstance().checkThisWorking(50);
            }

        };

        thread.start();

    }
}
