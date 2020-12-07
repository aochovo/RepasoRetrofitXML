/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasoaccesodatosretrofit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 *
 * @author alex
 */
public class PeticionXML {
    private static ComunicacionPedirDatos clase_llamante1;
    
    public PeticionXML(ComunicacionPedirDatos clase_llamante1) {
        this.clase_llamante1 = clase_llamante1;
    }
 
   public static void pedirProvincias(HashMap<String,String> mapa)
	{
		
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/")
                                .addConverterFactory(SimpleXmlConverterFactory.create())
			    .build();

			ServicioPedirDatos service = retrofit.create(ServicioPedirDatos.class);
			
			Call<RaizProvincia> llamada=service.pedirProvincias();
			llamada.enqueue(new Callback<RaizProvincia>() {
				
				@Override
				public void onResponse(Call<RaizProvincia> call, Response<RaizProvincia> response) {
					
					
					
					RaizProvincia p=response.body();
					List<Provincia> lista_provincias=p.getProvinciero();
					
					clase_llamante1.mostrarProvincias(lista_provincias, mapa);
				}
				
				@Override
				public void onFailure(Call<RaizProvincia> call, Throwable t) {
					// TODO Auto-generated method stub
					System.out.println("ERROR: "+t.getLocalizedMessage());
					
				}
			});
	}
   public static void pedirMunicipios(String nombre_provincia, HashMap<String, String> mapa_municipios)
	{
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/")
			    .addConverterFactory(SimpleXmlConverterFactory.create())
			    .build();

			ServicioPedirDatos service = retrofit.create(ServicioPedirDatos.class);
			Call<RaizMunicipio> llamada_municipios=service.pedirMunicipios(nombre_provincia, "");
			llamada_municipios.enqueue(new Callback<RaizMunicipio>() {

				@Override
				public void onResponse(Call<RaizMunicipio> call, Response<RaizMunicipio> response) {
					
					RaizMunicipio p=response.body();
					List<Municipio> lista_municipios=p.getLista_municipios();
					
					clase_llamante1.mostrarMunicipios(lista_municipios, mapa_municipios);
				}

				@Override
				public void onFailure(Call<RaizMunicipio> call, Throwable t) {
					// TODO Auto-generated method stub
					System.out.println("ERROR: "+t.getLocalizedMessage());
				}
			});
	}

    public static void pedirClima(String codigo_aemet)
	{
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("http://www.aemet.es/xml/")
			    .addConverterFactory(SimpleXmlConverterFactory.create())
			    .build();

			ServicioPedirDatos service = retrofit.create(ServicioPedirDatos.class);
			Call<RaizClima> llamada_clima=service.pedirClima(codigo_aemet);
			llamada_clima.enqueue(new Callback<RaizClima>() {

				@Override
				public void onResponse(Call<RaizClima> call, Response<RaizClima> response) {
					
					clase_llamante1.mostrarClima(response.body());
					
				}

				@Override
				public void onFailure(Call<RaizClima> call, Throwable t) {
					System.out.println("ERROR: "+t.getLocalizedMessage());
				}
			});
	}
	public interface ComunicacionPedirDatos
	{	public void mostrarProvincias(List<Provincia> lisat_provincias, HashMap<String, String> mapa);
		public void mostrarMunicipios(List<Municipio> lisat_municipios, HashMap<String, String> mapa);
		public void mostrarClima(RaizClima clima);
	}
       

	}

	
