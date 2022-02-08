package ejemplos.ud04.figuras;
/**
 * @author Alejandro Martin Alvarez
 *
 */
public class Rectangulo extends FiguraGeometrica {

	private static String relleno = "· ";
	private float base;
	private float altura;

	/**
	 * @param Constructor normal y sobrecargado de Rectangulo
	 */
	public Rectangulo(float base, float altura) {
		this.base = base;
		this.altura = altura;
	}

	public Rectangulo(float base, float altura, String nombre) {
		super(nombre);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public float area() {
		return base * altura;
	}

	@Override
	public float perimetro() {
		return 2 * (base + altura);
	}

	@Override
	public void imprimeFigura() {
		int base = (int) this.base;
		int altura = (int) this.altura;
		for (int i = 1; i <= altura; i++) {
			System.out.print(relleno);
			if (altura > 1) {
				for (int j = 2; j <= base; j++)
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
		Rectangulo.relleno = caracterRelleno;
	}

}
