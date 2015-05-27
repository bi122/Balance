package com.aitfa.kmv.balance;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.SocketHandler;

/**
 * Created by Mihail on 26.05.2015.
 */
public class CrorringActivity extends Activity {
    private Toolbar toolbar;
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
        setContentView(R.layout.scorring_layout);
        initToolbar();
        VneobAct = (EditText)findViewById(R.id.ETVneoborotrAct);
        ObAct = (EditText)findViewById(R.id.ETOborotAct);
        Capital = (EditText)findViewById(R.id.ETCapital);
        KratkosrochOb = (EditText)findViewById(R.id.ETCratcosrOb);
        DolgosrOb = (EditText)findViewById(R.id.ETDolgosrochOb);
        BalancePribil = (EditText)findViewById(R.id.ETBuxPribil);
        Viruchka = (EditText)findViewById(R.id.ETViruchka);
        Chistay = (EditText)findViewById(R.id.ETChistay);

        Rez = (TextView)findViewById(R.id.result);

        reportBtn = (Button)findViewById(R.id.report);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double VneobActive;
                VneobActive = Double.parseDouble(String.valueOf(VneobAct.getText()));
                double ObAcive ;
                ObAcive = Double.parseDouble(String.valueOf(ObAct.getText()));
                double CapitalRez ;
                CapitalRez = Double.parseDouble(String.valueOf(Capital.getText()));
                double KratkosrochObyaz;
                KratkosrochObyaz = Double.parseDouble(String.valueOf(KratkosrochOb.getText()));
                double BalancePr;
                BalancePr = Double.parseDouble(String.valueOf(BalancePribil.getText()));



                double SovCapital= 0;
                double TekLicvid = 0;
                double FinIndependence = 0;

                try{
                    SovCapital = BalancePr/(VneobActive+ObAcive);
                    TekLicvid = ObAcive/(KratkosrochObyaz);
                    FinIndependence = CapitalRez/(VneobActive+ObAcive);
                }
                catch (Exception e){}

                String resultat = "";
                resultat += String.format("%s %.2f. ", getResources().getString(R.string.sovCapitlal), SovCapital);
                resultat += String.format("%s %.2f. ", getResources().getString(R.string.teklikvid), TekLicvid);
                resultat += String.format("%s %.2f. ", getResources().getString(R.string.finIndepen), FinIndependence);
                double sumScore;
                double ballSovCap;
                double ballTekLikvid;
                double ballFinIndep;

                if (SovCapital>=0.3){
                    ballSovCap = 50;
                }
                else if (SovCapital>=0.2 && SovCapital<0.3){
                    ballSovCap = Score(0.3, 0.2, 49.9, 35, SovCapital);
                }
                else if (SovCapital>=0.1 && SovCapital<0.2){
                    ballSovCap = Score(0.2, 0.1, 34.9, 20, SovCapital);
                }
                else if (SovCapital>0.01 && SovCapital<0.1){
                    ballSovCap = Score(0.1, 0.01, 19.9, 5, SovCapital);
                }
                else{
                    ballSovCap = 0;
                }

                resultat += String.format("%s %.3f. ", getResources().getString(R.string.BallSovCapit), ballSovCap);

                if (TekLicvid>=2.0){
                    ballTekLikvid = 30;
                }
                else if (TekLicvid >= 1.7 && TekLicvid < 2.0){
                    ballTekLikvid = Score(2., 1.7, 29.9, 20, TekLicvid);
                }
                else if (TekLicvid >= 1.4 && TekLicvid < 1.7){
                    ballTekLikvid = Score(1.7, 1.4, 19.9, 10, TekLicvid);
                }
                else if (TekLicvid>1.1 && TekLicvid<1.4){
                    ballTekLikvid = Score(1.4, 1.1, 9.9, 1, TekLicvid);
                }
                else{
                    ballTekLikvid = 0;
                }

                resultat += String.format("%s %.3f. ", getResources().getString(R.string.BallTekLik), ballTekLikvid);

                if (FinIndependence>=0.7){
                    ballFinIndep = 20;
                }
                else if (FinIndependence >= 0.45 && FinIndependence < 0.7){
                    ballFinIndep = Score(0.7, 0.45, 19.9, 10, FinIndependence);
                }
                else if (FinIndependence >= 0.3 && FinIndependence < 0.45){
                    ballFinIndep = Score(0.45, 0.3, 9.9, 5, FinIndependence);
                }
                else if (FinIndependence > 0.2 && FinIndependence < 0.3){
                    ballFinIndep = Score(0.3, 0.2, 5, 1, FinIndependence);
                }
                else{
                    ballFinIndep = 0;
                }
                resultat += String.format("%s %.3f. ", getResources().getString(R.string.BallFinNez), ballFinIndep);

                sumScore = ballFinIndep + ballSovCap + ballTekLikvid;

                if (sumScore >= 100){
                    resultat += String.format("5 %s", getResources().getString(R.string.category));
                }
                else if (sumScore < 100 && sumScore >=65){
                    resultat += String.format("4 %s", getResources().getString(R.string.category));
                }
                else if (sumScore < 65 && sumScore >= 35){
                    resultat += String.format("3 %s", getResources().getString(R.string.category));
                }
                else if (sumScore < 35 && sumScore >= 6){
                    resultat += String.format("2 %s", getResources().getString(R.string.category));
                }
                else{
                    resultat += String.format("1 %s", getResources().getString(R.string.category));
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

    private double Score(double hiper, double loper, double hibal, double lobal, double value){
        double x;
        x = (hibal - lobal)*((value-loper)/(hiper-loper))+lobal;
        return x;
    }
}
