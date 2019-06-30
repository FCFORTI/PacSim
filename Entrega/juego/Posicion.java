package juego;

public class Posicion {
	
	private int i,j,limI,limJ;
	
	public Posicion(int i, int j, Tablero tab) {
		this.i = i;
		this.j = j;
		this.limI = tab.cantidadDeFilas();	
		this.limJ = tab.cantidadDeColumnas();
	}
	
	public void abajo() {
		if(noExcedeEnFila(i+1))
			this.i = i+1;
	}
	
	public void arriba() {
		if(noExcedeEnFila(i-1))
			this.i = i-1;
	}
	
	public void izq() {
		if(noExcedeEnColumna(j-1))
			this.j = j-1;
	}
	
	public void der() {
		if(noExcedeEnColumna(j+1))
			this.j = j+1;
	}	

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	private boolean noExcedeEnFila(int valor) {
		return (valor >= 0 && valor < this.limI);
	}
	
	private boolean noExcedeEnColumna(int valor) {
		return (valor >= 0 && valor < this.limJ);
	}
	

}
