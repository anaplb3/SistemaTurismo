package br.ufpb.dcx;

import java.util.ArrayList;

public class AreaDeInteresseTuristico {
	private ArrayList<Municipio> municipios;
	private String nome;
	
	public AreaDeInteresseTuristico(String nome, ArrayList<Municipio> municipios) {
		this.municipios = municipios;
		this.nome = nome;
	}
	
	public void mostrandoMunicipio() {
		for(Municipio m: this.municipios) {
			System.out.println(" Nome: "+m.getNome()+"\n Latitude: "+m.getLatitude()+"\n Longitude: "+m.getLongitude()+"\n População: "+m.getPopulacao()+"\n Estado: "+m.getEstado()+"\n Site: "+m.getSite()+"\n");
		}
	}
	
	public AreaDeInteresseTuristico() {
		this.municipios = new ArrayList<Municipio>();
		this.nome = "";
	}
	
	public void cadastrarMunicipio(Municipio mun) throws MunicipioJaExisteException{
		boolean achou = false;
		for(Municipio m: this.municipios) {
			if(m.getNome().equals(mun.getNome())) {
				achou = true;
				break;
			}
		}
		if(achou==false) {
			this.municipios.add(mun);
		}
		else {
			throw new MunicipioJaExisteException("Erro: Municipio "+mun.getNome()+" já existe");
		}
	}
	
	public ArrayList<Municipio> getMunicipios() {
		return this.municipios;
	}
	
	public ArrayList<AtrativoTuristico> retornaAtrativosdoMunicipio(String municipioPesquisa) {
		ArrayList<AtrativoTuristico> atrativosPesq = new ArrayList<AtrativoTuristico>();
		for(Municipio m: municipios) {
			if(m.getNome().equals(municipioPesquisa)) {
				  atrativosPesq.addAll(m.getAtrativosTuristicos());
			}
		}
		return atrativosPesq;
	}
	
	
	
	  public Municipio pesquisarMunicipio(String municipioPesquisado) throws MunicipioNaoExisteException{
		    Municipio retorno = null;
		    boolean existe = false;
		    for(Municipio m1: this.municipios) {
		      if(m1.getNome().equals(municipioPesquisado)) {
		        existe = false;
		        retorno = m1;
		      }
		    }if(existe == false) {
		      return retorno;
		    }else {
		      throw new MunicipioNaoExisteException(municipioPesquisado+" não foi cadastrado!");
		    }
		  }
}
