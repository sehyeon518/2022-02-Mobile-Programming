package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SecondActivity extends Activity {

    private static final String TAG = "SeocndActivity";

    private EditText edit_name;
    private EditText edit_number;
    private EditText edit_address;
    private EditText edit_ID;
    private EditText edit_PW;
    private RadioButton radio_agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edit_name = (EditText) findViewById(R.id.user_name);
        edit_number = (EditText) findViewById(R.id.user_number);
        edit_address = (EditText) findViewById(R.id.user_address);
        edit_ID = (EditText) findViewById(R.id.user_ID);
        edit_PW = (EditText) findViewById(R.id.user_PW);
        radio_agree = (RadioButton) findViewById(R.id.btn_info_agree);

        if (savedInstanceState == null) {
            SharedPreferences prefs = getSharedPreferences("person_info", 0);
            String name = prefs.getString("name", "");
            String number = prefs.getString("number", "010");
            String address = prefs.getString("address", "");
            String id = prefs.getString("ID", "");
            String pw = prefs.getString("PW", "");
            boolean agree = prefs.getBoolean("agree", false);

            edit_name.setText(name);
            edit_number.setText(number+"");
            edit_address.setText(address);
            edit_ID.setText(id);
            edit_PW.setText(pw);
            radio_agree.setChecked(agree);
        }

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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences prefs = getSharedPreferences("person_info", 0);
        SharedPreferences.Editor editor = prefs.edit();

        String name = edit_name.getText().toString();
        String number = edit_number.getText().toString();
        String address = edit_address.getText().toString();
        String ID = edit_ID.getText().toString();
        String PW = edit_PW.getText().toString();
        boolean agree = radio_agree.isChecked();

        editor.putString("name", name);
        editor.putString("number", number);
        editor.putString("address", address);
        editor.putString("ID", ID);
        editor.putString("PW", PW);
        editor.putBoolean("agree", agree);
        editor.apply();
    }

}


