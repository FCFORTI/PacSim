package posicionables;
import interfaces.Casillero;

public class Mina extends Casillero {
	
	@Override
	public void efectuarSobre(Pac jugador) {
		jugador.recibirDaño();
	}
}