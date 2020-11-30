package com.e.buscador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Resultado extends AppCompatActivity {
    private WebView wvNet;
    private Button btnRetroceso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        wvNet=(WebView) findViewById(R.id.wvInternet);
        btnRetroceso= (Button) findViewById(R.id.btnRetro);

        wvNet.setWebViewClient(new WebViewClient());
        wvNet.getSettings().setJavaScriptEnabled(true);
        wvNet.loadUrl (getIntent().getExtras().getString("cadena"));

        btnRetroceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
            }
    @Override
            public void onBackPressed(){
        if(wvNet.canGoBack()){
            wvNet.goBack();
        }else{
            super.onBackPressed();
        }
    }

}