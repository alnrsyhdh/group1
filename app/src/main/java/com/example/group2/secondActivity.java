package com.example.group2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.settingsMenu:
                startActivity(new Intent(secondActivity.this, ViewProfile.class));
                break;

            case R.id.AboutUs:
                startActivity(new Intent(secondActivity.this, AboutUs.class));
                break;

            case R.id.clothes_menu:
                startActivity(new Intent(secondActivity.this, MenuProfile.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}