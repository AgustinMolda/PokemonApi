package ar.com.codoacodo.pokemon.base;

import java.util.Collection;
import java.util.Iterator;

import ar.com.codoacodo.pokeapi.Move;

public class GestionaPokemon {
private String nombre,tipo;
protected Collection<Move> moves;
protected Collection<String> imagenesFront;
protected Collection<String> imagenesBack;
private Integer id;

private Integer hp,peso,defence,speed,specialDefence,atack,baseExperiencia;
private Integer specialAtak;

public GestionaPokemon(Integer id,String nombre, String tipo, Collection<Move> moves, Collection<String> imagenes, Integer hp,
		Integer peso, Integer defence, Integer speed, Integer specialDefence, Integer atack, Integer baseExperiencia,
		Integer specialAtak,Collection<String> imagenesBack) {
	
	this.id = id;
	this.nombre = nombre;
	this.tipo = tipo;
	this.moves = moves;
	setImagenes(imagenes);
	this.hp = hp;
	this.peso = peso;
	this.defence = defence;
	this.speed = speed;
	this.specialDefence = specialDefence;
	this.atack = atack;
	this.baseExperiencia = baseExperiencia;
	this.specialAtak = specialAtak;
	this.imagenesBack = imagenesBack;
	
}

public void setImagenes(Collection<String> imagenes) {
	this.imagenesFront = imagenes;
}

@Override
public String toString() {
	return "GestionaPokemon [nombre=" + nombre + ", tipo=" + tipo + ", moves=" + moves + ", imagenesFront="
			+ imagenesFront + ", imagenesBack=" + imagenesBack + ", hp=" + hp + ", peso=" + peso + ", defence="
			+ defence + ", speed=" + speed + ", specialDefence=" + specialDefence + ", atack=" + atack
			+ ", baseExperiencia=" + baseExperiencia + ", specialAtak=" + specialAtak + "]";
}

public Collection<Move> getMoves() {
	return moves;
}

public String getImagenesFront(int n, String lado) {
	String imgFront="";
	
	int sum = 0;
	Iterator<String> it;
    if(lado.equalsIgnoreCase("front")) {
    	
    	 it = this.imagenesFront.iterator();
    }else {
    	it = this.imagenesBack.iterator();
    	
    }
    
    while (it.hasNext()){
    	
    	imgFront = it.next();
    	sum++;
    	if(n == sum) {
    		break;
    	}
    }
    
	return imgFront;
}


/*public String getImagenesBack(int n) {
	String imgBack="";
	
	int sum = 0;
    
    Iterator<String> it = this.imagenesBack.iterator();
    while (it.hasNext()){
    	
    	imgBack = it.next();
    	sum++;
    	if(n == sum) {
    		break;
    	}
    }
    
	return imgBack;
}*/
    
	

public Collection<String> getImagenesBack() {
	return imagenesBack;
}



}
