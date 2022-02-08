package ejemplos.ud04.bombillas;
/**
 * @author eserrano
 *
 */
public class BombillaFundidaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3918691701346950285L;

	/**
	 * 
	 */
	public BombillaFundidaException(String marca, String modelo, long encendidos) {
		super("La Bombilla " + marca + " modelo " + modelo +
				" alcanzo el final de su vida util: " + 
				encendidos + " encendidos");
	}

}
