package com.example.myapplication;

import static com.example.myapplication.SecondActivity.SHARE_NAME;
import static com.example.myapplication.SecondActivity.user_ID;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static public boolean log_in = false;
    static EditText text_ID, text_PW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_ID = (EditText) findViewById(R.id.text_ID); // 아이디
        text_PW = (EditText) findViewById(R.id.text_PW); // 비밀번호

        if (log_in) {
            ArrayList<String> list = getStringArrayPref(user_ID.getText().toString());
            text_ID.setText(list.get(3));
            text_PW.setText(list.get(4));
        }

        // 로그인 버튼을 눌렀을 때
        Button button_login = (Button) findViewById(R.id.btn_log_in);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = getStringArrayPref(text_ID.getText().toString());
                // if 문: 로그인 가능할 때
                if (list.size() != 0 && list.get(4).equals(text_PW.getText().toString())) {
                    android.util.Log.d("Sign In if", list.get(4));
                    Toast.makeText(getApplicationContext(), "호그와트 서점에 오신 걸 환영합니다", Toast.LENGTH_SHORT).show();
                    log_in = true;
                    Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호를 다시 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 회원가입 화면으로 이동
        Button btn_sign_up = (Button) findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                log_in = false;
                Toast.makeText(getApplicationContext(), "로그아웃하고 회원가입 화면으로 이동합니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        // 비회원 상품보기로 이동
        Button btnNoneMember = (Button) findViewById(R.id.btn_none_member);
        btnNoneMember.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                log_in = false;
                Toast.makeText(getApplicationContext(), "로그아웃 상태로 서점으로 이동합니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    public ArrayList<String> getStringArrayPref(String key) {
        SharedPreferences prefs = getSharedPreferences(SHARE_NAME, MODE_PRIVATE);
        String json = prefs.getString(key, null);
        ArrayList<String> urls = new ArrayList<String>();
        if (json != null) {
            try{
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }


}