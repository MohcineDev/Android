package com.moh.intentandbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button btnFirst, btnSecond;
    TextView infos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        infos = findViewById(R.id.info);

        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            infos.setText(bundle.getString("src"));
        }

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                intent.putExtra("src", "From Third To First");

                startActivity(intent);

                Toast.makeText(Main3Activity.this, "First Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //Second Clicked
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                intent.putExtra("src", "From Third To Second");

                startActivity(intent);

                Toast.makeText(Main3Activity.this, "Second Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
