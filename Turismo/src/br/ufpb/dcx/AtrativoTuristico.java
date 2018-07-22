package br.ufpb.dcx;

public abstract class AtrativoTuristico {
	private String nome;
	private String latitude;
	private String longitude;
	private String comoChegar;
	private String site;
	private String infoContato;
	
	public AtrativoTuristico(String nome) {
		this.nome = nome;
		this.latitude = "0";
		this.longitude = "0";
		this.comoChegar = "";
		this.site = "";
		this.infoContato = "";
	}
	
	public AtrativoTuristico() {
		this.nome = "";
		this.latitude = "0";
		this.longitude = "0";
		this.comoChegar = "";
		this.site = "";
		this.infoContato = "";
	}
	
	public AtrativoTuristico(String nome, String longitude, String latitude, String comoChegar, String site, String infoContato) {
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
		this.comoChegar = comoChegar;
		this.site = site;
		this.infoContato = infoContato;
	}
	
	public abstract String getDescricao();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitudePraia) {
		this.latitude = latitudePraia;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getComoChegar() {
		return comoChegar;
	}

	public void setComoChegar(String comoChegar) {
		this.comoChegar = comoChegar;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getInfoContato() {
		return infoContato;
	}

	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}
	
	
}
