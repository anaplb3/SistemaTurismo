package br.ufpb.dcx;

public class AtrativoJaExisteException extends Exception{
	
	public AtrativoJaExisteException(String msgErro) {
		super(msgErro);
	}
	
	public AtrativoJaExisteException() {
		this("Esse atrativo j� foi cadastrado");
	}
}
