package com.example.greenflag.data;

import android.widget.Button;

public class Read {

    static  private boolean email;
    public boolean password;
    public boolean passwordMath;
    public boolean write;
    public Button button;

    public Read(Button myButton){
        button = myButton;
    }

    public void checkButtonState() {
                if (email && password && passwordMath){
                    button.setEnabled(true);
                }
                else {
                    button.setEnabled(false);
                }
    }

    public void enableEmail(boolean enable){
        email = enable;
        checkButtonState();
    }

    public void enablePassword(boolean enable){
        password = enable;
        checkButtonState();
    }

    public void enableMath(boolean enable){
        passwordMath = enable;
        checkButtonState();
    }

    public void enableWrite(boolean enable){
        write = enable;
    }
}
