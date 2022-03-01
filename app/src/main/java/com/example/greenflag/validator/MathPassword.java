package com.example.greenflag.validator;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.greenflag.R;

public class MathPassword {

    public void mathPassword(EditText etPassword, EditText etMatch, ImageView imageView){


        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable1) {

                etMatch.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable2) {
                        if (editable2.toString().equals(editable1.toString())){
                            Log.d("PASSWORD","EQUAL");
                            imageView.setImageResource(R.drawable.img_ok);
                        }
                        else {
                            imageView.setImageResource(R.drawable.img_error);
                            Log.d("PASSWORD","DIFERENT");
                        }
                    }
                });

            }
        });


    }

}
