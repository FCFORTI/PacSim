package juego;
import posicionables.Pac;
import posicionables.Vacio;
import interfaces.Casillero;

public class Tablero {
	
	private Casillero[][] matriz;
	private int dimFilas, dimColumnas;
	private TransformarPosicion adaptador;
	private Pac jugador;
		
	public Tablero(int n, int m) {
		this.matriz = new Casillero[n][m];
		this.dimFilas = n;
		this.dimColumnas = m;
		this.jugador = null;
		this.adaptador = new TransformarPosicion(dimFilas,dimColumnas);
		for (int i = 0; i < matriz.length; i++) { 
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = new Vacio();
			}
		}
	}
	
	public void mostrarEnConsola() {
		System.out.println();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) { 	
				System.out.print(matriz[i][j] + " ");
				if (j == matriz[i].length - 1) {
					System.out.print("|"+i+"|" +"\n");
					
				}	
			}			
		}		
	}
	
	public void agregarCasillero(Casillero nuevo, int pos) {
		int fila = adaptador.aFila(pos);
		int columna = adaptador.aColumna(pos);
		matriz[fila][columna] = nuevo;
	}

	public void agregarJugador(Pac jugador, int posJugador) {
		this.jugador = jugador;
		int fila = adaptador.aFila(posJugador);
		int columna = adaptador.aColumna(posJugador);
		matriz[fila][columna] = jugador;
	}

	public void moverJugadorArriba() {
		if(!hayPared(jugador.posI()-1, jugador.posJ())) {
			int posAntI = jugador.posI();
			int posAntJ = jugador.posJ();
			this.jugador.moverArriba();
			this.matriz[posAntI][posAntJ] = new Vacio();
			actualizarJugador(jugador.posI(), jugador.posJ());
		}
	}

	public void moverJugadorAbajo() {
		if(!hayPared(jugador.posI()+1,jugador.posJ())) {
			int posAntI = jugador.posI();
			int posAntJ = jugador.posJ();
			this.jugador.moverAbajo();
			this.matriz[posAntI][posAntJ] = new Vacio();
			actualizarJugador(jugador.posI(), jugador.posJ());
		}
	}

	public void moverJugadorIzq() {
		if(!hayPared(jugador.posI(), jugador.posJ()-1)) {
			int posAntI = jugador.posI();
			int posAntJ = jugador.posJ();
			this.jugador.moverIzquierda();
			this.matriz[posAntI][posAntJ] = new Vacio();
			actualizarJugador(jugador.posI(), jugador.posJ());
		}
	}

	public void moverJugadorDer() {
		if(!hayPared(jugador.posI(), jugador.posJ()+1)) {
			int posAntI = jugador.posI();
			int posAntJ = jugador.posJ();
			this.jugador.moverDerecha();
			this.matriz[posAntI][posAntJ] = new Vacio();
			actualizarJugador(jugador.posI(), jugador.posJ());
		}	
	}

	public boolean hayGanador() {
		return jugador.getEsGanador();
	}

	public boolean hayPerdedor() {
		return jugador.getVida() == 0;
	}
	
	public int cantidadDeFilas() {
		return this.dimFilas;
	}
	
	public int cantidadDeColumnas() {
		return this.dimColumnas;
	}

	public Pac getJugador() {
		return this.jugador;
	}

	private void actualizarJugador(int posI, int posJ) {
		matriz[jugador.posI()][jugador.posJ()].efectuarSobre(this.jugador);
		matriz[jugador.posI()][jugador.posJ()] = this.jugador;
	}

	private boolean hayPared(int posI, int posJ) {
		
		if( (posI >= 0 && posI < dimFilas) && ((posJ >= 0 && posJ < dimColumnas)) )
			return !matriz[posI][posJ].sePuedeAtravesar();
		else{
			return false;
		}
	}	
}	



