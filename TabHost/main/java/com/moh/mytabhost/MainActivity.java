package com.moh.mytabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("First").setIndicator("First").setContent(new Intent(this, first_layout.class)));
        tabHost.addTab(tabHost.newTabSpec("Second").setIndicator("Second").setContent(new Intent(this, second_layout.class)));
        tabHost.setCurrentTab(0);
    }
}
