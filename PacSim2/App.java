import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException{
		CargarConfiguracion cConf = new CargarConfiguracion("configuracion.txt");
		Tablero tablero = cConf.cargarTablero();
		
		tablero.mostrarEnConsola();
		
		Scanner sc = new Scanner(System.in);
		while(!tablero.hayGanador() && !tablero.elJugadorPerdio()) {

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
				tablero.moverJugadorIzquierda();
			}

			if (texto.equals("s")) {
				tablero.moverJugadorAbajo();
			}

			if (texto.equals("d")) {	
				tablero.moverJugadorDerecha();
			}

			if (texto.equals("f")) {	
				System.out.println("VIDA: " + tablero.getJugador().getVida() + " ESCUDO: " + tablero.getJugador().getEscudo());
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
