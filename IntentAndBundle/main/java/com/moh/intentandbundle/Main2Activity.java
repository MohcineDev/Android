package com.moh.intentandbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button btnFirst, btnThird;
    TextView infos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnFirst = findViewById(R.id.btnFirst);
        btnThird = findViewById(R.id.btnThird);
        infos = findViewById(R.id.info);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            infos.setText(bundle.getString("src"));
        }

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("src", "From Second To First");
                setResult(RESULT_OK, intent);
                finish();
//                Toast.makeText(Main2Activity.this, "First Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //Third Clicked
        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("src", "From Second To Third");

                startActivity(intent);

                Toast.makeText(Main2Activity.this, "Third Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
