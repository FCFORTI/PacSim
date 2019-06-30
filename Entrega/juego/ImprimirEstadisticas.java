package juego;

import posicionables.Pac;

public class ImprimirEstadisticas {
	
	Pac jugador ;
	
	public ImprimirEstadisticas(Pac jugador) {
		this.jugador = jugador;
	}
	
	public void mostrar() {
		System.out.println("Vidas: " + jugador.getVida());
		System.out.println("Escudos: " + jugador.getEscudo());
	}

}
