package juego;

import java.io.FileNotFoundException;
import java.util.Scanner;

import consumibles.ConsumibleComposite;
import consumibles.EscudoDeFuerza;
import consumibles.VidaExtra;
import posicionables.Mina;
import posicionables.Pac;
import posicionables.Pared;
import posicionables.Salida;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		CargarConfiguracion cConf = new CargarConfiguracion("configuracion.txt");
		Tablero tablero = cConf.cargarTablero();
		ImprimirEstadisticas impr = new ImprimirEstadisticas(tablero.getJugador());
		
		tablero.mostrarEnConsola();
		
		Scanner sc = new Scanner(System.in);
		while(!tablero.hayGanador() && !tablero.hayPerdedor()) {

			System.out.println("\nPresione para moverse...");
			System.out.println("-----------");
			System.out.println("     W");
			System.out.println("   A S D");
			System.out.println("\nF - Estadisticas");

			String texto = sc.nextLine();

			if (texto.equals("w")) {
				tablero.moverJugadorArriba();
			}

			if (texto.equals("a")) {			
				tablero.moverJugadorIzq();
			}

			if (texto.equals("s")) {
				tablero.moverJugadorAbajo();
			}

			if (texto.equals("d")) {	
				tablero.moverJugadorDer();
			}

			if (texto.equals("f")) {	
				impr.mostrar();
			}
			tablero.mostrarEnConsola();
		}

		if (tablero.hayGanador()) {
			System.out.println("\nGANASTE!! - " + "TU PUNTAJE ES: " + tablero.getJugador().getVida());
		} else {
			System.out.println("\nPERDISTE!! - TE QUEDASTE SIN VIDAS :(");
		}
		sc.close();
	}	

}
