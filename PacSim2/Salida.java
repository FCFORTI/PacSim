public class Salida extends Posicionable{
	
	@Override
	public void efectuarSobre(Pac jugador) {
		jugador.setEsGanador(true);
	}
	
	@Override
	public String toString(){
		return "S";
	}

}
