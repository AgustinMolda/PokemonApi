package ar.com.codoacodo.pokemonmain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codoacodo.pokeapi.PokeApi;
import ar.com.codoacodo.pokemon.buscarpokemonapi;
import ar.com.codoacodo.pokemon.base.BatallaPokemon;
import ar.com.codoacodo.pokemon.base.GestionaPokemon;
import ar.com.codoacodo.pokemon.entrenador.EntrenadorBase;

public class MainBatallaPokemon {
	
	
	
	
	public static void main(String[] args) throws IOException {
		
	
			
			GestionaPokemon pokemisterioso = new GestionaPokemon(30);
			
			/*	System.out.println(pokemisterioso.getNombre() + "\n"+pokemisterioso.getImagenesBack(2));
				System.out.println(pokemisterioso.cantidadImgBack());*/
			GestionaPokemon pikachu = new GestionaPokemon(25);
			
			EntrenadorBase entrenador = new EntrenadorBase("lio");
			entrenador.setPokeball(pokemisterioso);
			entrenador.setPokeball(pikachu);
			System.out.println("tengo "+entrenador.cantidadPokemon()+" pokemon");
			System.out.println(entrenador.getPokeball(0).getNombre());
			System.out.println(entrenador.getPokeball(1).getNombre());
		
		
	}
	
	
	
	
	
}
