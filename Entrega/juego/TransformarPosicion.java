package juego;

public class TransformarPosicion {
	
	private int dimFila;
	private int dimCol;

	public TransformarPosicion(int fila, int columna) {
		this.dimFila = fila;
		this.dimCol = columna;	
	}
	
	public int aFila(int pos) {
		return (pos/dimCol);  
	}
	
	public int aColumna(int pos) {
		return (pos%dimCol);
	}

}