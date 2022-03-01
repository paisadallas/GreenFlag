package com.example.greenflag.data;

import android.content.SharedPreferences;
import android.util.Log;

public class Load {

    public String password="";

    public boolean email(SharedPreferences sharedPreferences,String email) {

        if (sharedPreferences.getString(email,"")!=""){
            Log.d("EMAIL","CREATED");
            Log.d("EMAIL_PASSWORD",sharedPreferences.getString(email,""));
            password = sharedPreferences.getString(email,"");
            return true;
        }else {
            Log.w("EMAIL","NOT CREATED");
            password = "";
        }
        return false;
    }


}
