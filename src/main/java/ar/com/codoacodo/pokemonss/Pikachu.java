package ar.com.codoacodo.pokemonss;



import java.util.List;

import ar.com.codoacodo.pokeapi.Move;
import ar.com.codoacodo.pokemons.Ataque;

public class Pikachu extends Pokemon{

	public Pikachu(String nombre) {
		super("electrico", nombre, 100);
		ataques.add(new Ataque("agilidad",10) );
		ataques.add(new Ataque("cola de hierro" ,15) );
		ataques.add(new Ataque("trueno",20) );
	}

	@Override
	public void aprenderAtaque(Ataque ataque) {
		ataques.add(ataque);
	
	}

	@Override
	public int atacar() {
		int contador=0;
		for (Ataque at: this.ataques) {
			contador+=at.getPuntoAtaque();
		}
		return contador;
	}

	

	public void recorrerAtaques() {
		for (Ataque at : this.ataques) {
			System.out.println(at.getNombre() + "potecia: " + at.getPuntoAtaque());
		}
	}





	
	
}
