package br.ufpb.dcx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistur {
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		AreaDeInteresseTuristico area = new AreaDeInteresseTuristico();
		ArrayList<AtrativoTuristico> atrativos = new ArrayList<AtrativoTuristico>();

		System.out.println("Bem vindo ao Sistema de Turismo!");

		boolean saida = false;
		while (saida == false) {
			System.out.println(
					" 1- Cadastrar município\n 2- Cadastrar atrativo turístico\n 3- Listar municípios\n 4- Listar atrativos de determinado município\n 5- Cadastrar hospedagem\n 6- Recuperar eventos\n 7- Sair");

			int escolha = Integer.parseInt(entrada.nextLine());
			switch (escolha) {
			case 1:
				String nome = input("Nome: ", entrada);
				Municipio munic = new Municipio(nome);

				try {
					area.cadastrarMunicipio(munic);
				} catch (MunicipioJaExisteException e) {
					System.out.println(e.getMessage() + "\n");
					break;
				}

				int populacao = Integer.parseInt(input("População: ", entrada));
				double latitude = Double.parseDouble(input("Latitude: ", entrada));
				double longitude = Double.parseDouble(input("Longitude: ", entrada));
				String estado = input("Estado: ", entrada);
				String site = input("Site: ", entrada);

				munic.setPopulacao(populacao);
				munic.setLatitude(latitude);
				munic.setLongitude(longitude);
				munic.setEstado(estado);
				munic.setSite(site);

				System.out.println("\n");
				break;

			case 2:
				int cadastrar = 1;
				while (cadastrar == 1) {
					String cidadeProcurada = input("Nome da cidade: ", entrada);
					Municipio cidade = new Municipio();
					try {
						cidade = area.pesquisarMunicipio(cidadeProcurada);
						if (cidade == null) {
							System.out.println("Município não foi cadastrado.");
							break;
						}
					} catch (MunicipioNaoExisteException error) {
						System.out.println(error.getMessage());
						break;
					}

					int choice = Integer.parseInt(input("Digite 1 para evento, 2 para atrativo natural: ", entrada));

					if (choice == 1) {
						String tipoEvento = "";
						String nomeTuristico = input("Nome do evento: ", entrada);
						EventoProgramado atrativo = new EventoProgramado(nomeTuristico);

						try {
							cidade.cadastrarAtrativoTuristico(atrativo);
						} catch (AtrativoJaExisteException erro) {
							System.out.println(erro.getMessage());
							break;
						}

						String latitudeEvento = input("Latitude: ", entrada);
						String longitudeEvento = input("Longitude: ", entrada);
						String comoChegarEvento = input("Como chegar? ", entrada);
						String siteEvento = input("Site do ponto turistico: ", entrada);
						String contatoEvento = input("Contato: ", entrada);
						String dataInicio = input("Data de inicio do evento: ", entrada);
						String dataFim = input("Data de fim do evento: ", entrada);
						int escolhaTipo = Integer.parseInt(input(
								"Qual o tipo do evento? (Digite 1 para festa ou 2 para feira gastrômica) ", entrada));
						if (escolhaTipo == 1) {
							tipoEvento = EventoProgramado.TIPO_FESTA;
						} else if (escolhaTipo == 2) {
							tipoEvento = EventoProgramado.TIPO_FEIRA_GASTRONOMICA;
						}

						String logradouro = input("Logradouro: ", entrada);
						String numero = input("Número: ", entrada);
						String bairro = input("Bairro: ", entrada);
						Endereco end = new Endereco(logradouro, bairro, numero);

						atrativo.setLatitude(latitudeEvento);
						atrativo.setLongitude(longitudeEvento);
						atrativo.setComoChegar(comoChegarEvento);
						atrativo.setSite(siteEvento);
						atrativo.setInfoContato(contatoEvento);
						atrativo.setTipo(tipoEvento);
						atrativo.setDataInicio(dataInicio);
						atrativo.setDataFim(dataFim);
						atrativo.setEndereco(end);

					}

					else if (choice == 2) {
						String tipoPraia = "";
						boolean perigoTubarao = false;
						boolean propriaParaBanho = false;
						String nomePraia = input("Nome do ponto turístico: ", entrada);

						Praia praia = new Praia(nomePraia);
						try {
							cidade.cadastrarAtrativoTuristico(praia);
						} catch (AtrativoJaExisteException errado) {
							System.out.println(errado.getMessage());
							break;
						}

						String latitudePraia = input("Latitude: ", entrada);
						String longitudePraia = input("Longitude: ", entrada);
						String comoChegarPraia = input("Como chegar? ", entrada);
						String sitePraia = input("Site do ponto turistico: ", entrada);
						String contatoPraia = input("Contato: ", entrada);

						int tubarao = Integer.parseInt(
								input("Há perigo de tubarões na praia? Digite 1 para sim ou 2 para não ", entrada));
						if (tubarao == 1) {
							perigoTubarao = true;
						}

						int banho = Integer
								.parseInt(input("Ela é própria para banho? Digite 1 para sim ou 2 para não ", entrada));
						if (banho == 1) {
							propriaParaBanho = true;
						}

						int orla = Integer.parseInt(input(
								"Escolha um tipo de orla: \n 1 para mar aberto\n 2 para pequenas ondas\n 3 para mar abrigado\n 4 para ondas medias\n 5 para piscinas naturais\n 6 parar ondas fortes ",
								entrada));
						if (orla == 1) {
							tipoPraia = Praia.TIPO_MAR_ABERTO;
						} else if (orla == 2) {
							tipoPraia = Praia.TIPO_PEQUENAS_ONDAS;
						} else if (orla == 3) {
							tipoPraia = Praia.TIPO_MAR_ABRIGADO;
						} else if (orla == 4) {
							tipoPraia = Praia.TIPO_MAR_ABRIGADO;
						} else if (orla == 5) {
							tipoPraia = Praia.TIPO_PISCINAS_NATURAIS;
						} else if (orla == 6) {
							tipoPraia = Praia.TIPO_ONDAS_FORTES;
						}

						praia.setLatitude(latitudePraia);
						praia.setLongitude(longitudePraia);
						praia.setComoChegar(comoChegarPraia);
						praia.setInfoContato(contatoPraia);
						praia.setSite(sitePraia);
						praia.setPerigoTubarao(perigoTubarao);
						praia.setPropriaPraBanho(propriaParaBanho);
						praia.setTipoDeOrla(tipoPraia);

					}
					cadastrar = Integer
							.parseInt(input("Cadastrar pontos turísticos? (1 para sim/ 2 para não) ", entrada));
					System.out.println("\n");
				}
				break;

			case 3:
				area.mostrandoMunicipio();
				System.out.println("\n");
				break;

			case 4:
				String cidadeTur = input("De qual cidade você quer ver os pontos turisticos? ", entrada);
				Municipio cidadeTuristica = new Municipio();
				try {
					cidadeTuristica = area.pesquisarMunicipio(cidadeTur);
					if (cidadeTuristica == null) {
						System.out.println("Muni.");
						break;
					}
				} catch (MunicipioNaoExisteException erro) {
					System.out.println(erro.getMessage());
					break;
				}

				cidadeTuristica.mostrandoAtrativos();

				break;

			case 5:
				String cidadeProcurada = input("Nome da cidade: ", entrada);
				Municipio cidade = new Municipio();
				try {
					cidade = area.pesquisarMunicipio(cidadeProcurada);
					if (cidade == null) {
						System.out.println("Município não foi cadastrado.");
						break;
					}
				} catch (MunicipioNaoExisteException error) {
					System.out.println(error.getMessage());
					break;
				}

				String tipoHotel = "";
				String nomeHotel = input("Nome: ", entrada);

				double latitudeHotel = Double.parseDouble(input("Latitude: ", entrada));
				double longitudeHotel = Double.parseDouble(input("Longitude: ", entrada));
				String siteHotel = input("Site do ponto turistico: ", entrada);
				String contatoHotel = input("Contato: ", entrada);
				String logradouroHotel = input("Logradouro: ", entrada);
				String numeroHotel = input("Número: ", entrada);
				String bairroHotel = input("Bairro: ", entrada);
				Endereco endHotel = new Endereco(logradouroHotel, numeroHotel, bairroHotel);

				int tipHotel = Integer.parseInt(
						input("Escolha um tipo de hospedagem: Digite 1 para hotel; 2 para pousada e 3 para albergue ",
								entrada));
				if (tipHotel == 1) {
					tipoHotel = MeioDeHospedagem.TIPO_HOTEL;
				} else if (tipHotel == 2) {
					tipoHotel = MeioDeHospedagem.TIPO_POUSADA;
				} else if (tipHotel == 3) {
					tipoHotel = MeioDeHospedagem.TIPO_ALBERGUE;
				}
				MeioDeHospedagem lugar = new MeioDeHospedagem(nomeHotel, latitudeHotel, longitudeHotel, contatoHotel,
						siteHotel, tipoHotel, endHotel);
				cidade.cadastrarLugarPraDormir(lugar);

				break;

			case 6:
				String nomeMuni = input("Nome do municipio: ", entrada);
				GravadorDeArquivos gravando = new GravadorDeArquivos();

				try {
					ArrayList<EventoProgramado> eventos = gravando
							.recuperaEvento(nomeMuni);
					System.out.println("Eventos recuperados com sucesso!");
					for (EventoProgramado e : eventos) {
						atrativos.add(e);
					}

				} catch (IOException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 7:

				ArrayList<EventoProgramado> eventos = new ArrayList<EventoProgramado>();
				GravadorDeArquivos gravador = new GravadorDeArquivos();

				ArrayList<Municipio> municipios = area.getMunicipios();
				if (municipios.size() != 0) {
					for (Municipio muni : municipios) {

						for (AtrativoTuristico a : muni.getAtrativosTuristicos()) {
							if (a instanceof EventoProgramado) {
								eventos.add((EventoProgramado) a);
							}
						}

						String nomeMunicipio = muni.getNome();
						try {
							gravador.gravando(eventos, nomeMunicipio);
							System.out.println("Arquivo gravado com sucesso!");
						} catch (IOException e) {
							System.out.println(e.getMessage());
							break;

						}
					}
				} else {
					saida = true;
				}

				saida = true;
				
			}
		}

	}

	public static String input(String textoMostrado, Scanner leitor) {
		System.out.print(textoMostrado);
		return leitor.nextLine();
	}
}
