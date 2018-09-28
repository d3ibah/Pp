package com.pp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        toolbar = findViewById(R.id.toolbar_signUp);
        tvSignIn = findViewById(R.id.signup_tv_signIn);

    }

    @Override
    protected void onStart() {
        super.onStart();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Spannable spannable = new SpannableString(getResources().getText(R.string.already_have_an_account_sign_in));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        };
        spannable.setSpan(clickableSpan, 25, 32, 0);
        tvSignIn.setMovementMethod(LinkMovementMethod.getInstance());
        tvSignIn.setText(spannable);
    }
}
