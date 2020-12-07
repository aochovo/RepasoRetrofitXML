/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasoaccesodatosretrofit;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author alex
 */
@Root(name="root", strict=false)
public class RaizClima {

	@ElementList
	private List<Dia> prediccion;

	
	public List<Dia> getPrediccion() {
		return prediccion;
	}


	public void setPrediccion(List<Dia> prediccion) {
		this.prediccion = prediccion;
	}


	@Override
	public String toString() {
		return "ClimaAEMET [prediccion=" + prediccion + "]";
	}
	
}
