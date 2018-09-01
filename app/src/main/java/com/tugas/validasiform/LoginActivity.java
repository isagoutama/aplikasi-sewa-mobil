package com.tugas.validasiform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText txtEmail,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.txtemail);
        txtPassword = findViewById(R.id.txtpass);
    }

    public void pageRegister(View v){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    public void pageDashboard(View v){

        if (!validateErr()){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }

    public boolean validateErr(){
        boolean validErr = false;

        if (TextUtils.isEmpty(txtEmail.getText().toString())){
            validErr = true;
            txtEmail.setError("Isi !");
        }
        if (TextUtils.isEmpty(txtPassword.getText().toString())){
            validErr = true;
            txtPassword.setError("Isi !");
        }

        return validErr;
    }

}
