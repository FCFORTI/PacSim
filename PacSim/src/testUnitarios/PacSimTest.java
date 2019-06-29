package testUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;


import consumibles.*;
import juego.*;
import interfaces.*;
import posicionables.*;


public class PacSimTest {

	Pac pacSim;
	VidaExtra vidaExtra;
	EscudoDeFuerza escudo;
	Provision provision1;
	Provision provision2;
	LinkedList<ConsumibleComposite> miLista;
	Casillero casillero;
	Mina mina;

	/**
	 * Se instancia un PacSim con 0 vidas extras y en la posicion 8,una Vitamina con
	 * valor 1, un Escudo con valor 2, dos botiquines uno con 1V y otro con 2E y una
	 * lista de Equipables.
	 */

	@Before
	public void before() {
		
		pacSim = new Pac(null);
		vidaExtra = new VidaExtra();
		escudo = new EscudoDeFuerza();
		miLista = new LinkedList<ConsumibleComposite>();

	}
	
	@Test
	public void cuandoElJugadorEncuentraUnaVidaExtraSeAgrega1MasALoActual(){
	
		
		pacSim.sumarVida();
		
		assertEquals(2, pacSim.getVida());
		
	}
	
	@Test
	public void siExplotaUnaMinaSeDescuentaVida(){
		
		pacSim.recibirDaño();
		
		assertEquals(0, pacSim.getVida());
		
	}
	
	
	@Test
	
	public void elJugadorEmpiezaConVidaIgualAUno(){

		assertEquals(1, pacSim.getVida());
	}
	
	
	@Test
	public void pacSimTieneUnaVidasExtrasYNoTieneEscudosAlComenzar() {
		assertEquals(1, pacSim.getVida());
		assertEquals(false, pacSim.hayEscudo());
		
	}

	
	
	/*
	@Test(expected = Error.class)
	public void pacSimInstanciadoEnPosicionErronea() {
		Tablero tab = new Tablero(7, 10);
		
		Posicion posicion = new Posicion(-10, 5, tab); 
		
		pacSim = new Pac(posicion);
	}

	@Test(expected = Error.class)
	public void pacSimInstanciadoConVidasExtrasNegativas() {
		Tablero tab = new Tablero(7, 10);
		
		Posicion posicion = new Posicion(1, 5, tab); 
		
		pacSim = new Pac(posicion);
		
		pacSim.getVida();
	}

	*/
	
	

}

