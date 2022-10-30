package com.example.myapplication;

import static com.example.myapplication.MainActivity.log_in;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AskActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        // 회원정보
        Button btn_ok = (Button) findViewById(R.id.ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "회원가입 페이지로 이동합니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        Button btn_no = (Button) findViewById(R.id.no);
        btn_no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "비회원 상태로 서점으로 이동합니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}