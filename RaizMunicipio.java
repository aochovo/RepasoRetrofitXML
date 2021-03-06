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
@Root(name="consulta_municipiero", strict=false)
public class RaizMunicipio {
	@ElementList(name="municipiero")
	private List<Municipio> lista_municipios;
	
/*
 * <municipiero>
<muni>
<nm>AJALVIR</nm>
<locat>
<cd>28</cd>
<cmc>2</cmc>
</locat>
<loine>
<cp>28</cp>
<cm>2</cm>
</loine>
</muni>*/

	public List<Municipio> getLista_municipios() {
		return lista_municipios;
	}

	public void setLista_municipios(List<Municipio> lista_municipios) {
		this.lista_municipios = lista_municipios;
	}

	@Override
	public String toString() {
		return "ClaseMunicipiero [lista_municipios=" + lista_municipios + "]";
	}
	
	
}
