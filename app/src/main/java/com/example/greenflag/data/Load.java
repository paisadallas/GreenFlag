package com.example.greenflag.data;

import android.content.SharedPreferences;
import android.util.Log;

public class Load {

    public void email(SharedPreferences sharedPreferences,String email) {

        if (sharedPreferences.getString(email,"")!=""){
            Log.d("EMAIL","CREATED");
            Log.d("EMAIL_PASSWORD",sharedPreferences.getString(email,""));
        }else {
            Log.w("EMAIL","NOT CREATED");
        }

    }
}
