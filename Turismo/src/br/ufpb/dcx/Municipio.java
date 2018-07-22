package br.ufpb.dcx;

import java.util.List;
import java.util.ArrayList;

public class Municipio {
	private String nome;
	private int populacao;
	private List<AtrativoTuristico> atrativosTuristicos;
	private double latitude;
	private double longitude;
	private List<MeioDeHospedagem> meiosDeHospedagem;
	private String estado;
	private String site;
	
	public Municipio(String nomeMunicipio) {
		this.nome = nomeMunicipio;
		this.atrativosTuristicos = new ArrayList<AtrativoTuristico>();
		this.latitude = 0;
		this.longitude = 0;
		this.meiosDeHospedagem = new ArrayList<MeioDeHospedagem>();
		this.estado = "";
		this.site = "";
	}
	
	public Municipio() {
		this.nome = " ";
		this.atrativosTuristicos = new ArrayList<AtrativoTuristico>();
		this.latitude = 0;
		this.longitude = 0;
		this.meiosDeHospedagem = new ArrayList<MeioDeHospedagem>();
		this.estado = "";
		this.site = "";
	}
	
	
	public Municipio(String nome, int pop, ArrayList<AtrativoTuristico> atrativos, double longi, double lat, ArrayList<MeioDeHospedagem> hospedagem, String estado, String site) {
		this.nome = nome;
		this.atrativosTuristicos = atrativos;
		this.populacao = pop;
		this.longitude = longi;
		this.latitude = lat;
		this.meiosDeHospedagem = hospedagem;
		this.estado = estado;
		this.site = site;
	}
	
	public AtrativoTuristico pesquisarAtrativo(String nomeAtrativo) throws AtrativoNaoExisteException {
		for(AtrativoTuristico at: this.atrativosTuristicos) {
			if(at.getNome().equals(nomeAtrativo)) {
				return at;
			} else {
				throw new AtrativoNaoExisteException(at.getNome()+" não foi cadastrado");
			}
		}
		return null;
	}
	
	public void cadastrarLugarPraDormir(MeioDeHospedagem hospedagem) {
		meiosDeHospedagem.add(hospedagem);
	}
	
	public void cadastrarAtrativoTuristico(AtrativoTuristico atrativo) throws AtrativoJaExisteException{
		boolean achou = false;
		
		for(AtrativoTuristico atr: this.atrativosTuristicos) {
			if(atr.getNome().equals(atrativo.getNome())) {
				achou = true;
			} 
		}
		
		if(achou == false) {
			this.atrativosTuristicos.add(atrativo);
		} else {
			throw new AtrativoJaExisteException("Atrativo já existe");
		}
	}
	
	public void mostrandoAtrativos() {

		for(AtrativoTuristico atr: this.atrativosTuristicos) {
			System.out.println(atr.getDescricao());
		}
	}
	
	public List<AtrativoTuristico> getAtrativosTuristicos() {
		return this.atrativosTuristicos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<MeioDeHospedagem> getMeiosDeHospedagem() {
		return meiosDeHospedagem;
	}

	public void setMeiosDeHospedagem(List<MeioDeHospedagem> meiosDeHospedagem) {
		this.meiosDeHospedagem = meiosDeHospedagem;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public void setAtrativosTuristicos(ArrayList<AtrativoTuristico> atrativosTuristicos) {
		this.atrativosTuristicos = atrativosTuristicos;
	}
}
