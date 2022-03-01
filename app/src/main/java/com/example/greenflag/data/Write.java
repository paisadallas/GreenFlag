package com.example.greenflag.data;

import android.content.SharedPreferences;

public class Write {

   public void writeUser(SharedPreferences sharedPreferences, String email, String password){

      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putString(email,password);
      editor.apply();
   }

}
