package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onIndexSendButtonClicked(View view) {
        EditText editText = findViewById(R.id.text);
        String index = editText.getText().toString();

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("ImageIndex", index);
        startActivity(intent);
    }
}
