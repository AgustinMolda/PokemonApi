package ar.com.codoacodo.pokemon.base;

import ar.com.codoacodo.pokemon.entrenador.EntrenadorBase;

public class BatallaPokemon {
	private EntrenadorBase entrenador1,entrenador2, entrenador3, entrenador4;
	
public BatallaPokemon(EntrenadorBase entrenador1, EntrenadorBase entrenador2) {
	super();
	this.entrenador1 = entrenador1;
	this.entrenador2 = entrenador2;
}

public BatallaPokemon(EntrenadorBase entrenador1, EntrenadorBase entrenador2, EntrenadorBase entrenador3) {
	super();
	this.entrenador1 = entrenador1;
	this.entrenador2 = entrenador2;
	this.entrenador3 = entrenador3;
}

public BatallaPokemon(EntrenadorBase entrenador1, EntrenadorBase entrenador2, EntrenadorBase entrenador3,
		EntrenadorBase entrenador4) {
	super();
	this.entrenador1 = entrenador1;
	this.entrenador2 = entrenador2;
	this.entrenador3 = entrenador3;
	this.entrenador4 = entrenador4;
}

public GestionaPokemon elegirPokemon(EntrenadorBase entrenador,int numero) {
	
	return entrenador.getPokeball(numero);
}

//Verificar que pasa si el pokemon no tiene hp
public void atacar(GestionaPokemon p1,int numero,GestionaPokemon p2) {
	
	while(p1.getHp()>0 || p2.getHp()>0) {
		p2.recibirDanio(p1.attak(numero) );
		
	}
	
	
	
}



public EntrenadorBase getEntrenador1() {
	return entrenador1;
}



public void setEntrenador1(EntrenadorBase entrenador1) {
	this.entrenador1 = entrenador1;
}



public EntrenadorBase getEntrenador2() {
	return entrenador2;
}



public void setEntrenador2(EntrenadorBase entrenador2) {
	this.entrenador2 = entrenador2;
}



public EntrenadorBase getEntrenador3() {
	return entrenador3;
}



public void setEntrenador3(EntrenadorBase entrenador3) {
	this.entrenador3 = entrenador3;
}



public EntrenadorBase getEntrenador4() {
	return entrenador4;
}



public void setEntrenador4(EntrenadorBase entrenador4) {
	this.entrenador4 = entrenador4;
}
		
		
}
