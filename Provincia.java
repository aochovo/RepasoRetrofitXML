/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasoaccesodatosretrofit;

import org.simpleframework.xml.Element;

/**
 *
 * @author alex
 */

public class Provincia {
	@Element
private String np;
	@Element
private String  cpine;
	
	
	
public String getNp() {
		return np;
	}



	public void setNp(String np) {
		this.np = np;
	}



	public String getCpine() {
		return cpine;
	}



	public void setCpine(String cpine) {
		this.cpine = cpine;
	}



@Override
public String toString() {
	return "Provincia [np=" + np + ", cpine=" + cpine + "]";
}

}
