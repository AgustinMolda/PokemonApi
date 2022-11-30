package ar.com.codoacodo.pokemons;

import java.util.Collection;
import java.util.List;

import ar.com.codoacodo.pokeapi.Move;

public interface  Aprendible  {

	public void aprenderAtaque (Ataque ataque);
	
	public void aprenderUnAtaque (Collection<Move> ataque);
	
	public int atacar ();
	

	
	
	

}
