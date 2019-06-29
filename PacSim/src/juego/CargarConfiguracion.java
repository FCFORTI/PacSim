package juego;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import consumibles.ConsumibleComposite;
import consumibles.EscudoDeFuerza;
import consumibles.VidaExtra;
import posicionables.Mina;
import posicionables.Pac;
import posicionables.Pared;
import posicionables.Salida;

public class CargarConfiguracion {

	private String rutaArchivo;

	public CargarConfiguracion(String rutaArchivo) throws FileNotFoundException {
		this.rutaArchivo = rutaArchivo;
	}
	public static void main(String[] args) throws FileNotFoundException {
		CargarConfiguracion cConf = new CargarConfiguracion("configuracion.txt");
		cConf.cargarTablero();

	}

	public Tablero cargarTablero() throws FileNotFoundException {

		Scanner sc = new Scanner(new FileReader(rutaArchivo));
		String line="";
		Tablero tablero = null;
		int dimF=0,dimC=0;

		while(sc.hasNextLine() && !line.equals("[MINAS]")) {
			line = sc.nextLine();
			StringTokenizer st = new StringTokenizer(line,"=");
			while(st.hasMoreTokens()) {
				String actual = st.nextToken();

				if(actual.equals("M")) {
					dimC = Integer.parseInt(st.nextToken());
				}
				if(actual.equals("N")) {
					dimF = Integer.parseInt(st.nextToken());
					tablero = new Tablero(dimF,dimC);
				}
				if(actual.equals("E")) {
					int posP = Integer.parseInt(st.nextToken()); 
					TransformarPosicion adap = new TransformarPosicion(dimF, dimC);
					int fila = adap.aFila(posP);
					int columna = adap.aColumna(posP);
					tablero.agregarJugador(new Pac(new Posicion(fila,columna,tablero)), posP);
				}
				if(actual.equals("S")) {
					int posS = Integer.parseInt(st.nextToken()); 
					tablero.agregarCasillero(new Salida(), posS);
				}
				if(actual.equals("L")) {
					String cadena = st.nextToken();
					for(int i=0 ; i < cadena.length() ; i++) {
						char chars = cadena.charAt(i);
						if(chars == '1') {
							tablero.agregarCasillero(new Pared(),i);
						}
					}
				}
			}
		}
		sc.close();
		cargarMinas(tablero);
		cargarProvisiones(tablero);
		
		return tablero;
	}

	private void cargarMinas(Tablero tablero) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileReader(rutaArchivo));
		String line;

		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.equals("[MINAS]")){
				line = sc.nextLine();
				StringTokenizer st = new StringTokenizer(line,"=");
				while(st.hasMoreTokens()) {
					String actual = st.nextToken();
					if(actual.equals("B")) {
						StringTokenizer stAux = new StringTokenizer(st.nextToken(),",");
						while(stAux.hasMoreTokens()) {
							int actualAux = Integer.parseInt(stAux.nextToken());
							tablero.agregarCasillero(new Mina(),actualAux);
						}
					}
				}
			}
		}
		sc.close();
	}

	private void cargarProvisiones(Tablero tablero) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileReader(rutaArchivo));
		String line="";
		HashMap<String,ConsumibleComposite> dicc = new HashMap<String,ConsumibleComposite>();

		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.equals("[PROVISIONES]")) 
				break;
		}

		while (!line.equals("[UBICACION_PROVISIONES]")) {

			line = sc.nextLine();
			StringTokenizer st = new StringTokenizer(line,"=");

			while(st.hasMoreTokens()) {

				String actual = st.nextToken();

				if(st.countTokens() == 1) {

					ConsumibleComposite nuevo = new ConsumibleComposite();
					dicc.put(actual, nuevo);

					StringTokenizer stAux = new StringTokenizer(st.nextToken(),",");

					while(stAux.hasMoreTokens()) {
						String actualAux= stAux.nextToken();

						if(actualAux.equals("E")) {
							dicc.get(actual).agregar(new EscudoDeFuerza());
						} else if(actualAux.equals("V")) {
							dicc.get(actual).agregar(new VidaExtra());
						} else {
							dicc.get(actual).agregar(dicc.get(actualAux));
						}

					}

				}
			}
		}	
		sc.close();
		ubicarProvisiones(tablero,dicc);
	}


	private void ubicarProvisiones(Tablero tablero, HashMap<String,ConsumibleComposite> dicc) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileReader(rutaArchivo));
		String line="";

		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.equals("[UBICACION_PROVISIONES]")) 
				break;
		}

		while(sc.hasNextLine()) {

			line = sc.nextLine();
			StringTokenizer st = new StringTokenizer(line,"=");

			while(st.hasMoreTokens()){

				String actual = st.nextToken();

				if(st.countTokens() == 1) { 
					StringTokenizer stAux = new StringTokenizer(st.nextToken(),",");
					while(stAux.hasMoreTokens()) {
						int pos = Integer.parseInt(stAux.nextToken());
						tablero.agregarCasillero(dicc.get(actual),pos);
					}		
				}
			}
		}
		sc.close();
	}			
}





	
	
	
	
	