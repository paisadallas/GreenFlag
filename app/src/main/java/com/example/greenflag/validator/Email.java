package com.example.greenflag.validator;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.greenflag.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {


    public boolean testEmail(String email){

        String regexEmail = "([a-z]|[A-Z]|[0-9]|[_-])+@\\S([a-z]|[A-Z]|[0-9])+.([a-z]|[A-Z])+([^.!@#$%^&**()_+{}:\"?><])";
       return Pattern.compile(regexEmail).matcher(email).matches();
    }


        public void checkSpaces(EditText editText, ImageView imgCheckEmail) {


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
                    String regex = "([a-z]|[A-Z]|[0-9]|[_-])+@\\S([a-z]|[A-Z]|[0-9])+.([a-z]|[A-Z])+([^.!@#$%^&**()_+{}:\"?><])";

                    if(Pattern.compile(regex).matcher(email).matches()){
                        imgCheckEmail.setImageResource(R.drawable.img_ok);
                    }
                    else {
                        imgCheckEmail.setImageResource(R.drawable.img_error);
                    }
                }
            });
        }
}
