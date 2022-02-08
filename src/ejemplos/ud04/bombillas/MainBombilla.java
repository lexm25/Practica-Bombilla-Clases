package ejemplos.ud04.bombillas;

import java.util.Scanner;

import ejemplos.ud04.domotica.IInterruptor;
/**
 * @author Alejandro Martin Alvarez
 *
 */
public class MainBombilla {

	public static void main(String[] args) {

		final double precioLuz = 0.0;
		
		
		Bombilla [] dispositivos = new Bombilla[10];
		Bombilla b0 = new BombillaLED("XIAOMI", "654756", 5, 8);
		Bombilla b1 = new BombillaHalogena("SAMSUNG", "YRJK2345423", 10, 50, "manolo");
		Bombilla b2 = new BombillaHalogena("XIAOMI", "ASY456546", 20, 5, "pepe");
		Bombilla b3 = new BombillaHalogena("A2BC", "4AS56456", 30, 45, "luis");
		Bombilla b4 = new BombillaHalogena("PHILIPS", "AFAGF1153", 40, 50, "alberto");
		Bombilla b5 = new BombillaHalogena("A2BC", "456456GJY", 25, 57, "juan");
		Bombilla b6 = new BombillaHalogena("XIAOMI", "AFDAF456456", 32, 50, "jose");
		Bombilla b7 = new BombillaHalogena("PHILIPS", "ARJAFF546", 58, 54, "francisco");
		Bombilla b8 = new BombillaHalogena("XIAOMI", "AFAFD456AF", 69, 50, "julio");
		Bombilla b9 = new BombillaHalogena("PHILIPS", "AYJTDR54", 10, 69, "joaquin");

		
		dispositivos[0] = b0; 
		dispositivos[1] = b1;
		dispositivos[2] = b2;
		dispositivos[3] = b3;
		dispositivos[4] = b4;
		dispositivos[5] = b5;
		dispositivos[6] = b6;
		dispositivos[7] = b7;
		dispositivos[8] = b8;
		dispositivos[9] = b9;
		
		for(int i=0; i<12; i++) {
			encenderdispositivos(dispositivos);
			apagardispositivos(dispositivos);
		}
	}
	/**
	 * @param recoge la informacion que pide el usuario para mostrarla del getInforme de bombilla
	 * 
	 */
	public void muestraInformes(Bombilla [] bombillas) {
		for(int i=0; i<bombillas.length; i++) {
			System.out.println(bombillas[i].getInforme());	
		}	
	}
	
	private static void encenderdispositivos(Bombilla [] dispositivos) {
		for(int i=0; i< dispositivos.length; i++) {
			Bombilla iInterruptor = dispositivos[i];
			if(!iInterruptor.estaFundida()) {
				try {
					iInterruptor.encender();
				}catch(BombillaFundidaException e) {
					//System.out.println(e);
					cambiarBombilla(dispositivos, i);
				}
			}
		}
	}
	
	private static void cambiarBombilla(Bombilla[] dispositivos, int i) {
		Scanner sc = new Scanner(System.in);
		int respuesta = 0;
		int respuesta2=0;
		String r1,r2,r5;
		int r3,r4;
		System.out.println("La bombilla " + i + " se ha fundido, si desea cambiarla por otra pulse 1, sino pulse 2");
		respuesta = sc.nextInt();
		if (respuesta == 1) {
			System.out.println("Que tipo de bombilla quieres poner? 1) Halogena 2)LED");
			respuesta2 = sc.nextInt();
			System.out.println("marca");
			r1 = sc.next();
			System.out.println("modelo");
			r2 = sc.next();
			System.out.println("Consumo");
			r3 = sc.nextInt();
			System.out.println("vidautil");
			r4 = sc.nextInt();
			System.out.println("Nombre");
			r5 = sc.next();
			if(respuesta2 == 1) {
				dispositivos[i] = new BombillaHalogena(r1, r2, r3, r4, r5);
			}else if(respuesta2 == 2) {
				dispositivos[i] = new BombillaLED(r1, r2, r3, r4, r5);
			}
		}
	}
	
	private static void apagardispositivos(IInterruptor[] dispositivos) {
		for(IInterruptor iInterruptor : dispositivos) {
			iInterruptor.apagar();
		}
	}
	
}
