package com.example.day4_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getCanonicalName();
    private EditText edtName;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.editName);
        sharedPreferences = getSharedPreferences("myName", MODE_PRIVATE);

        if (sharedPreferences.contains("nameKey")){
        String file = sharedPreferences.getString("nameKey",null);
        if(file != null){
            Log.d(TAG,file);
            Log.i(TAG,file);
            Log.v(TAG,file);
            Log.w(TAG,file);
            Log.e(TAG,file);

            edtName.setText(file);
        }
        }
    }

    public void btnSaveClick(View view){

        if (edtName.getText().length() != 0) {
            String name = edtName.getText().toString();
            SharedPreferences.Editor mEditor = sharedPreferences.edit();
            mEditor.putString("nameKey", name);
            mEditor.apply();
            //mEditor.commit();

            Intent iIntent = new Intent(MainActivity.this,DisplaySharedPreferenceActivity.class);
            startActivity(iIntent);
        }
    }
}
