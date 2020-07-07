package com.moh.intentandbundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSecond, btnThird;
    TextView infos;
    int REQUEST_Code = 12; // the id between MainActivity and Main2Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSecond = findViewById(R.id.btnSecond);
        infos = findViewById(R.id.info);
        btnThird = findViewById(R.id.btnThird);

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("src", "From First To Second");
                startActivityForResult(intent, REQUEST_Code);
//                Toast.makeText(MainActivity.this, "Second Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //third clicked
        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Anonymous Object
                startActivity(new Intent(MainActivity.this, Main3Activity.class));

                Toast.makeText(MainActivity.this, "Third Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //back button
    // Getting a result from an activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_Code) {
            if (resultCode == RESULT_OK) {
                infos.setText(data.getStringExtra("src"));
            }
        }
    }
}
