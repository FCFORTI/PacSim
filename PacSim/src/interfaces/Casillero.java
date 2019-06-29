package interfaces;

import posicionables.Pac;

public abstract class Casillero {
	
	public void efectuarSobre(Pac jugador) {}
	
	public boolean sePuedeAtravesar() {
		return true;
	}

	public String toString() {
		return " ";
	}
	
}
