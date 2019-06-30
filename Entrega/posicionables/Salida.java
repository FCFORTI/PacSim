package posicionables;

import interfaces.Casillero;

public class Salida extends Casillero {

	@Override
	public void efectuarSobre(Pac jugador) {
		jugador.setEsGanador(true);
	}

	@Override
	public String toString() {
		return "S";
	}

}
