package com.moh.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.home) {
            Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
        }
        if (itemId == R.id.facebook) {
            Toast.makeText(this, "Facebook Clicked", Toast.LENGTH_SHORT).show();
        }
        if (itemId == R.id.about) {
            Toast.makeText(this, "About Clicked", Toast.LENGTH_SHORT).show();
        }
        if (itemId == R.id.mail) {
            Toast.makeText(this, "Mail Clicked", Toast.LENGTH_SHORT).show();
        }
        if (itemId == R.id.exit) {
            Toast.makeText(this, "Exit Clicked", Toast.LENGTH_SHORT).show();
            MainActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
