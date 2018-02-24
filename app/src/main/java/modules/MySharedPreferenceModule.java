package modules;

import com.test.dagger2.MySharedPreference;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HARSHA H S on 01-02-2018.
 */
@Module
public class MySharedPreferenceModule {

    @Provides
    public MySharedPreference provideMySharedPreference(){
        return new MySharedPreference();
    }

}
