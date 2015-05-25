package com.aitfa.kmv.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Intent intentSec;
    Intent intentAlt;
    Intent intentTafTish;
    Intent intentLis;
    Button button1;
    Button btnAltmn;
    Button btnTafTish;
    Button btnLis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        button1  = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentSec = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentSec);
            }
        });

        btnAltmn = (Button)findViewById(R.id.btnAltman);
        btnAltmn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentAlt = new Intent(MainActivity.this, AltmanActivity.class);
                startActivity(intentAlt);
            }
        });

        btnTafTish = (Button)findViewById(R.id.btnTafTish);
        btnTafTish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentTafTish = new Intent(MainActivity.this, TaflerTishouActivity.class);
                startActivity(intentTafTish);
            }
        });

        btnLis = (Button)findViewById(R.id.btnLis);
        btnLis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentLis = new Intent(MainActivity.this, LisActivity.class);
                startActivity(intentLis);
            }
        });

    }

}
