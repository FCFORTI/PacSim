package posicionables;
import interfaces.Casillero;

public class Mina extends Casillero {
	
	@Override
	public void efectuarSobre(Pac jugador) {
		jugador.recibirDano();
		System.out.println("EXPLOTO UNA MINA!");
	}
}