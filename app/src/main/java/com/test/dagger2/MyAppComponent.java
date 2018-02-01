package com.test.dagger2;

import dagger.Component;

/**
 * Created by HARSHA H S on 01-02-2018.
 */
@Component(modules = MySharedPreferenceModule.class)
public interface MyAppComponent {

    void inject(MainActivity mainActivity);

}
