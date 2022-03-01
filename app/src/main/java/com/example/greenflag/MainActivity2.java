package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.greenflag.data.Load;
import com.example.greenflag.data.Read;
import com.example.greenflag.data.Write;
import com.example.greenflag.validator.Email;
import com.example.greenflag.validator.MathPassword;
import com.example.greenflag.validator.Password;

public class MainActivity2 extends AppCompatActivity {

    public static String SHARED_PREFS = "sharedPrefs";
    public static String TEXT= "text";
    Button btnNext;
    EditText etEmail, etPassword,etMathPassword;
    ImageView imgCheckEmail,imgCheckPassword,imgCheckMath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //LINK
        btnNext = findViewById(R.id.bt_next);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etMathPassword = findViewById(R.id.et_check_repeat_password);

        imgCheckEmail = findViewById(R.id.img_check_email);
        imgCheckPassword = findViewById(R.id.img_check_password);
        imgCheckMath = findViewById(R.id.img_repeat_password);


        //DATA
        Write write = new Write();
        Read read = new Read();
        Load load = new Load();

        //VALIDATOR
        Email email = new Email();
        Password password = new Password();
        MathPassword mathPassword = new MathPassword();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   write.writeUser(sharedPreferences,"user","password");
                String email = etEmail.getText().toString();
                load.email(sharedPreferences,email);

            }
        });

        //imgCheckEmail.setImageResource(R.drawable.img_ok);
        email.checkSpaces(etEmail,imgCheckEmail);
        email.checkMatch(etPassword,etMathPassword,imgCheckMath);
        password.checkPassword(etPassword,imgCheckPassword);
        mathPassword.mathPassword(etPassword,etMathPassword,imgCheckMath);

    }

}