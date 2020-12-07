/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasoaccesodatosretrofit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Main implements PeticionXML.ComunicacionPedirDatos{
    static PeticionXML p1;
    static String nombre_municipio="";
    
    public static void main(String[] args) {
        HashMap<String,String> mapa_provincias=new HashMap<>();
        p1= new PeticionXML(new Main());
        p1.pedirProvincias(mapa_provincias);
        int codigo_provincia=EntradaSalida.pedirCodigo();
        String codigo_provincia_string=String.valueOf(codigo_provincia);
        String nombre_provincia=mapa_provincias.get(codigo_provincia_string);
        HashMap<String, String> mapa_municipios=new HashMap<>();
        p1.pedirMunicipios(nombre_provincia, mapa_municipios);
        int codigo_municipio=EntradaSalida.pedirCodigo();
        String codigo_municipio_string=String.valueOf(codigo_municipio);
        nombre_municipio=mapa_municipios.get(codigo_municipio_string);
        while(codigo_municipio_string.length()<3)
        {
            codigo_municipio_string="0"+codigo_municipio_string;
        }
        String codigo_aemet=codigo_provincia_string+codigo_municipio_string;
        p1.pedirClima(codigo_aemet);
    }

    @Override
    public void mostrarProvincias(List<Provincia> lisat_provincias, HashMap<String, String> mapa) {
        
        for (Provincia provincias : lisat_provincias) {
            mapa.put(provincias.getCpine(), provincias.getNp());
        }
        for (String codigo_provincia : mapa.keySet()) {
            System.out.println(codigo_provincia+"---"+mapa.get(codigo_provincia));
        }
 
    }

    @Override
    public void mostrarMunicipios(List<Municipio> lisat_municipios, HashMap<String, String> mapa) {
       for (Municipio municipio : lisat_municipios) {
            mapa.put(String.valueOf(municipio.getLoine().getCodigo()),municipio.getNombre());
        }
        for (String codigo_municipio : mapa.keySet()) {
            System.out.println(codigo_municipio+"---"+mapa.get(codigo_municipio));
        }
    }

    @Override
    public void mostrarClima(RaizClima clima) {
        try {
            String tabla=PintaHTML.hacerTabla(clima, nombre_municipio);
            AccesoFichero.grabarLinea(tabla, "C:\\proyectosjava\\repasoRetrofit\\fichero.html");
            Process p = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "C:\\proyectosjava\\repasoRetrofit\\fichero.html").start();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
