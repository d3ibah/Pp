package com.pp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvShowPass;
    private EditText etPassword;
    private boolean flagShowPass = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        toolbar = findViewById(R.id.toolbar_signIn);
        etPassword = findViewById(R.id.signIn_et_password);
        tvShowPass = findViewById(R.id.signIn_tv_showPass);

    }

    @Override
    protected void onStart() {
        super.onStart();
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tvShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flagShowPass) {
                    etPassword.setTransformationMethod(null);
                    etPassword.setSelection(etPassword.length());
                    tvShowPass.setText(getResources().getText(R.string.hide));
                    flagShowPass = !flagShowPass;
                } else {
                    flagShowPass = !flagShowPass;
                    etPassword.setTransformationMethod(new PasswordTransformationMethod());
                    tvShowPass.setText(getResources().getText(R.string.show));
                }
            }
        });
    }


}
