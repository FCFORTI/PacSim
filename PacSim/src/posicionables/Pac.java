package posicionables;

import juego.Posicion;
import interfaces.Casillero;

public class Pac extends Casillero {
	
	private int vida, escudo;
	private boolean esGanador;
	private Posicion posicionActual;
	
	public Pac(Posicion posicionActual) {
		this.vida = 1;
		this.escudo=0;
		this.posicionActual = posicionActual;
		this.esGanador = false;
	}
	
	public void recibirDano() {
		if (this.escudo > 0) {
			this.escudo--;
		} else {
			this.vida--;
		}
	}

	public int getVida() {
		return vida;
	}

	public void sumarVida() {
		this.vida++;
	}
	
	public void sumarEscudo() {
		this.escudo++;
	}
	
	public boolean getEsGanador() {
		return this.esGanador;
	}
	
	public void setEsGanador(boolean esGanador) {
		this.esGanador = esGanador;
	}
	
	public boolean hayEscudo() {
		return (this.escudo > 0);
	}

	public void moverArriba() {
		this.posicionActual.arriba();
	}

	public void moverAbajo() {
		this.posicionActual.abajo(); 
	}

	public void moverDerecha() {
		this.posicionActual.der();
	}

	public void moverIzquierda() {
		this.posicionActual.izq();
	}
	
	public int posI() {
		return this.posicionActual.getI();
	}
	public int posJ() {
		return this.posicionActual.getJ();
	}
	
	public void mostrarEstadisticas() {
		System.out.println("\nVidas: " + this.vida);
		System.out.println("Escudos: " + this.escudo);
	}
	
	@Override
	public boolean sePuedeAtravesar() {
		return false;
	}
	
	@Override
	public String toString() {
		return "J";
	}
}
