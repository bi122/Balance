package com.aitfa.kmv.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {
    Button button1 = null;


    private EditText mEditText;
    private EditText edTeRecearch_dev;
    private EditText edTeOsnovn_sredstva;
    private EditText edTeDoxod_vlosh_v_mat_chen;
    private EditText edTeOtlosh_nal_activ;
    private EditText edTeProch_vneob_active;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        mEditText = (EditText) findViewById(R.id.ETintangible_assets);
        edTeRecearch_dev = (EditText)findViewById(R.id.ETrecearch_dev);
        edTeOsnovn_sredstva = (EditText)findViewById(R.id.ETosnovn_sredstva);
        edTeDoxod_vlosh_v_mat_chen = (EditText)findViewById(R.id.ETdoxod_vlosh_v_mat_chen);
        edTeOtlosh_nal_activ = (EditText)findViewById(R.id.ETotlosh_nal_activ);
        edTeProch_vneob_active = (EditText)findViewById(R.id.ETproch_vneob_active);
        button1  = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View v) {

    }
}
