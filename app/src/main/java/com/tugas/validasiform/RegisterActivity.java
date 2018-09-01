package com.tugas.validasiform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtEmail, txtPassword, txtConfirm, txtNama, txtUltah, txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         txtEmail = findViewById(R.id.txtemail);
         txtPassword = findViewById(R.id.txtpwd);
         txtConfirm = findViewById(R.id.txtcfpwd);
         txtNama = findViewById(R.id.txtname);
         txtUltah = findViewById(R.id.txtbirth);
         txtPhone = findViewById(R.id.txtphone);
    }

    private boolean emailPattern(){

        Pattern path = Patterns.EMAIL_ADDRESS;
        Matcher match = path.matcher(txtEmail.getText());

        return match.matches();
    }

    private boolean error(){
        boolean ada = false;

        if (TextUtils.isEmpty(txtNama.getText().toString())){
            ada = true;
            txtNama.setError("Nama Ga boleh kosong GUOBLOOOK !!!");
        }

        if (TextUtils.isEmpty(txtPassword.getText().toString())){
            ada = true;
            txtPassword.setError("Passwordnya diisi GOBLOK !!!");
        }
        if (TextUtils.isEmpty(txtConfirm.getText().toString())){
            ada = true;
            txtConfirm.setError("Konfirmasi dulu Password Lu !!!");
        }

        if (TextUtils.isEmpty(txtEmail.getText().toString())){
            ada = true;
            txtEmail.setError("Email Ga boleh kosong GUOBLOOOK !!!");
        }
        if (TextUtils.isEmpty(txtUltah.getText().toString())){
            ada = true;
            txtUltah.setError("Isi Tanggal Lahir");
        }
        if (TextUtils.isEmpty(txtPhone.getText().toString())){
            ada = true;
            txtPhone.setError("Isi Nomor Telepon");
        }

        String pwd = txtPassword.getText().toString();
        if (!pwd.equals(txtConfirm.getText().toString())){
            ada = true;
            txtConfirm.setError("Tidak Cocok");
        }

        if (!emailPattern()){
            ada = true;
            txtEmail.setError("Format Email salah !");
        }

        return ada;
    }

    public void submitRegister(View v){
        if (!error()) {
            Bundle dataReg = new Bundle();
            dataReg.putString("email", txtEmail.getText().toString());
            dataReg.putString("password", txtPassword.getText().toString());

            Intent i = new Intent(this, LoginActivity.class);
            i.putExtras(dataReg);
            startActivity(i);
        }
    }
}
