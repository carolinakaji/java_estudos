package tratando_excecoes_bom.model.exceptions;

public class DomainException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	//mensagem ficará dentro da exceção DomainException
	public DomainException(String msg) {
		super(msg);
	}
}
