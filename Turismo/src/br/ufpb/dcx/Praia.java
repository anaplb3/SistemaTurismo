package br.ufpb.dcx;

public class Praia extends AtrativoNatural{
	private boolean perigoTubarao;
	private boolean propriaPraBanho;
	private String tipoDeOrla;
	public static final String TIPO_MAR_ABERTO = "Mar aberto";
	public static final String TIPO_PEQUENAS_ONDAS = "Pequenas ondas";
	public static final String TIPO_MAR_ABRIGADO = "Mar abrigado";
	public static final String TIPO_ONDAS_MEDIAS = "Ondas médias";
	public static final String TIPO_PISCINAS_NATURAIS = "Piscinas naturais";
	public static final String TIPO_ONDAS_FORTES = "Ondas fortes";
	
	
	
	public boolean isPerigoTubarao() {
		return perigoTubarao;
	}

	public void setPerigoTubarao(boolean perigoTubarao) {
		this.perigoTubarao = perigoTubarao;
	}

	public boolean isPropriaPraBanho() {
		return propriaPraBanho;
	}

	public void setPropriaPraBanho(boolean propriaPraBanho) {
		this.propriaPraBanho = propriaPraBanho;
	}

	public String getTipoDeOrla() {
		return tipoDeOrla;
	}

	public void setTipoDeOrla(String tipoDeOrla) {
		this.tipoDeOrla = tipoDeOrla;
	}

	public Praia(String nome, String latitude, String longitude, String comoChegar, String site, String infoContato, 
			boolean perigoTubarao, boolean propriaParaBanho, String tipoOrla) {
		super(nome, longitude, latitude, comoChegar, site, infoContato);
		this.perigoTubarao = perigoTubarao;
		this.propriaPraBanho = propriaParaBanho;
		this.tipoDeOrla = tipoOrla;
	}
	
	public Praia(String nome) {
		super(nome,"0","0","","","");
		this.perigoTubarao = false;
		this.propriaPraBanho = false;
		this.tipoDeOrla = "";
	}
	
	public Praia() {
		super("","0","0","","","");
		this.perigoTubarao = false;
		this.propriaPraBanho = false;
		this.tipoDeOrla = "";
	}
	
	public String getDescricao() {
		return "Nome: "+super.getNome()+"\nLatitude: "+super.getLatitude()+"\nLongitude: "+super.getLongitude()+"\n Como chegar: "+super.getComoChegar()+"\nContato: "+super.getInfoContato()+"\nSite: "+super.getSite()+"\nTipo de orla: "+this.tipoDeOrla;
	}
	
	
}
