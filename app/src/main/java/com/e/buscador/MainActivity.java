package com.e.buscador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SearchView svBusqueda;
    private Button btnIr;
    private static final String GOOGLE ="https://www.google.com";
    private static final String SEARCH ="/search?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        svBusqueda = (SearchView) findViewById(R.id.svBusqueda);


        svBusqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String ver = query;
                if (!query.isEmpty()){
                    if (URLUtil.isValidUrl(query)) {
                        Intent i = new Intent(getApplicationContext(), Resultado.class);
                        i.putExtra("cadena", ver);

                        startActivity(i);
                    } else {
                        Intent i = new Intent(getApplicationContext(), Resultado.class);
                        ver=(GOOGLE+SEARCH+query);
                        i.putExtra("cadena", ver);

                        startActivity(i);

                        //Toast.makeText(getApplicationContext(), "Dirección inválida, reintente.", Toast.LENGTH_LONG).show();
                    }
                return true;
            }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}