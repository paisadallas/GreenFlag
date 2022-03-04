package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.greenflag.data.Load;
import com.example.greenflag.data.Read;
import com.example.greenflag.data.Write;
import com.example.greenflag.validator.Email;
import com.example.greenflag.validator.MathPassword;
import com.example.greenflag.validator.Password;

public class MainActivity2 extends AppCompatActivity {

    public static String SHARED_PREFS = "sharedPrefs";
    Button btnNext,btnBack;
    EditText etEmail, etPassword,etMathPassword;
    ImageView imgCheckEmail,imgCheckPassword,imgCheckMath;
    TextView tvWarningEmail, tvWarningPassword,tvWarningPasswordMath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //LINK
        btnNext = findViewById(R.id.bt_next);
        btnBack = findViewById(R.id.btn_back);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etMathPassword = findViewById(R.id.et_check_repeat_password);

        imgCheckEmail = findViewById(R.id.img_check_email);
        imgCheckPassword = findViewById(R.id.img_check_password);
        imgCheckMath = findViewById(R.id.img_repeat_password);

        tvWarningEmail = findViewById(R.id.tv_error_email);
        tvWarningPassword = findViewById(R.id.tv_error_password);
        tvWarningPasswordMath = findViewById(R.id.tv_error_repeat_password);


    }

    @Override
    protected void onResume() {
        super.onResume();

        //DATA
        Write write = new Write();
        Read read = new Read(btnNext);
        Load load = new Load();

        //VALIDATOR
        Email email = new Email();
        Password password = new Password();
        MathPassword mathPassword = new MathPassword();

        //Toast
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);

        btnNext.setEnabled(false);
        //Buton back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        //Button Next
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(read.write){

                    Toast toast = Toast.makeText(context, "New user was created ", duration);
                    toast.show();

                    write.writeUser(sharedPreferences,etEmail.getText().toString(),etPassword.getText().toString());
                    email.cleanData(etEmail,etPassword,etMathPassword);
                }
                else {

                    Toast toast = Toast.makeText(context, "Welcome "+etEmail.getText()+"!", duration);
                    toast.show();

                }

            }
        });

        //EMAIL CLASS
        email.checkEmail(etEmail,imgCheckEmail,tvWarningEmail,read);
        email.checkMatch(etPassword,etMathPassword,tvWarningPasswordMath,imgCheckMath,read);
        email.checkEmailExist(etEmail,sharedPreferences,tvWarningEmail,read);
        email.cleanPasswords(etEmail,etPassword,etMathPassword);
        //PASSWORD CLASS
        password.checkPassword(etPassword,tvWarningPassword,imgCheckPassword,email,read);
        password.checkPasswordSave(etPassword,tvWarningPassword,imgCheckPassword,email,read);
        //MATH CLASS
        mathPassword.mathPassword(etPassword,etMathPassword,tvWarningPasswordMath, imgCheckMath,read);

    }
}