public class Posicion {
	
	private int posicion, ejeX, ejeY;
	
	public Posicion(int ejeX, int ejeY){
		this.ejeX = ejeX;
		this.ejeY = ejeY;
	}

	public int getEjeX() {
		return ejeX;
	}

	public int getEjeY() {
		return ejeY;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	
}
