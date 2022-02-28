package com.example.greenflag.validator;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.greenflag.R;

import java.util.regex.Pattern;

public class Password {

    public boolean testCheckPassword(String password){


        String normalCasePassword = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        String specialCharacterPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        boolean normalCase=Pattern.compile(normalCasePassword).matcher(password).matches();
        boolean specialCharacter = Pattern.compile(specialCharacterPassword).matcher(password).matches();

        return (normalCase || specialCharacter);
    }

    public void checkPassword(EditText etPassword, ImageView imgCheckPassword) {

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String password = editable.toString();

                String normalCasePassword = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
                String specialCharacterPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

                boolean normalCase=Pattern.compile(normalCasePassword).matcher(password).matches();
                boolean specialCharacter = Pattern.compile(specialCharacterPassword).matcher(password).matches();

                if(normalCase || specialCharacter){
                    imgCheckPassword.setImageResource(R.drawable.img_ok);
                }
                else {
                    imgCheckPassword.setImageResource(R.drawable.img_error);
                }
            }
        });
    }
}
