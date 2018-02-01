package com.test.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject  MySharedPreference mySharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication)getApplication()).getMyAppComponent().inject(MainActivity.this);
        Toast.makeText(this, mySharedPreference.getSharedPrefString(), Toast.LENGTH_LONG).show();
    }
}
