package com.aitfa.kmv.balance;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Mihail on 25.05.2015.
 */
public class TaflerTishouActivity extends Activity {
    private Toolbar toolbar;
    private Button reportBtn;
    private EditText VneobAct;
    private EditText ObAct;
    private EditText KratkosrochOb;
    private EditText DolgosrOb;
    private EditText PribilProdash;
    private EditText Viruchka;
    private TextView Rez;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tafler_tishou_layout);
        initToolbar();
        VneobAct = (EditText)findViewById(R.id.ETVneoborotrAct);
        ObAct = (EditText)findViewById(R.id.ETOborotAct);
        KratkosrochOb = (EditText)findViewById(R.id.ETCratcosrOb);
        DolgosrOb = (EditText)findViewById(R.id.ETDolgosrochOb);
        PribilProdash = (EditText)findViewById(R.id.ETBalancePribil);
        Viruchka = (EditText)findViewById(R.id.ETViruchka);

        Rez = (TextView)findViewById(R.id.result);
        reportBtn = (Button)findViewById(R.id.report);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double VneobActive;
                VneobActive = Double.parseDouble(String.valueOf(VneobAct.getText()));
                double ObAcive;
                ObAcive = Double.parseDouble(String.valueOf(ObAct.getText()));
                double DolgosrochObjaz;
                DolgosrochObjaz = Double.parseDouble(String.valueOf(DolgosrOb.getText()));
                double KratkosrochObyaz;
                KratkosrochObyaz = Double.parseDouble(String.valueOf(KratkosrochOb.getText()));
                double Virchka ;
                Virchka = Double.parseDouble(String.valueOf(Viruchka.getText()));
                double PribilProdsh;
                PribilProdsh = Double.parseDouble(String.valueOf(PribilProdash.getText()));



                double x1;
                double x2;
                double x3;
                double x4;
                double z = 0;
                try{
                    x1 = PribilProdsh/KratkosrochObyaz;
                    x2 = ObAcive/(DolgosrochObjaz+KratkosrochObyaz);
                    x3 = KratkosrochObyaz/(VneobActive+ObAcive);
                    x4 = Virchka/(VneobActive+ObAcive);
                    z = 0.53 * x1 + 0.13 * x2 + 0.18 * x3 + 0.16 * x4;
                }
                catch (Exception e){}
                String resultat = "";
                resultat += String.format("%s %.3f, ", getResources().getString(R.string.TafTish), z);
                if (z>=0.3){
                    resultat += String.format("%s", getResources().getString(R.string.bolshe03));
                }
                else if (z <= 0.2){
                    resultat += String.format("%s", getResources().getString(R.string.menshe02));
                }
                else {
                    resultat += String.format("%s", getResources().getString(R.string.between));
                }
                Rez.setVisibility(View.VISIBLE);
                Rez.setText(resultat);
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
