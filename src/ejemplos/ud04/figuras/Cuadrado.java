package ejemplos.ud04.figuras;
/**
 * @author eserrano
 *
 */
public class Cuadrado extends FiguraGeometrica {

	private static String relleno = "* ";
	private float lado;

	/**
	 * @param Constructor normal y sobrecargado de Cuadrado
	 */
	public Cuadrado(float lado) {
		this.lado = lado;
	}

	public Cuadrado(float lado, String nombre) {
		super(nombre);
		this.lado = lado;
	}

	@Override
	public float area() {
		return lado * lado;
	}

	@Override
	public float perimetro() {
		return lado * 4;
	}

	@Override
	public void imprimeFigura() {
		int lado = (int) this.lado;

		for (int i = 1; i <= lado; i++) {
			System.out.print(relleno);
			if (lado > 1) {
				for (int j = 2; j <= lado; j++)
					System.out.print(relleno);
			}
			System.out.println("");
		}
	}

	/**
	 * @return obetener caracterRelleno
	 */
	public static String getCaracterRelleno() {
		return relleno;
	}

	/**
	 * @param modificador de caracterRelleno
	 */
	public static void setCaracterRelleno(String caracterRelleno) {
		Cuadrado.relleno = caracterRelleno;
	}

}