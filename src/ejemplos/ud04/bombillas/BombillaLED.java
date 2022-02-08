package ejemplos.ud04.bombillas;
/**
 * @author Alejandro Martin Alvarez
 *
 */
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BombillaLED extends Bombilla{
	
	private int tonalidad;
	private LocalDateTime ultimaVezApagada;
	
	private static final TipoBombilla tipo = TipoBombilla.LED;
//constructorbombilla
	public BombillaLED(String marca, String modelo, float consumo, long vidaUtil) {
		super(marca, modelo, consumo, vidaUtil, "Sin nombre");
		tonalidad = 0;
		ultimaVezApagada = LocalDateTime.now();
	}
	
	public BombillaLED(String marca, String modelo, float consumo, long vidaUtil, String nombre) {
		super(marca, modelo, consumo, vidaUtil, nombre);
		tonalidad = 0;
		ultimaVezApagada = LocalDateTime.now();
	}
//heredadodebombilla
	@Override
	public TipoBombilla getTipo() {
		return tipo;
	}
	//encender cuando se enciende se comprueba si hace menos de tres segundos que se apagó
	//como ultimavencendida es localdatetime se puede meter en el between
	
	//apagar se actualiza la última vez que se apagó
	//como ultimavezagada es localdatetime se puede meter en el between
	@Override
	public void encender() {
		if(!encendida && encendidos <= vidaUtil)
		{
				encendidos++;
				encendida=true;
				ultimaVezEncendida = LocalDateTime.now();
				
				if(ChronoUnit.SECONDS.between(ultimaVezApagada,ultimaVezEncendida) < 3  ) {
					tonalidad = (tonalidad + 1) % 3;
				}
				
		}
		
		if(encendidos>vidaUtil) {
			throw new BombillaFundidaException(marca,modelo,vidaUtil);
		}
	}
	
	@Override
	public void apagar() {
		if(encendida) {
			ultimaVezApagada = LocalDateTime.now();
			tiempoEncendida += ChronoUnit.SECONDS.between(ultimaVezEncendida,ultimaVezApagada);
			
			encendida = false;
		}
			
	}
	//comprobamos si está encendida, te deuvle el tostring con la tonalidad, sino el tostring del padre
	@Override
	public String toString() {
		String res;
		if(encendida) {
			res = "BombillaLED [tonalidad=" + tonalidad + ", marca=" + marca + ", modelo=" + modelo + ", nombre=" + nombre + "]";
		}else {
			res = super.toString();
		}
		return res;
	}
	
}
