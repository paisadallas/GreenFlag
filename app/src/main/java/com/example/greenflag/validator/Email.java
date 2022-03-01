package com.example.greenflag.validator;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.greenflag.R;
import com.example.greenflag.data.Load;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    MathPassword mathPassword = new MathPassword();
    Load load = new Load();
    Password password = new Password();
    boolean check=false;
    public boolean exist = false;

    String regex = "([a-z]|[A-Z]|[0-9]|[_-])+@\\S([a-z]|[A-Z]|[0-9])+.([a-z]|[A-Z])+([^.!@#$%^&**()_+{}:\"?><])";

    public boolean testEmail(String email){

        String regexEmail = "([a-z]|[A-Z]|[0-9]|[_-])+@\\S([a-z]|[A-Z]|[0-9])+.([a-z]|[A-Z])+([^.!@#$%^&**()_+{}:\"?><])";
       return Pattern.compile(regexEmail).matcher(email).matches();
    }

        public void checkEmail(EditText editText, ImageView imgCheckEmail,TextView warning) {

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
                    }
                    else {
                        imgCheckEmail.setImageResource(R.drawable.img_error);
                        warning.setText("Invalid email");
                        warning.setTextColor(Color.parseColor("#FF0000"));
                        check=false;
                    }
                }
            });
        }

    public void checkMatch(EditText etPassword, EditText etMathPassword,TextView tvWarningMath,ImageView imgCheckMath) {

        mathPassword.mathPassword(etMathPassword,etPassword,tvWarningMath,imgCheckMath);
    }

    public void checkEmailExist(EditText etEmail, SharedPreferences sharedPreferences, TextView tvWarningEmail) {


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

                    }else {
                        tvWarningEmail.setText("New User");
                        tvWarningEmail.setTextColor(Color.parseColor("#086E00"));
                    }

                }

            }
        });

    }

    public boolean match(String toString) {
        Log.d("READ_PASSWORD","Reading data"+toString);
        Log.d("READ_PASSWORD","The passord is"+load.password);
        if (load.password.equals(toString)){
            return true;
           // Log.d("READ_PASSWORD","MATH!!");

        }
        else {
            return false;
        }
    }
}
