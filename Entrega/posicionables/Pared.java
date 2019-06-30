package posicionables;
import interfaces.Casillero;

public class Pared extends Casillero {

	@Override
	public boolean sePuedeAtravesar() {
		return false;
	}
	
	@Override
	public String toString() {
		return "X";
	}
	
}
