public class Pac extends Posicionable{

	private int vida, escudo, ejeX, ejeY, limiteDeColumnasDelTablero;
	private boolean jugadorPerdio, ganador;
	
	public Pac(int posicion, int ejeX, int ejeY, int limiteDeColumnasDelTablero) {
		setPosicion(posicion);
		this.ejeX = ejeX;
		this.ejeY = ejeY;
		this.limiteDeColumnasDelTablero = limiteDeColumnasDelTablero;
		this.ganador = false;
		this.jugadorPerdio = false;
	}
	
	public void moverArriba(){
		this.ejeX --;
		actualizarPosicion();
	}
	
	public void moverAbajo(){
		this.ejeX ++;
		actualizarPosicion();
	}
	
	public void moverDerecha(){
		this.ejeY ++;
		actualizarPosicion();
	}
	
	public void moverIzquierda(){
		this.ejeY --;
		actualizarPosicion();
	}
	
	public void aumentarVida(){
		this.vida ++;
	}
	
	public void disminuirVida(){
		this.vida --;
		if (this.vida == 0){
			this.jugadorPerdio = true;
		}
	}
	
	public void aumentarEscudo(){
		this.escudo ++;
	}
	
	public void disminuirEscudo(){
		this.escudo --;
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}
	
	public void actualizarPosicion(){
		int posicion = limiteDeColumnasDelTablero * ejeX + ejeY;
		setPosicion(posicion);
	}

	public int getEjeX() {
		return ejeX;
	}

	public int getEjeY() {
		return ejeY;
	}

	public boolean isJugadorPerdio() {
		return jugadorPerdio;
	}
	
	@Override
	public String toString(){
		return "J";
	}
	
	@Override
	public boolean sePuedeAtravesar() {
		return false;
	}

	public void setEsGanador(boolean b) {
		this.ganador = true;		
	}
	
	public boolean getGanador(){
		return this.ganador;
	}

}
