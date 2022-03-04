package com.example.greenflag.validator;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.greenflag.R;
import com.example.greenflag.data.Read;

public class MathPassword {

    public void mathPassword(EditText etPassword, EditText etMatch, TextView tvWarningMath, ImageView imageView, Read read){

        //UPDATE_ROTATE
            if (etPassword.getText().toString().equals(etMatch.getText().toString())
                   ){
                Log.d("PASSWORD","EQUAL");
                imageView.setImageResource(R.drawable.img_ok);
                tvWarningMath.setText("Math");
                tvWarningMath.setTextColor(Color.parseColor("#086E00"));
                read.enableMath(true);
            }
            else {
                imageView.setImageResource(R.drawable.img_error);
                tvWarningMath.setText("No math");
                tvWarningMath.setTextColor(Color.parseColor("#FF0000"));
                Log.d("PASSWORD","DIFERENT");
                read.enableMath(false);
            }

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
                            tvWarningMath.setText("Math");
                            tvWarningMath.setTextColor(Color.parseColor("#086E00"));
                            read.enableMath(true);
                        }
                        else {
                            imageView.setImageResource(R.drawable.img_error);
                            tvWarningMath.setText("No math");
                            tvWarningMath.setTextColor(Color.parseColor("#FF0000"));
                            Log.d("PASSWORD","DIFERENT");
                            read.enableMath(false);
                        }
                    }
                });
            }
        });
    }
}
