package com.example.myapplication;

import static com.example.myapplication.SecondActivity.sharePref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText text_ID, text_PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_ID = (EditText) findViewById(R.id.text_ID); // 아이디
        text_PW = (EditText) findViewById(R.id.text_PW); // 비밀번호


        // 로그인 버튼을 눌렀을 때
        Button button_login = (Button) findViewById(R.id.btn_log_in);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if 문: 로그인 가능할 때
                if(text_ID.getText().toString() != null) {
                    String input_ID = sharePref.getString("ID", null);
                    String input_PW = sharePref.getString("PW", null);
                    Toast.makeText(getApplicationContext(), "호그와트 서점에 오신 걸 환영합니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(intent);
                }
                // else 문: 로그인 에러 발생했을 때
                else {
                    Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호가 일치하지 않아요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 회원가입 화면으로 이동
        Button btn_sign_up = (Button) findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        // 비회원 상품보기로 이동
        Button btnNoneMember = (Button) findViewById(R.id.btn_none_member);
        btnNoneMember.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });

    }


}