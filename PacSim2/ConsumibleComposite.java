import java.util.ArrayList;

public class ConsumibleComposite extends Posicionable implements Consumible{

	private ArrayList<Consumible> provisiones = new ArrayList<Consumible>();
	
	public void agregar(Consumible provision){
		provisiones.add(provision);
	}
	
	@Override
	public void efectuarSobre(Pac jugador){
		for (Consumible provision : provisiones){
			provision.efectuarSobre(jugador);
		}
	}
	
}
