package com.example.greenflag.validator;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.greenflag.R;
import com.example.greenflag.data.Load;
import com.example.greenflag.data.Read;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    MathPassword mathPassword = new MathPassword();
    Load load = new Load();

    String password="";
    public boolean check=false;
    public boolean exist = false;

    //end
    String regex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,6})+$";

    public boolean testEmail(String email){

        String regexEmail = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,6})+$";
       return Pattern.compile(regexEmail).matcher(email).matches();
    }

        public void checkEmail(EditText editText, ImageView imgCheckEmail, TextView warning, Read read) {

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {

                    String email = editable.toString();

                    if(Pattern.compile(regex).matcher(email).matches()){
                        imgCheckEmail.setImageResource(R.drawable.img_ok);
                        check=true;
                        read.enableEmail(true);
                    }
                    else {
                        imgCheckEmail.setImageResource(R.drawable.img_error);
                        warning.setText("Invalid email");
                        warning.setTextColor(Color.parseColor("#FF0000"));
                        read.enableEmail(false);
                        check=false;
                    }
                }
            });
        }

    public void checkMatch(EditText etPassword, EditText etMathPassword,TextView tvWarningMath,ImageView imgCheckMath, Read read) {

        mathPassword.mathPassword(etMathPassword,etPassword,tvWarningMath,imgCheckMath,read);
    }

    public void checkEmailExist(EditText etEmail, SharedPreferences sharedPreferences, TextView tvWarningEmail,Read read) {

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String email = editable.toString();

                if(Pattern.compile(regex).matcher(email).matches() && check){
                    //CHECKING EXITING PASSWORD
                    if(load.email(sharedPreferences,etEmail.getText().toString())){
                        tvWarningEmail.setText("Email exist");
                        tvWarningEmail.setTextColor(Color.parseColor("#086E00"));
                        exist = true;
                        read.enableWrite(false);
                    }else {
                        tvWarningEmail.setText("New User");
                        tvWarningEmail.setTextColor(Color.parseColor("#086E00"));
                        read.enableWrite(true);
                    }
                }
            }
        });
    }

    //DETECT IF THE PASSWORD EXIST
    public boolean match(String matchPassword) {
        Log.d("READ_PASSWORD","Reading data"+matchPassword);
        Log.d("READ_PASSWORD","The passord is"+load.password);
        if (load.password.equals(matchPassword)){
          password=matchPassword;
            return true;
           // Log.d("READ_PASSWORD","MATH!!");
        }
        else {
            password = matchPassword;
            return false;
        }
    }

    public void cleanPasswords(EditText etEmail, EditText etPassword, EditText etMathPassword) {
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etPassword.setText("");
                etMathPassword.setText("");
            }
        });
    }


    public void cleanData(EditText etEmail, EditText etPassword, EditText etMathPassword) {
        etEmail.setText("");
        etPassword.setText("");
        etMathPassword.setText("");
    }

    public void update (){

    }
}
