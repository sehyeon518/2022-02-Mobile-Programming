package com.example.myapplication;

import static com.example.myapplication.MainActivity.log_in;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // 마이페이지
        Button btn_my_page = (Button) findViewById(R.id.btn_my_page);
        btn_my_page.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 회원이 아니면
//                if (log_in) {
                    Toast.makeText(getApplicationContext(), "회원 정보 페이지로 이동합니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
//                }
            }
        });

        // 상품 추가하기
        Button btn_add_goods = (Button) findViewById(R.id.btn_add_goods);
        btn_add_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "상품추가 기능은 추후 추가됩니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // 로그인 화면으로
        Button btn_home = (Button) findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

