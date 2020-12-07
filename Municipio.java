/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasoaccesodatosretrofit;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author alex
 */
@Root(strict=false)
public class Municipio {

	@Element(name="nm")
	private String nombre;
	@Element
	private Loine loine;

	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Loine getLoine() {
		return loine;
	}


	public void setLoine(Loine loine) {
		this.loine = loine;
	}


	@Override
	public String toString() {
		return "Municipio [nombre=" + nombre + ", loine=" + loine + "]";
	}
	
	
}
