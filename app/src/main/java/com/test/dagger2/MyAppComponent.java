package com.test.dagger2;

import dagger.Component;
import modules.MyRetrofitClientModule;
import modules.MySharedPreferenceModule;

/**
 * Created by HARSHA H S on 01-02-2018.
 */
@Component(modules = {MySharedPreferenceModule.class, MyRetrofitClientModule.class})
public interface MyAppComponent {

    MyRetrofitClientModule provideMyRetrofitClientModuleObject();

    void inject(MainActivity mainActivity);

}
