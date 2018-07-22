package br.ufpb.dcx;

public class MunicipioNaoExisteException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MunicipioNaoExisteException(String msgErro) {
		super(msgErro);
	}
	
	public MunicipioNaoExisteException() {
		this("Esse município não foi cadastrado");
	}
}
