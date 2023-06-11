package com.example.tastebits.shared.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        DataManagerSingleton data = DataManagerSingleton.getInstance();

    }
    public void register(View view){
        startActivity(new Intent(WelcomeActivity.this,RegisterActivity.class));
    }

    public void login(View view) {
        startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
    }
}