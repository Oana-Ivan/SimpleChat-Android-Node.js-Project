package com.example.simplechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 10);;

        EditText et_enter_name = findViewById(R.id.et_name);

        findViewById(R.id.enter_room_btn)
                .setOnClickListener(v -> {
                    Intent intent = new Intent(this, ChatActivity.class);
                    intent.putExtra("nameUser", et_enter_name.getText().toString());
                    startActivity(intent);
                });
    }
}