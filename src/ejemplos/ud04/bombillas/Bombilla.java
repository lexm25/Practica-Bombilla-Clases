package ejemplos.ud04.bombillas;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import ejemplos.ud04.domotica.IInterruptor;
/**
 * @author eserrano
 *
 */
public abstract class Bombilla implements IInterruptor {
	protected String marca;
	protected String modelo;
	protected float consumo;
	protected long vidaUtil;
	protected String nombre;
	
	protected boolean encendida;
	protected long encendidos;
	protected long tiempoEncendida;
	protected LocalDateTime ultimaVezEncendida;

	public Bombilla(String marca, String modelo, float consumo, long vidaUtil, String nombre) {
		this.marca = marca;
		this.modelo = modelo;
		this.consumo = consumo;
		this.vidaUtil = vidaUtil;
		this.nombre = nombre;
		encendidos = 0l;
		encendida = false;
		tiempoEncendida = 0l;
	}

	/**
	 * Tipo de Bombilla
	 * 
	 * @return Tecnologia que identifica el tipo de Bombilla
	 */
	public abstract TipoBombilla getTipo();

	//ultimavezencendida es donde se guarda la fecha cuando se encendio la bombilla y tiempoencendida el tiempo que ha estaod encendida en total
	public void encender() {
		if(!encendida && !this.estaFundida())
		{
				encendidos++;
				encendida=true;
				ultimaVezEncendida = LocalDateTime.now();
		}
		
		if(this.estaFundida()) {
			throw new BombillaFundidaException(marca,modelo,vidaUtil);
		}
	}

	public void apagar() {
		if(encendida) {
			tiempoEncendida += ChronoUnit.SECONDS.between(ultimaVezEncendida,LocalDateTime.now());
			encendida = false;
		}
			
	}
	
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public float getConsumo() {
		return consumo;
	}

	public long getVidaUtil() {
		return vidaUtil;
	}
	
	public long setVidaUtil(long vidaUtil) {
		return this.vidaUtil = vidaUtil;
	}

	//si se llama a gettiempoencendida mientras la bombilla está encendida te devuelve 0 porque nose ha apagado,
	//entonces se tiene que actualizar la variable tiempoencendida antes de mostrarte el tiempo que ha estado encendida
	public long getTiempoEncendida() {
		if (encendida) {
			tiempoEncendida += ChronoUnit.SECONDS.between(ultimaVezEncendida,LocalDateTime.now());
		}
		return tiempoEncendida;
	}
	//si es true devuvelve encendida y es false devuelve apagada
	public String getEstado(){
		return encendida ? "Encendida" : "Apagada";
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Boolean estaFundida() {
		return encendidos > vidaUtil;
	}

	@Override
	public String toString() {
		return "Bombilla [nombre=" + nombre + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
//informe que muestra toda la informacion que quiere el usuario
	public String getInforme() {
		return "Bombilla [marca=" + marca + ", modelo=" + modelo + ", consumo=" + consumo + ", vidaUtil=" + vidaUtil
				+ ", nombre=" + nombre + " estado="+ this.getEstado() + "]";
	}

}