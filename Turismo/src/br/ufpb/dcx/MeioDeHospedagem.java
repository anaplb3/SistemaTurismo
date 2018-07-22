package br.ufpb.dcx;

public class MeioDeHospedagem {
	private String nome;
	private double latitude;
	private double longitude;
	private String infoContato;
	private String site;
	private String tipoHospedagem;
	private Endereco endereco;
	public static final String TIPO_HOTEL = "Hotel";
	public static final String TIPO_POUSADA = "Pousada";
	public static final String TIPO_ALBERGUE = "Albergue";
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getInfoContato() {
		return infoContato;
	}

	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTipoHospedagem() {
		return tipoHospedagem;
	}

	public void setTipoHospedagem(String tipoHospedagem) {
		this.tipoHospedagem = tipoHospedagem;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public static String getTipoHotel() {
		return TIPO_HOTEL;
	}

	public static String getTipoPousada() {
		return TIPO_POUSADA;
	}

	public static String getTipoAlbergue() {
		return TIPO_ALBERGUE;
	}

	public MeioDeHospedagem(String nome) {
		this.nome = nome;
		this.latitude = 0;
		this.longitude = 0;
		this.infoContato = "";
		this.site = "";
		this.tipoHospedagem = "";
		this.endereco = new Endereco();
	}
	
	public MeioDeHospedagem(String nome, double lat, double longi, String contato, String site, String tipo, Endereco endereco) {
		this.nome = nome;
		this.latitude = lat;
		this.longitude = longi;
		this.infoContato = contato;
		this.site = site;
		this.tipoHospedagem = tipo;
		this.endereco = endereco;
		
	}
}
