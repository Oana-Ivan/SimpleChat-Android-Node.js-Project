package com.example.simplechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_enter_name = findViewById(R.id.et_name);

        findViewById(R.id.enter_room_btn)
                .setOnClickListener(v -> {
                    Intent intent = new Intent(this, ChatActivity.class);
                    intent.putExtra("nameUser", et_enter_name.getText().toString());
                    startActivity(intent);
                });
    }
}