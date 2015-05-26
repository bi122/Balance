package com.aitfa.kmv.balance;


import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LisActivity extends Activity{
    private Toolbar toolbar;
    private Button reportBtn;
    private EditText VneobAct;
    private EditText ObAct;
    private EditText CapitalRez;
    private EditText KratkosrochOb;
    private EditText DolgosrOb;
    private EditText PribilProdash;
    private EditText Neraspred;
    private TextView Rez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lis_layout);
        initToolbar();
        VneobAct = (EditText)findViewById(R.id.ETVneoborotrAct);
        ObAct = (EditText)findViewById(R.id.ETOborotAct);
        CapitalRez = (EditText)findViewById(R.id.ETCapitalRez);
        KratkosrochOb = (EditText)findViewById(R.id.ETCratcosrOb);
        DolgosrOb = (EditText)findViewById(R.id.ETDolgosrochOb);
        PribilProdash = (EditText)findViewById(R.id.ETBalancePribil);
        Neraspred = (EditText)findViewById(R.id.ETNeraspred);

        Rez = (TextView)findViewById(R.id.result);
        reportBtn = (Button)findViewById(R.id.report);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double VneobActive;
                VneobActive = Double.parseDouble(String.valueOf(VneobAct.getText()));
                double ObAcive;
                ObAcive = Double.parseDouble(String.valueOf(ObAct.getText()));
                double CapitalRezer;
                CapitalRezer= Double.parseDouble(String.valueOf(CapitalRez.getText()));
                double DolgosrochObjaz;
                DolgosrochObjaz = Double.parseDouble(String.valueOf(DolgosrOb.getText()));
                double KratkosrochObyaz;
                KratkosrochObyaz = Double.parseDouble(String.valueOf(KratkosrochOb.getText()));
                double NeraspPrib ;
                NeraspPrib = Double.parseDouble(String.valueOf(Neraspred.getText()));
                double PribilProdsh;
                PribilProdsh = Double.parseDouble(String.valueOf(PribilProdash.getText()));



                double x1;
                double x2;
                double x3;
                double x4;
                double z = 0;
                try{
                    x1 = ObAcive/(VneobActive+ObAcive);
                    x2 = PribilProdsh/(VneobActive+ObAcive);
                    x3 = NeraspPrib/(VneobActive+ObAcive);
                    x4 = CapitalRezer/(DolgosrochObjaz+KratkosrochObyaz);
                    z = 0.063 * x1 + 0.092 * x2 + 0.057 * x3 + 0.001 * x4;
                }
                catch (Exception e){}
                String resultat = "";
                resultat += String.format("%s %.5f. ", getResources().getString(R.string.ModelLisa), z);
                if (z < 0.037){
                    resultat += String.format("%s", getResources().getString(R.string.menshe02));
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
