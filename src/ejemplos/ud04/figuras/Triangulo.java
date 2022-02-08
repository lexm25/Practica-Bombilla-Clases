package ejemplos.ud04.figuras;
/**
 * @author Alejandro Martin Alvarez
 *
 */
public class Triangulo extends FiguraGeometrica {

	private static String relleno = "^ ";
	private float base;
	private float altura;

	/**
	 * @param Constructor normal y sobrecargado de Triangulo
	 */
	public Triangulo(float base, float altura) {
		this.base = base;
		this.altura = altura;
	}

	public Triangulo(float base, float altura, String nombre) {
		super(nombre);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public float area() {
		return (base * altura) / 2;
	}

	public float calcularHipotenusa() {
		return (float) Math.sqrt((altura * altura) + (base * base));
	}

	@Override
	public float perimetro() {
		return base + altura + calcularHipotenusa();
	}

	@Override
	public void imprimeFigura() {
		int base = (int) this.base;
		int altura = (int) this.altura;

		for (int i = 1; i <= altura - 1; i++) {
			System.out.print(relleno);
			System.out.println("");
		}
		for (int j = 1; j <= base; j++) {
			System.out.print(relleno);
		}
		System.out.println("");
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
		Triangulo.relleno = caracterRelleno;
	}

}
