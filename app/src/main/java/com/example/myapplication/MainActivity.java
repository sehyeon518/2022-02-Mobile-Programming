package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_login = (Button) findViewById(R.id.btn_log_in);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if 문: 로그인 가능할 때
                Toast.makeText(getApplicationContext(), "호그와트 서점에 오신 걸 환영합니다",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ThridActivity.class);
                startActivity(intent);
                // else 문: 로그인 에러 발생했을 때
//                Toast.makeText(getApplicationContext(), text:"비밀번호가 일치하지 않아요",
//                        Toast.LENGTH_SHORT.show());
            }
        });

        Button btn_sign_up = (Button) findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        Button btnNoneMember = (Button) findViewById(R.id.btn_none_member);
        btnNoneMember.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThridActivity.class);
                startActivity(intent);
            }
        });
    }
}