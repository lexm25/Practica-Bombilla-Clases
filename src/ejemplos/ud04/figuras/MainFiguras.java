package ejemplos.ud04.figuras;
/**
 * @author Alejandro Martin Alvarez
 *
 */
public class MainFiguras {

	public static void main(String[] args) {
		Cuadrado a = new Cuadrado(4);
		a.setNombre("manolo");
		System.out.println(a);
		a.imprimeFigura();
		
		Triangulo b = new Triangulo(5,3);
		b.imprimeFigura();
		System.out.println(b.area());
		
		Rectangulo c = new Rectangulo(6,4);
		c.imprimeFigura();
	}

}
