package com.test.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HARSHA H S on 01-02-2018.
 */
@Module
public class MySharedPreferenceModule {

    @Provides
    MySharedPreference provideMySharedPreference(){
        return new MySharedPreference();
    }

}
