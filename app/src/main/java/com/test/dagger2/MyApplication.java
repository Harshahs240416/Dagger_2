package com.test.dagger2;

import android.app.Application;

/**
 * Created by HARSHA H S on 01-02-2018.
 */

public class MyApplication extends Application{

    private MyAppComponent myAppComponent = null;

    @Override
    public void onCreate() {
        super.onCreate();
        myAppComponent = DaggerMyAppComponent.builder().mySharedPreferenceModule(new MySharedPreferenceModule()).build();
    }

    public MyAppComponent getMyAppComponent(){
        return myAppComponent;
    }
}
