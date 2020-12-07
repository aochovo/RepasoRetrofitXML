/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasoaccesodatosretrofit;

import java.util.List;

/**
 *
 * @author alex
 */
class PintaHTML {

    static String hacerTabla(RaizClima clima, String nombre) {
        List<Dia> lista_dias=clima.getPrediccion();
        String html="<html><head></head><h1>"+nombre+"</h1><body><table bordercolor='blue'><tr><th>FECHA</th><th>TEMPERATURA MÁXIMA</th><th>TEMPERATURA MÍNIMA</th></tr>";
        for (Dia x: lista_dias)
        {
            html=html+"<tr><td>"+x.getFecha()+"</td><td align='right'>"+x.getTemperatura().getMaxima()+"</td><td align='right'>"+x.getTemperatura().getMinima()+"</td></tr>";
        }
        html=html+"</table></body></html>";
        return html;
    }
    
}
