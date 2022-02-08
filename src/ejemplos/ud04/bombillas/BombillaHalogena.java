package ejemplos.ud04.bombillas;
/**
 * @author eserrano
 *
 */
public class BombillaHalogena extends Bombilla {
	private static final TipoBombilla tipo = TipoBombilla.HALOGENA;
	
	public BombillaHalogena(String marca, String modelo, float consumo, long vidaUtil) {
		super(marca, modelo, consumo, vidaUtil, "Sin nombre");
	}
	
	public BombillaHalogena(String marca, String modelo, float consumo, long vidaUtil, String nombre) {
		super(marca, modelo, consumo, vidaUtil, nombre);
	}

	@Override
	public TipoBombilla getTipo() {
		return tipo;
	}

}
