package com.aitfa.kmv.balance;

import android.app.Activity;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DavidovaBelicovaActivity extends Activity {
    private Toolbar toolbar;
    private Button reportBtn;
    private EditText VneobAct;
    private EditText ObAct;
    private EditText Capital;
    private EditText IntegralZatr;
    private EditText Viruchka;
    private EditText Chistay;
    private TextView Rez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.davidova_belikova_layout);
        initToolbar();
        VneobAct = (EditText)findViewById(R.id.ETVneoborotrAct);
        ObAct = (EditText)findViewById(R.id.ETOborotAct);
        Capital = (EditText)findViewById(R.id.ETCapital);
        IntegralZatr= (EditText)findViewById(R.id.ETIntegralnieZatrati);
        Viruchka = (EditText)findViewById(R.id.ETViruchka);
        Chistay = (EditText)findViewById(R.id.ETChistay);

        Rez = (TextView)findViewById(R.id.result);

        reportBtn = (Button)findViewById(R.id.report);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double VneobActive = 0.0;
                VneobActive = Double.parseDouble(String.valueOf(VneobAct.getText()));
                double ObAcive = 0.0;
                ObAcive = Double.parseDouble(String.valueOf(ObAct.getText()));
                double CapitalRez = 0.0;
                CapitalRez = Double.parseDouble(String.valueOf(Capital.getText()));

                double Virchka = 0.0;
                Virchka = Double.parseDouble(String.valueOf(Viruchka.getText()));
                double IntegrZatrat = 0.0;
                IntegrZatrat = Double.parseDouble(String.valueOf(IntegralZatr.getText()));
                double ChistPrib = 0.0;
                ChistPrib = Double.parseDouble(String.valueOf(Chistay.getText()));


                double x1;
                double x2;
                double x3;
                double x4;

                double z = 0;
                try{
                    x1 = ObAcive/(VneobActive+ObAcive);
                    x2 = ChistPrib/CapitalRez;
                    x3 = Virchka/(VneobActive+ObAcive);
                    x4 = ChistPrib/IntegrZatrat;

                    z = 8.38 * x1 + x2 + 0.054 * x3 + 0.63 * x4;
                }
                catch (Exception e){}
                String resultat = "";
                resultat += String.format("%s %.3f ", getResources().getString(R.string.ModelDavBel), z);
                if (z < 0){
                    resultat += String.format("%s ", getResources().getString(R.string.DavBelMax));
                }
                else if (z < 0.18 && z >=0){
                    resultat += String.format("%s ", getResources().getString(R.string.DavBelHigh));
                }

                else if (z < 0.32 && z >= 0.18){
                    resultat += String.format("%s ", getResources().getString(R.string.DavBelMid));
                }
                else if (z < 0.42 && z >= 0.32){
                    resultat += String.format("%s ", getResources().getString(R.string.DavBelLov));
                }
                else{
                    resultat += String.format("%s ", getResources().getString(R.string.DavBelLovest));
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
