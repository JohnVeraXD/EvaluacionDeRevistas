package com.example.evaluacionderevistas.Revista;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {

    private String journal_id;
    private String portada;
    private String abbreviation;
    private String name;

    public Revista(JSONObject a) throws JSONException {
        journal_id = a.getString("journal_id").toString();
        portada = a.getString("portada").toString() ;
        abbreviation = a.getString("abbreviation").toString() ;
        name = a.getString("name").toString() ;
    }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revista> usuarios = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            usuarios.add(new Revista(datos.getJSONObject(i)));
        }
        return usuarios;
    }

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
