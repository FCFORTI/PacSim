public class EscudoDeFuerza extends Provision{

	@Override
	public void efectuarSobre(Pac jugador){
		jugador.aumentarEscudo();
	}
	
}
