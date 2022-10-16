package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {

    private static final String TAG = "SeocndActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn_return = (Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText user_ID = (EditText) findViewById(R.id.user_ID);
                EditText user_PW = (EditText) findViewById(R.id.user_PW);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("user_id_input", user_ID.getText().toString());
                intent.putExtra("user_pw_input", user_PW.getText().toString());
                // 모든 입력이 정상적일 때
                Toast.makeText(getApplicationContext(), "호그와트 서점 회원이 되신 걸 환영합니다",
                        Toast.LENGTH_SHORT).show();
                startActivityForResult(intent, 0);

            }
        });

    }

}


