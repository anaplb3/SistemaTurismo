package br.ufpb.dcx;

public class AtrativoNaoExisteException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AtrativoNaoExisteException(String msgErro) {
		super(msgErro);
	}
	
	public AtrativoNaoExisteException() {
		this("O atrativo não foi cadastrado");
	}
}
