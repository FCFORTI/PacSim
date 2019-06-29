package consumibles;
import posicionables.Pac;

public class VidaExtra extends Provision {

	@Override
	public void efectuarSobre(Pac jugador) {
		jugador.sumarVida();
		System.out.println("+1 Vida");
	}
}
	
	

	
	

