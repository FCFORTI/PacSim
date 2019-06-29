import java.util.ArrayList;

public class ConsumibleComposite extends Posicionable{

	private ArrayList<Provision> provisiones = new ArrayList<Provision>();
	
	public void agregar(Provision provision){
		provisiones.add(provision);
	}
	
	@Override
	public void efectuarSobre(Pac jugador){
		for (Provision provision : provisiones){
			provision.efectuarSobre(jugador);
		}
	}
	
}
