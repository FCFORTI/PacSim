package consumibles;
import posicionables.Pac;

public class EscudoDeFuerza extends Provision {
	
	@Override
	public void efectuarSobre(Pac jugador) {
		jugador.sumarEscudo();
		System.out.println("+1 Escudo");
	}
	
}


