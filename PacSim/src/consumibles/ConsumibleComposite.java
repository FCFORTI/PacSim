package consumibles;
import java.util.ArrayList;

import posicionables.Pac;
import interfaces.Casillero;
import interfaces.Consumible;

public class ConsumibleComposite extends Casillero implements Consumible {
	
	ArrayList<Consumible> provisiones = new ArrayList<Consumible>();

	public void agregar(Consumible nuevoConsumible) {
		provisiones.add(nuevoConsumible);
	}
	
	@Override
	public void efectuarSobre(Pac jugador) {
		for (Consumible consumible : provisiones) {
			consumible.efectuarSobre(jugador);
		}	
	}
}