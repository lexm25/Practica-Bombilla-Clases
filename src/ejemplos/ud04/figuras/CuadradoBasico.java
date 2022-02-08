/**
 * 
 */
package ejemplos.ud04.figuras;

/**
 * @author eserrano
 * Clase que representa un cuadrado. Independiente de cualquier otra estructura.
 */
public class CuadradoBasico {
	
	/**
	 * Caracter espacio
	 */
	private static final String ESPACIO = "  ";

	/**
	 * Caracter de Relleno
	 */
	public static final String CARACTER_RELLENO = "# ";
	
	/**
	 * Propiedad lado del cuadrado.
	 */
	private int lado;
	
	/**
	 * Propiedad nombre del cuadrado
	 * Implementar getters and Setters. (Alt + Shift + S)
	 */
	private String nombre = "Sin nombre";
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Constructor por defecto
	 */
	public CuadradoBasico() {
		lado = 1;
	}
	
	/**
	 * Constructor sobrecargado que asigna un tamanyo
	 * @param lado longitud en centimetros del lado del cuadrado
	 */
	public CuadradoBasico(int lado) {
		this.lado = lado;
	}
	
	/**
	 * Constructor sobrecargado que asigna un tamanyo de lado y un nombre
	 * @param lado longitud en centimetros del lado del cuadrado
	 * @param nombre cadena que identifica al cuadrado
	 */
	public CuadradoBasico(int lado, String nombre) {
		this.lado = lado;
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve el Area del Cuadrado
	 * @return Area en centimetros del Cuadrado
	 */
	public int area() {
		return lado*lado;
	}
	
	/**
	 * Devuelve el perimetro del cuadrado
	 * @return perimetros en centimetros del cuadrado.
	 */
	public int perimetro() {
		return 4*lado;
	}
	
	/**
	 * Devuelve una descripcion del cuadrado.
	 */
	@Override
	public String toString() {
		return "Un cuadrado llamado "+ nombre  + " de " + lado + " cm de lado";
	}
	
	/**
	 * Metodo que informa que la finalizacion del objeto
	 */
	@Override
	public void finalize() throws Throwable {
		System.out.println("Destruyendo el cuadrado: " + nombre);
	}
	
	/**
	 * Metodo que realiza una representacion del cuadrado con caracteres de relleno
	 */
	public void imprimeCuadradoRelleno() {
		for(int i=1;i<=lado;i++) {
			System.out.print(CARACTER_RELLENO);
			if(lado>1) {
				for(int j=2;j<=lado;j++)
					System.out.print(CARACTER_RELLENO);
			}
			System.out.println("");
		}
	}
	
	/**
	 * Realiza una representacion del cuadrado vacio
	 */
	public void imprimeCuadradoVacio() {
		
		System.out.println("Imprimiendo Cuadrado: " + nombre);
		if(lado>0) {
		int limite = lado + 2;
			for(int i=1; i<=limite-1; i++) {
				if(i==1)
					imprimeFilaBordeSuperior(limite);
				else if (i==limite-1)
					imprimeFilaBordeInferior(limite);
				else
					imprimeFilaInterna(limite);
				System.out.println("");
			}
		}
	}
	 
	/**
	 * Metodo interno que dibuja una fila de borde superior de la representacion vacia
	 * @param tamanyo longitud de la fila
	 */
	private void imprimeFilaBordeSuperior(int tamanyo) {
		for(int i=1;i<=tamanyo;i++) {
			if(i==1 || i == tamanyo)
				System.out.print(" ");
			else
				System.out.print("__");
		}
	}
	
	/**
	 * Metodo interno que dibuja una fila de borde inferior de la representacion vacia
	 * @param tamanyo longitud de la fila
	 */
	private void imprimeFilaBordeInferior(int tamanyo) {
		for(int i=1;i<=tamanyo;i++) {
			if(i==1 || i == tamanyo)
				System.out.print("|");
			else
				System.out.print("__");
		}
	}
	
	/**
	 * Metodo interno que dibuja una fila interna de la representacion vacia
	 * @param tamanyo longitud de la fila
	 */
	private void imprimeFilaInterna(int tamanyo) {
		for(int i=1;i<=tamanyo;i++) {
			if(i==1 || i == tamanyo)
				System.out.print("|");
			else
				System.out.print(ESPACIO);
		}
	}

}
