package com.aitfa.kmv.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Intent intentScorring;
    Intent intentSec;
    Intent intentAlt;
    Intent intentTafTish;
    Intent intentLis;
    Intent intentDavBel;
    Button button1;
    Button btnAltmn;
    Button btnTafTish;
    Button btnLis;
    Button btnDavBel;
    Button btnCredScor;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        initToolbar();
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
        btnDavBel = (Button)findViewById(R.id.btnDavBel);
        btnDavBel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentDavBel = new Intent(MainActivity.this, DavidovaBelicovaActivity.class);
                startActivity(intentDavBel);
            }
        });
        btnCredScor = (Button)findViewById(R.id.btnCredScor);
        btnCredScor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentScorring = new Intent(MainActivity.this, CrorringActivity.class);
                startActivity(intentScorring);
            }
        });
    }

    private void initToolbar() {
        toolbar =(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu);
    }

}
