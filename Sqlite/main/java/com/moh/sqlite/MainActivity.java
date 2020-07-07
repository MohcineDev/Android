package com.moh.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    mysql mysql = new mysql(MainActivity.this);
    EditText id, name, mail;
    Button btnAdd, btnDelete, btnUpdate;
    ListView list, listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        list = findViewById(R.id.list);
        listView = findViewById(R.id.list0);

        displayValues();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameValue = name.getText().toString();
                String mailValue = mail.getText().toString();

                Boolean result = mysql.insertValues(nameValue, mailValue);
                if (result)
                    Toast.makeText(MainActivity.this, "Row Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                name.setText("");
                mail.setText("");
                displayValues();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String idValue = id.getText().toString();
//                String nameValue = name.getText().toString();
//                String mailValue = mail.getText().toString();
//
//                Boolean result = mysql.updateValues(idValue, nameValue, mailValue);
//
//                if (result) {
//                    Toast.makeText(MainActivity.this, "Update Done", Toast.LENGTH_SHORT).show();
//                    id.setText("");
//                    name.setText("");
//                    mail.setText("");
//                    displayValues();
//                }

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idValue = id.getText().toString();
                Integer result = mysql.deleteRow(idValue);

                if (result > 0) {
                    Toast.makeText(MainActivity.this, "Delete Done", Toast.LENGTH_SHORT).show();
                    id.setText("");
                    displayValues();
                } else {
                    Toast.makeText(MainActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void displayValues() {
        ArrayList<String> values = mysql.getValues();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
         list.setAdapter(arrayAdapter);

    }

}
