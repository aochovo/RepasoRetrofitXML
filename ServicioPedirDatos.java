/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasoaccesodatosretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 * @author alex
 */
public interface ServicioPedirDatos {
   @GET("ovccallejero.asmx/ConsultaProvincia")
    Call<RaizProvincia> pedirProvincias(); 
    @GET("ovccallejero.asmx/ConsultaMunicipio")
    Call<RaizMunicipio> pedirMunicipios(@Query("Provincia") String provincia,
                                        @Query("Municipio") String municipio);
    //http://www.aemet.es/xml/municipios/localidad_28079.xml
    @GET("municipios/localidad_{codigo}.xml")
    Call<RaizClima> pedirClima(@Path("codigo") String codigo);
}
