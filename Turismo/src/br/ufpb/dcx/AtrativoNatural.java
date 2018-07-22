package br.ufpb.dcx;

public class AtrativoNatural extends AtrativoTuristico{
	
	public AtrativoNatural(String nome, String latitude, String longitude, String comoChegar, String infoContato, String site) {
		super(nome, latitude, longitude, comoChegar, infoContato, site);
	}
	
	public String getDescricao() {
		return "Nome: "+super.getNome()+" Latitude: "+super.getLatitude()+" Longitude: "+super.getLongitude()+" Como chegar: "+super.getComoChegar()+" Contato: "+super.getInfoContato()+" Site: "+super.getSite();
	}
}
