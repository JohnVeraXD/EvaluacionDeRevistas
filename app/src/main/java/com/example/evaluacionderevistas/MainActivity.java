package com.example.evaluacionderevistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.evaluacionderevistas.AdaptadorRevista.AdaptadorRevistas;
import com.example.evaluacionderevistas.Revista.Revista;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Data
        lstOpciones = (ListView) findViewById(R.id.listRevista);

        Map<String, String> datos = new HashMap<String, String>();

        WebService ws= new WebService(
                "https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {

/*
        String lstBancos="";
        JSONArray JSONlista = new JSONArray(result);
        for(int i=0; i< JSONlista.length();i++){
            JSONObject banco= JSONlista.getJSONObject(i);
            lstBancos = lstBancos + "\n" +
                    banco.getString("code").toString() + " - " +
                    banco.getString("name").toString();
        }
*/

        ArrayList<Revista> lstUsuarios = new ArrayList<Revista> ();

        JSONArray JSONlistaUsuarios= new JSONArray(result);
        lstUsuarios = Revista.JsonObjectsBuild(JSONlistaUsuarios);
        AdaptadorRevistas adapatorUsuario = new AdaptadorRevistas(MainActivity.this, lstUsuarios);
        lstOpciones.setAdapter(adapatorUsuario);


    }
}