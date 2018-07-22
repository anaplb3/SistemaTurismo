package br.ufpb.dcx;

public class MunicipioJaExisteException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8945226153168760726L;

	public MunicipioJaExisteException(String msgErro) {
		super(msgErro);
	}
	
	public MunicipioJaExisteException() {
		this("Erro: Municipio já existe");
	}
}
