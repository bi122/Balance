package com.aitfa.kmv.balance;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends Activity implements View.OnClickListener {
    private Toolbar toolbar;
    private Button reportBtn;
    private EditText VneobAct;
    private EditText ObAct;
    private EditText Capital;
    private EditText KratkosrochOb;
    private EditText VneobAct2;
    private EditText ObAct2;
    private EditText Capital2;
    private EditText KratkosrochOb2;
    private TextView Rez;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        initToolbar();
        reportBtn = (Button)findViewById(R.id.report);

        VneobAct = (EditText)findViewById(R.id.ETVneoborotrAct);
        ObAct = (EditText)findViewById(R.id.ETOborotAct);
        Capital = (EditText)findViewById(R.id.ETCapital);
        KratkosrochOb = (EditText)findViewById(R.id.ETCratcosrOb);

        VneobAct2 = (EditText)findViewById(R.id.ET2VneoborotrAct);
        ObAct2 = (EditText)findViewById(R.id.ET2OborotAct);
        Capital2 = (EditText)findViewById(R.id.ET2Capital);
        KratkosrochOb2 = (EditText)findViewById(R.id.ET2CratcosrOb);

        Rez = (TextView)findViewById(R.id.result);

        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double VneobActive = 0.0;
                VneobActive = Double.parseDouble(String.valueOf(VneobAct.getText()));
                double ObAcive = 0.0;
                ObAcive = Double.parseDouble(String.valueOf(ObAct.getText()));
                double ObActive2 = 0.0;
                ObActive2 = Double.parseDouble(String.valueOf(ObAct2.getText()));
                double CapitalRez = 0.0;
                CapitalRez = Double.parseDouble(String.valueOf(Capital.getText()));
                double KratkosrochObyaz = 0.0;
                KratkosrochObyaz = Double.parseDouble(String.valueOf(KratkosrochOb.getText()));
                double KratkosrochObyaz2 = 0.0;
                KratkosrochObyaz2 = Double.parseDouble(String.valueOf(KratkosrochOb2.getText()));

                double teklikvid = 0;
                double teklikvid2;
                double obessobsred = 0;

                double koefutr = 0.0;
                boolean flag = false;
                try {
                    teklikvid = ObAcive / KratkosrochObyaz;

                    teklikvid2 = ObActive2 / KratkosrochObyaz2;
                    obessobsred = (CapitalRez - VneobActive) / ObAcive;

                    int period = 12;
                    if (teklikvid >= 2 && obessobsred >= 0.1) {
                        koefutr = (teklikvid2 + 3 / period * (teklikvid2 - teklikvid)) / 2;
                        flag = true;
                    } else {
                        koefutr = (teklikvid2 + 6 / period * (teklikvid2 - teklikvid)) / 2;
                    }
                }
                catch (Exception e ){Rez.setText("Button unpushed");}

                //накапливает результат
                String res;
                res = String.format("%s = %.3f , %s = %.3f .  \n", getResources().getString(R.string.teklikvid), teklikvid, getResources().getString(R.string.obespec), obessobsred);
                if(flag){
                    res += String.format("%s %s", getResources().getString(R.string.udov), koefutr);
                    if(koefutr >= 1){
                        res += String.format("%s", getResources().getString(R.string.ZnachKoefP));
                    }
                    else {
                        res += String.format("%s", getResources().getString(R.string.ZnachKoefM));
                    }
                }
                else{
                    res += String.format("%s %.3f .", getResources().getString(R.string.neudov), koefutr);
                    if(koefutr >= 1){
                        res += String.format("%s", getResources().getString(R.string.ZnachKoefVostP));
                    }
                    else {
                        res += String.format("%s", getResources().getString(R.string.ZnachKoefVostM));
                    }
                }
                Rez.setVisibility(View.VISIBLE);
                Rez.setText(res);
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

    @Override
    public void onClick(View v) {

    }
}
