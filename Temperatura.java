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
public class Temperatura {
	@Element
	private int maxima;
	@Element
	private int minima;

	public int getMaxima() {
		return maxima;
	}

	public void setMaxima(int maxima) {
		this.maxima = maxima;
	}

	public int getMinima() {
		return minima;
	}

	public void setMinima(int minima) {
		this.minima = minima;
	}

	@Override
	public String toString() {
		return "Temperatura [maxima=" + maxima + ", minima=" + minima + "]";
	}
	
	
	
}
