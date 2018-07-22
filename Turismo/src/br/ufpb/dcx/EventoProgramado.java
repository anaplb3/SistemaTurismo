package br.ufpb.dcx;

public class EventoProgramado extends AtrativoTuristico{
	public String dataInicio;
	public String dataFim;
	public String tipo;
	public Endereco endereco;
	public static final String TIPO_FESTA = "Festa";
	public static final String TIPO_FEIRA_GASTRONOMICA = "Feira gastrônomica";
	
	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public EventoProgramado(String nome) {
		super(nome,"0","0","","","");
		this.dataInicio = "";
		this.dataFim = "";
		this.tipo = "";
		
	}
	
	public EventoProgramado(String nome, String latitude, String longitude, String comoChegar, String site, String infoContato, String dataInicio, String dataFim, String tipo, Endereco endereco) {
		super(nome, latitude, longitude, comoChegar, infoContato, site);
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tipo = tipo;
		this.endereco = endereco;
	}
	
	public EventoProgramado(String nome, String latitude, String longitude, String comoChegar, String siteEvento, String contatoEvento, String bairro, String logradouro, String numero) {
		super("","0","0","","","");
		this.dataInicio = "";
		this.dataFim = "";
		this.tipo = "";
		
	}
	
	public String getDescricao() {
		return "Nome: "+super.getNome()+"\nLatitude: "+super.getLatitude()+"\nLongitude: "+super.getLongitude()+"\nComo chegar: "+super.getComoChegar()+"\nContato: "+super.getInfoContato()+"\nSite: "+super.getSite()+"\nData inicio: "+this.dataInicio+"\nData fim: "+this.dataFim+"\nTipo: "+this.tipo+"\nLogradouro: "+this.endereco.getLogradouro()+"\nBairro: "+this.endereco.getBairro()+"\nNumero: "+this.endereco.getNumero();
	}
}
