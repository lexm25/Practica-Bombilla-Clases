package ejemplos.ud04.figuras;
/**
 * @author eserrano
 *
 */
public abstract class FiguraGeometrica {
	
	private String nombre;
	
	public FiguraGeometrica() {
		nombre="Sin Nombre";
	}
	
	public FiguraGeometrica(String nombre) {
		this.nombre=nombre;
	}

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
	 * Metodo que devuelve el Area de la figura geometrica
	 * @return Area de la figura geometrica en centimetros cuadrados
	 */
	public abstract float area();
	
	/**
	 * Metodo que devuelve el perimetros de la figura geometrica
	 * @return perimetro de la figura geometrica en centimetros
	 */
	public abstract float perimetro();
	
	/**
	 * Metodo que realiza una representacion de la figura por Consola.
	 */
	public abstract void imprimeFigura();
	
	@Override
	public String toString() {
		return "Figura Geometrica: " + nombre + ". " + super.toString();
	}

}
