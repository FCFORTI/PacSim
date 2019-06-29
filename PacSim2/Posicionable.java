public abstract class Posicionable {
	
	private int posicion;

	public void efectuarSobre(Pac jugador){}

	public int getPosicion(){
		return this.posicion;
	}
	
	public void setPosicion(int nuevaPosicion){
		this.posicion = nuevaPosicion;
	}

	public String toString() {
		return " ";
	}
	
	public boolean sePuedeAtravesar() {
		return true;
	}
	
}
