package modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HARSHA H S on 03-02-2018.
 */
@Singleton
@Module
public class MyRetrofitClientModule {

    private static Retrofit retrofit = null;

    @Provides
    MyRetrofitClientModule provideMyRetrofitClientModuleObject() {
        return new MyRetrofitClientModule();
    }

    public static Retrofit getClient(String baseUrl) {
      //  if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
       // }
        return retrofit;
    }

}
