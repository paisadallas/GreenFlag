package com.example.greenflag.validator;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.greenflag.R;
import com.example.greenflag.data.Load;
import com.example.greenflag.data.Write;

import java.util.regex.Pattern;

public class Password {

    String normalCasePassword = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    String specialCharacterPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    boolean math=false;
    public String password = "";
    public boolean testCheckPassword(String password){

        String normalCasePassword = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        String specialCharacterPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        boolean normalCase=Pattern.compile(normalCasePassword).matcher(password).matches();
        boolean specialCharacter = Pattern.compile(specialCharacterPassword).matcher(password).matches();

        return (normalCase || specialCharacter);
    }

    public void checkPassword(EditText etPassword, TextView tvWarningPassword, ImageView imgCheckPassword,Email email) {


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

                boolean normalCase=Pattern.compile(normalCasePassword).matcher(password).matches();
                boolean specialCharacter = Pattern.compile(specialCharacterPassword).matcher(password).matches();

                if(normalCase || specialCharacter){

                    if (!email.exist){
                        imgCheckPassword.setImageResource(R.drawable.img_ok);
                        tvWarningPassword.setText("Correct");
                        tvWarningPassword.setTextColor(Color.parseColor("#086E00"));
                        setMath(true,editable.toString());

                    }else {

                    }

                }
                else {
                    imgCheckPassword.setImageResource(R.drawable.img_error);
                    tvWarningPassword.setText("Incorrect Password");
                    tvWarningPassword.setTextColor(Color.parseColor("#FF0000"));
                    setMath(false,"");

                }
            }
        });
    }

    public void checkPasswordSave(EditText etPassword, TextView tvWarningPassword,ImageView imgCheckPassword, Email email) {

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

                boolean normalCase=Pattern.compile(normalCasePassword).matcher(password).matches();
                boolean specialCharacter = Pattern.compile(specialCharacterPassword).matcher(password).matches();

                if(normalCase || specialCharacter){
                   //
                   if(email.match(editable.toString()) && email.exist) {
                       //Password does math
                       imgCheckPassword.setImageResource(R.drawable.img_ok);
                       tvWarningPassword.setText("Correct");
                       tvWarningPassword.setTextColor(Color.parseColor("#086E00"));

                   }
                    if(email.exist && !(email.match(editable.toString()))){
                        imgCheckPassword.setImageResource(R.drawable.img_error);
                        tvWarningPassword.setText("Incorrect Password");
                        tvWarningPassword.setTextColor(Color.parseColor("#FF0000"));
                    }
                }else {
//                    imgCheckPassword.setImageResource(R.drawable.img_error);
//                    tvWarningPassword.setText("Invalid format");
//                    tvWarningPassword.setTextColor(Color.parseColor("#FF0000"));
                }
            }
        });
    }

    public void setMath(boolean setMath, String setPassword){
        password = setPassword;
        math = setMath;
    }

}
