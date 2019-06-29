public class CajaDeVitaminas extends Provision{

	@Override
	public void efectuarSobre(Pac jugador){
		jugador.aumentarVida();
	}
	
}
