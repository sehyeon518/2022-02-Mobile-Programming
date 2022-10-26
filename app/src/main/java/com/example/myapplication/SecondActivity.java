package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class SecondActivity extends Activity {
    // 접속 정보와 태그명 지정
    private static final String TAG = "Member Join";
    // 뷰 객체 생성
    EditText edit_name, edit_number, edit_address, edit_ID, edit_PW;
    RadioButton radio_agree;
    // 변수 객체 생성
    String name, number, address, ID, PW;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edit_name = (EditText) findViewById(R.id.user_name); // 이름
        edit_number = (EditText) findViewById(R.id.user_number); // 전화번호
        edit_address = (EditText) findViewById(R.id.user_address); // 주소
        edit_ID = (EditText) findViewById(R.id.user_ID); // 아이디
        edit_PW = (EditText) findViewById(R.id.user_PW); // 비밀번호
        radio_agree = (RadioButton) findViewById(R.id.btn_info_agree); // 이용 동의

        Button btn_return = (Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edit_name.getText().toString();
                number = edit_number.getText().toString();
                address = edit_address.getText().toString();
                ID = edit_ID.getText().toString();
                PW = edit_PW.getText().toString();

                if (!radio_agree.isChecked()) {
                    Toast.makeText(getApplicationContext(), "약관을 읽고 동의 해주세요.", Toast.LENGTH_SHORT).show();
                    radio_agree.requestFocus();
                }
                else if (name.equals("")) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    edit_name.requestFocus();
                }
                else if (address.equals("")) {
                    Toast.makeText(getApplicationContext(), "주소를 입력해주세요", Toast.LENGTH_SHORT).show();
                    edit_address.requestFocus();
                }
                else if (number.equals("")) {
                    Toast.makeText(getApplicationContext(), "전화번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                    edit_number.requestFocus();
                }
                else if (ID.equals("")) {
                    Toast.makeText(getApplicationContext(), "ID를 입력해주세요", Toast.LENGTH_SHORT).show();
                    edit_ID.requestFocus();
                }
                else if (PW.equals("")) {
                    Toast.makeText(getApplicationContext(), "PW를 입력해주세요", Toast.LENGTH_SHORT).show();
                    edit_PW.requestFocus();
                }
                else {
                    // 모든 입력이 정상적일 때
                    signCheck();
                    Toast.makeText(getApplicationContext(), "호그와트 서점으로 이동합니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                }
            }
        });
    }
    protected void signCheck() {
        editor.putString(ID, PW);
        editor.commit();
    }

}


