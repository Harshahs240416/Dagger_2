package myretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HARSHA H S on 03-02-2018.
 */

public interface RetrofitApiInterface {

    @GET("json")
    Call<RetrofitDataModel> getNearbyPlaces(@Query("location") String location, @Query("radius") int radius, @Query("types") String food, @Query("name") String name, @Query("key") String apiKey);

}
