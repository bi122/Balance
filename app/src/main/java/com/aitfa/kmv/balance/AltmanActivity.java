package com.aitfa.kmv.balance;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AltmanActivity extends Activity {
    private Button reportBtn;
    private EditText VneobAct;
    private EditText ObAct;
    private EditText Capital;
    private EditText KratkosrochOb;
    private EditText DolgosrOb;
    private EditText BalancePribil;
    private EditText Viruchka;
    private EditText Chistay;
    private TextView Rez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.altman_layout);
        VneobAct = (EditText)findViewById(R.id.ETVneoborotrAct);
        ObAct = (EditText)findViewById(R.id.ETOborotAct);
        Capital = (EditText)findViewById(R.id.ETCapital);
        KratkosrochOb = (EditText)findViewById(R.id.ETCratcosrOb);
        DolgosrOb = (EditText)findViewById(R.id.ETDolgosrochOb);
        BalancePribil = (EditText)findViewById(R.id.ETBalancePribil);
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
                double DolgosrochObjaz = 0.0;
                DolgosrochObjaz = Double.parseDouble(String.valueOf(DolgosrOb.getText()));
                double KratkosrochObyaz = 0.0;
                KratkosrochObyaz = Double.parseDouble(String.valueOf(KratkosrochOb.getText()));
                double Virchka = 0.0;
                Virchka = Double.parseDouble(String.valueOf(Viruchka.getText()));
                double BalancePr = 0.0;
                BalancePr = Double.parseDouble(String.valueOf(BalancePribil.getText()));
                double ChistPrib = 0.0;
                ChistPrib = Double.parseDouble(String.valueOf(Chistay.getText()));


                double x1;
                double x2;
                double x3;
                double x4;
                double x5;
                double z = 0;
                try{
                    x1 = ObAcive/(VneobActive+ObAcive);
                    x2 = ChistPrib/(VneobActive+ObAcive);
                    x3 = BalancePr/(VneobActive+ObAcive);
                    x4 = CapitalRez/(DolgosrochObjaz+KratkosrochObyaz);
                    x5 = Virchka/(VneobActive+ObAcive);
                    z = 1.2 * x1 + 1.4 * x2 + 3.3 * x3 + 0.6 * x4 + x5;
                }
                catch (Exception e){}
                String resultat = "";
                resultat += String.format("%s %s ", getResources().getString(R.string.indAltamanaZnach), z);
                if (z >= 2.675){
                    resultat += String.format("%s ", getResources().getString(R.string.Spok2Year));
                    if (z < 2.99){
                        resultat += String.format("%s ", getResources().getString(R.string.Spok2YearNiz));
                    }
                    else {
                        resultat += String.format("%s ", getResources().getString(R.string.Spok2YearSuperNiz));
                    }
                }
                else{
                    resultat += String.format("%s ", getResources().getString(R.string.UnSpok2Year));
                    if (z > 1.81){
                        resultat += String.format("%s ", getResources().getString(R.string.UnSpok2YearVis));
                    }
                    else {
                        resultat += String.format("%s ", getResources().getString(R.string.UnSpok2YearSuperVis));
                    }
                }
                Rez.setVisibility(View.VISIBLE);
                Rez.setText(resultat);
            }
        });
    }
}
