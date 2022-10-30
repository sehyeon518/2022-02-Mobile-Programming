package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondActivity extends Activity {
    static String SHARE_NAME = "SHARE_PREF";
    static SharedPreferences sharePref = null;
    public static final String SETTINGS_PLAYER_JSON = "settings_item_json";


    // 뷰 객체 생성
    EditText user_name, user_number, user_address, user_ID, user_PW;
    RadioButton radio_agree;
    // 변수 객체 생성
    String name, number, address, ID, PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        user_name = (EditText) findViewById(R.id.user_name); // 이름
        user_number = (EditText) findViewById(R.id.user_number); // 전화번호
        user_address = (EditText) findViewById(R.id.user_address); // 주소
        user_ID = (EditText) findViewById(R.id.user_ID); // 아이디
        user_PW = (EditText) findViewById(R.id.user_PW); // 비밀번호
        radio_agree = (RadioButton) findViewById(R.id.btn_info_agree); // 이용 동의

        sharePref = getSharedPreferences(SHARE_NAME, MODE_PRIVATE); // 이 앱에서만 사용 가능

        // 회원가입 완료 버튼 눌렀을 때
        Button btn_return = (Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = user_name.getText().toString();
                number = user_number.getText().toString();
                address = user_address.getText().toString();
                ID = user_ID.getText().toString();
                PW = user_PW.getText().toString();

                if (!radio_agree.isChecked()) {
                    Toast.makeText(getApplicationContext(), "약관을 읽고 동의 해주세요.", Toast.LENGTH_SHORT).show();
                    radio_agree.requestFocus();
                }
                else if (name.equals("")) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    user_name.requestFocus();
                }
                else if (address.equals("")) {
                    Toast.makeText(getApplicationContext(), "주소를 입력해주세요", Toast.LENGTH_SHORT).show();
                    user_address.requestFocus();
                }
                else if (number.equals("")) {
                    Toast.makeText(getApplicationContext(), "전화번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                    user_number.requestFocus();
                }
                else if (!Pattern.matches("^01(?:0|1[6-9])(?:\\d{3}|\\d{4})\\d{4}$", number)) {
                    Toast.makeText(getApplicationContext(), "올바른 전화번호가 아닙니다", Toast.LENGTH_SHORT).show();
                }
                else if (ID.equals("")) {
                    Toast.makeText(getApplicationContext(), "ID를 입력해주세요", Toast.LENGTH_SHORT).show();
                    user_ID.requestFocus();
                }
                else if (ID.length() < 8) {
                    Toast.makeText(getApplicationContext(), "ID는 8자 이상이어야 합니다", Toast.LENGTH_SHORT).show();
                }
                else if (getStringArrayPref(ID).size() != 0) {
                    Toast.makeText(getApplicationContext(), "이미 존재하는 아이디입니다", Toast.LENGTH_SHORT).show();
                }
                else if (PW.equals("")) {
                    Toast.makeText(getApplicationContext(), "PW를 입력해주세요", Toast.LENGTH_SHORT).show();
                    user_PW.requestFocus();
                }
                else if (!check_password(PW)) {
                    Toast.makeText(getApplicationContext(), "PW는 영문 대소문자, 특수기호, 숫자가 적어도 하나씩 포함되어야 합니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    // 모든 입력이 정상적일 때
                    ArrayList<String> list = new ArrayList<>();
                    list.add(user_name.getText().toString());
                    list.add(user_address.getText().toString());
                    list.add(user_number.getText().toString());
                    list.add(user_ID.getText().toString());
                    list.add(user_PW.getText().toString());

                    setStringArrayPref(String.valueOf(user_ID.getText()), list);
                    Toast.makeText(getApplicationContext(), "회원가입 완료되었습니다", Toast.LENGTH_SHORT).show();
                    android.util.Log.d("Sign Up", list.toString());
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void setStringArrayPref(String key, ArrayList<String> values) {
        SharedPreferences prefs = getSharedPreferences(SHARE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) editor.putString(key, a.toString());
        else editor.putString(key, null);
        editor.apply();
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
    boolean check_password(String password) {
        String val_symbol = "([0-9].*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*[0-9])";
        String val_alpha = "([a-z].*[A-Z])|([A-Z].*[a-z])";

        Pattern pattern_symbol = Pattern.compile(val_symbol);
        Pattern pattern_alpha = Pattern.compile(val_alpha);

        Matcher matcher_symbol = pattern_symbol.matcher(password);
        Matcher matcher_alpha = pattern_alpha.matcher(password);

        if (matcher_symbol.find() && matcher_alpha.find())
            return true;
        else return false;
    }
}


