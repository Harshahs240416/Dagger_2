package com.test.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import modules.MyRetrofitClientModule;
import myrecyclerview.RecyclerData;
import myretrofit.Result;
import myretrofit.RetrofitApiInterface;
import myretrofit.RetrofitDataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String RETROFIT_BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/";
    private static final String API_KEY = "AIzaSyDFOFRf74desJwI_fhb6sacdMk-bUcwnm8";
    private static final String LOCATION = "-33.8670,151.1957";
    private static final int RADIUS = 500;
    private static final String TYPES = "food";
    private static final String NAME = "cruise";

    @Inject
    MySharedPreference mySharedPreference;

    @Inject
    MyRetrofitClientModule mMyRetrofitClientModule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getMyAppComponent().inject(MainActivity.this);
        Toast.makeText(this, mySharedPreference.getSharedPrefString(), Toast.LENGTH_LONG).show();

        if (API_KEY.isEmpty()) {
            Toast.makeText(MainActivity.this, R.string.get_api_key, Toast.LENGTH_LONG).show();
        }

        RetrofitApiInterface mRetrofitApiInterface = mMyRetrofitClientModule.getClient(RETROFIT_BASE_URL).create(RetrofitApiInterface.class);

        Call<RetrofitDataModel> call = mRetrofitApiInterface.getNearbyPlaces(LOCATION, RADIUS, TYPES, NAME, API_KEY);
        call.enqueue(new Callback<RetrofitDataModel>() {
            @Override
            public void onResponse(Call<RetrofitDataModel> call, Response<RetrofitDataModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "response is not successful", Toast.LENGTH_SHORT).show();
                }

                List<Result> results = response.body().getResults();
                int resultSize = response.body().getResults().size();
                Toast.makeText(MainActivity.this, "response is successful start working "+resultSize , Toast.LENGTH_SHORT).show();

                HashMap<String, RecyclerData> recyclerData = new HashMap<String, RecyclerData>();

                for (int i = 0; i < resultSize; i++) {

                    String id = results.get(i).getId();
                    String name = results.get(i).getName();
                    String icon = results.get(i).getIcon();
                    recyclerData.put(id, new RecyclerData(id, name, icon));
                }

            }

            @Override
            public void onFailure(Call<RetrofitDataModel> call, Throwable t) {
                Log.d("Retro_Fail", "Did not get the response :-(");
            }
        });

    }

}
