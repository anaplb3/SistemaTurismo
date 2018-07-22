package br.ufpb.dcx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeArquivos {

	public void gravando(List<EventoProgramado> evento, String nomeCidade) throws IOException {

		BufferedWriter buff = new BufferedWriter(new FileWriter("Evento da cidade "+nomeCidade+".txt"));
		try {
			for (EventoProgramado e : evento) {
				buff.write(evento.size() + "\n" + e.getNome() + "\n" + e.getLatitude() + "\n" + e.getLongitude() + "\n"
						+ e.getComoChegar() + "\n" + e.getSite() + "\n" + e.getInfoContato() + "\n" + e.getTipo() + "\n"
						+ e.getDataInicio() + "\n" + e.getDataFim() + "\n"+ "\n");
			}
			buff.close();
		} finally {
			if (buff != null) {
				buff.close();
			}
		}

	}

	public ArrayList<EventoProgramado> recuperaEvento(String cidade) throws IOException {

		ArrayList<EventoProgramado> eventos = new ArrayList<EventoProgramado>();
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader("Evento da cidade "+cidade+".txt"));
			String text = null;
			do {
				int qtd = leitor.read();
				text = leitor.readLine();

				if (text != null) {
					for (int i = 0; i < qtd; i++) {
						String nome = leitor.readLine();
						String latitude = leitor.readLine();
						String longitude = leitor.readLine();
						String comoChegar = leitor.readLine();
						String siteEvento = leitor.readLine();
						String contatoEvento = leitor.readLine();
						String tipo = leitor.readLine();
						String dataInicio = leitor.readLine();
						String dataFim = leitor.readLine();

						EventoProgramado eventoSalvo = new EventoProgramado(nome, latitude, longitude, comoChegar,
								siteEvento, contatoEvento, tipo, dataInicio, dataFim);
						eventos.add(eventoSalvo);
					}
				}
			} while (text != null);

		} finally {
			if (leitor != null) {
				leitor.close();
			}
		}

		return eventos;

	}

}
