package test;

import static org.junit.Assert.*;
import juego.Posicion;
import juego.Tablero;





import juego.TransformarPosicion;

import org.junit.Assert;
import org.junit.Test;

import consumibles.ConsumibleComposite;
import consumibles.EscudoDeFuerza;
import consumibles.VidaExtra;
import posicionables.Mina;
import posicionables.Pac;
import posicionables.Pared;
import posicionables.Salida;

public class TestUnitarios {

	@Test
	public void noLanzaErrorSiQuieroMovermeFueraDeLaMatriz() {
		
		Tablero tablero = new Tablero(3, 3);
		Pac jugador = new Pac(new Posicion(0,0,tablero));
		tablero.agregarJugador(jugador, 0);
		tablero.moverJugadorArriba();
	}
	
	@Test
	public void siPisaUnaMinaSeRestaVida() {
		
		Tablero tablero = new Tablero(3, 3);
		Pac jugador = new Pac(new Posicion(0,0,tablero));
		tablero.agregarJugador(jugador, 0);
		tablero.agregarCasillero(new Mina(), 1);
		tablero.moverJugadorDer();
		Assert.assertEquals(0, jugador.getVida());
	}
	
	@Test
	public void siPisaUnVidaSeLeSumaCorrectamente() {
		
		Tablero tablero = new Tablero(3, 3);
		Pac jugador = new Pac(new Posicion(0,0,tablero));
		tablero.agregarJugador(jugador, 0);
		tablero.agregarCasillero(new VidaExtra(), 1);
		tablero.moverJugadorDer();
		Assert.assertEquals(2, jugador.getVida());
	}
	
	@Test
	public void siPisaUnEscudoSeLeSumaCorrectamente() {
		
		Tablero tablero = new Tablero(3, 3);
		Pac jugador = new Pac(new Posicion(0,0,tablero));
		tablero.agregarJugador(jugador, 0);
		tablero.agregarCasillero(new EscudoDeFuerza(), 1);
		tablero.moverJugadorDer();
		Assert.assertEquals(1, jugador.getEscudo());
	}
	
	@Test
	public void seInicializaElJugadorCorrectamenteConVida1Escudo0() {
		
		Tablero tablero = new Tablero(3, 3);
		Pac jugador = new Pac(new Posicion(0,0,tablero));
		tablero.agregarJugador(jugador, 0);
		tablero.moverJugadorDer();
		Assert.assertEquals(1, jugador.getVida());
		Assert.assertEquals(0, jugador.getEscudo());
	}
	
	@Test
	public void siHayUnaParedNoSePuedoAvanzar() {
		
		Tablero tablero = new Tablero(3, 3);
		Pac jugador = new Pac(new Posicion(0,0,tablero));
		tablero.agregarJugador(jugador, 0);
		tablero.agregarCasillero(new Pared(), 1);
		tablero.moverJugadorDer();
		Assert.assertEquals(0,jugador.posI() );
		Assert.assertEquals(0,jugador.posJ());
	}
	
	@Test
	public void siNoHayParedSeMueve() {
		
		Tablero tablero = new Tablero(3, 3);
		Pac jugador = new Pac(new Posicion(0,0,tablero));
		tablero.agregarJugador(jugador, 0);
		tablero.moverJugadorDer();
		Assert.assertEquals(0,jugador.posI() );
		Assert.assertEquals(1,jugador.posJ());
	}
	
	@Test
	public void seMueveCorrectamenteDer() {
		
		Tablero tablero = new Tablero(3,3);
		Pac jugador = new Pac(new Posicion(1,1,tablero));
		tablero.agregarJugador(jugador,4);
		tablero.moverJugadorDer();
		Assert.assertEquals(1, jugador.posI());
		Assert.assertEquals(2, jugador.posJ());
		
	}
	
	@Test
	public void seMueveCorrectamenteIzq() {
		
		Tablero tablero = new Tablero(3,3);
		Pac jugador = new Pac(new Posicion(1,1,tablero));
		tablero.agregarJugador(jugador,4);
		tablero.moverJugadorIzq();
		Assert.assertEquals(1, jugador.posI());
		Assert.assertEquals(0, jugador.posJ());
	}
	
	@Test
	public void seMueveCorrectamenteArriba() {
		
		Tablero tablero = new Tablero(3,3);
		Pac jugador = new Pac(new Posicion(1,1,tablero));
		tablero.agregarJugador(jugador,4);
		tablero.moverJugadorArriba();
		Assert.assertEquals(0, jugador.posI());
		Assert.assertEquals(1, jugador.posJ());
	}
	
	@Test
	public void seMueveCorrectamenteAbajo() {
		
		Tablero tablero = new Tablero(3,3);
		Pac jugador = new Pac(new Posicion(1,1,tablero));
		tablero.agregarJugador(jugador,4);
		tablero.moverJugadorAbajo();
		Assert.assertEquals(2, jugador.posI());
		Assert.assertEquals(1, jugador.posJ());

	}
	
	@Test
	public void seTerminElJuegoCorrectamenteSiSePasaPorLaSalida() {
		
		Tablero tablero = new Tablero(3,3);
		Pac jugador = new Pac(new Posicion(1,1,tablero));
		tablero.agregarJugador(jugador,4);
		tablero.agregarCasillero(new Salida(),5);
		tablero.moverJugadorDer();
		Assert.assertTrue(tablero.hayGanador());
	
	}
	
	@Test
	public void seTerminaElJuegoSiSeAcabanLasVidas() {
		
		Tablero tablero = new Tablero(3,3);
		Pac jugador = new Pac(new Posicion(1,1,tablero));
		tablero.agregarJugador(jugador,4);
		tablero.agregarCasillero(new Mina(),5);
		tablero.moverJugadorDer();
		Assert.assertTrue(tablero.hayPerdedor());
	}
	
	@Test
	public void siSePisaUnaMinaYHayEscudoNoSacaVidaPeroSiEscudo() {
		
		Tablero tablero = new Tablero(3,3);
		Pac jugador = new Pac(new Posicion(1,0,tablero));
		tablero.agregarJugador(jugador,3);
		tablero.agregarCasillero(new EscudoDeFuerza(),4);
		tablero.agregarCasillero(new Mina(),5);
		tablero.moverJugadorDer();
		tablero.moverJugadorDer();
		Assert.assertEquals(1,jugador.getVida());
		Assert.assertEquals(0,jugador.getEscudo());
		
	}
	
	@Test
	public void siSePisaUnaProvisionDeProvisionesSeAplicaCorrectamente() {
		
		Tablero tablero = new Tablero(3,3);
		Pac jugador = new Pac(new Posicion(1,1,tablero));
		tablero.agregarJugador(jugador,4);
		ConsumibleComposite cons = new ConsumibleComposite();
		cons.agregar(new EscudoDeFuerza());
		cons.agregar(new VidaExtra());
		tablero.agregarCasillero(cons,5);
		tablero.moverJugadorDer();
		Assert.assertEquals(2,jugador.getVida());
		Assert.assertEquals(1,jugador.getEscudo());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
