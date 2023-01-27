package ar.com.codoacodo.pokemon.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import ar.com.codoacodo.pokeapi.PokeApi;
import ar.com.codoacodo.pokemon.buscarpokemonapi;

public class GestionaPokemon {
private String nombre,tipo;
protected Collection<String> moves;
protected Collection<String> imagenesFront;
protected Collection<String> imagenesBack;


private Integer hp,peso,defence,speed,specialDefence,atack,baseExperiencia;
private Integer specialAtak;

public GestionaPokemon(  Integer numPokemon) throws IOException {

	buscarpokemonapi bp = new buscarpokemonapi("https://pokeapi.co/");
	
	
	
	PokeApi	b = bp.findUsers(numPokemon);
	
	this.nombre = b.name;
	this.tipo = b.types.get(0).type.name;
	this.hp = b.stats.get(0).baseStat;
	this.moves = b.moves.stream().map(m-> m.move.name).collect(Collectors.toList());
	this.imagenesFront = cargarImagenesFront(b);
	this.imagenesBack  = cargarImagenesBack(b);
	this.peso =  b.weight;
	this.defence = b.stats.get(2).baseStat;
	this.speed = b.stats.get(5).baseStat;
	this.specialDefence = b.stats.get(4).baseStat;
	this.atack = b.stats.get(1).baseStat;
	this.baseExperiencia = b.baseExperience;
	this.specialAtak = b.stats.get(3).baseStat;
	
	
	
	
}

public GestionaPokemon() {
	buscarpokemonapi bp = new buscarpokemonapi("https://pokeapi.co/");
	
	
	
	PokeApi	b = bp.findUsers();
	
	this.nombre = b.name;
	this.tipo = b.types.get(0).type.name;
	this.hp = b.stats.get(0).baseStat;
	this.moves = b.moves.stream().map(m-> m.move.name).collect(Collectors.toList());
	this.imagenesFront = cargarImagenesFront(b);
	this.imagenesBack  = cargarImagenesBack(b);
	this.peso =  b.weight;
	this.defence = b.stats.get(2).baseStat;
	this.speed = b.stats.get(5).baseStat;
	this.specialDefence = b.stats.get(4).baseStat;
	this.atack = b.stats.get(1).baseStat;
	this.baseExperiencia = b.baseExperience;
	this.specialAtak = b.stats.get(3).baseStat;
	
}


public Integer getHp() {
	return hp;
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

public Integer getAtack() {
	return atack;
}

public Integer attak(Integer danio) {
		
	System.out.print(getMoves(danio)+" ");
	
	return getAtack() + danio;
	
}

public Integer Specialattak(Integer danio) {
	
	System.out.print(getMoves(danio)+" ");
	
	return getSpecialAtak() + danio;
	
}


public Integer getSpecialAtak() {
	return specialAtak;
}

public String getMoves(int n) {
	String nameAtack = "";

	int sum = 0;

	Iterator<String> it = this.moves.iterator();
	while (it.hasNext()) {

		nameAtack = it.next().toString();
		sum++;
		if (n == sum) {
			break;
		}
	}

	return nameAtack;
	}

public String getImagenesFront(int n) {
	String imgFront="";
	
	int sum = 0;
    
    Iterator<String> it = this.imagenesFront.iterator();
    while (it.hasNext()){
    	
    	imgFront = it.next();
    	sum++;
    	if(n == sum) {
    		break;
    	}
    }
    
	return imgFront;
}
    

public String getNombre() {
	return nombre;
}

public String getImagenesBack(int n) {
	String imgBack="";
	
	int sum = 0;
    
    Iterator<String> it = this.imagenesBack.iterator();
  
    while (it.hasNext()){
    	
    	
    	imgBack = it.next();
    	
    	sum++;
    
    	if(n == sum){
    		break;
    	}
    	
    }
    	
	return imgBack;
}
    
	



public Collection<String> getImagenesBack() {
	return imagenesBack;
}


public void recibirDanio(Integer ataque){
		
	if(this.hp> 0) {
		if(ataque< this.defence) {
			this.hp--;
		}else {
			this.hp -= (ataque-this.defence);
		}
		
	}else {
		System.out.println("El pokemon esta inconciente y no puede pelear");
	}
	
}

public void recibirDanioSpecial(Integer ataque){
	
	if(this.hp> 0) {
		if(ataque< this.specialDefence) {
			this.hp--;
		}else {
			this.hp -= (ataque-this.specialDefence);
		}
		
	}else {
		System.out.println("El pokemon esta inconciente y no puede pelear");
	}
	
	
}

public int cantidadImgBack() {
	
	
	
	
	return this.imagenesBack.size();
	
}



public static List<String> cargarImagenesFront(PokeApi p){
	List<String> img = new ArrayList<>();
	img.add(p.sprites.other.home.frontShiny);
	img.add(p.sprites.other.home.frontDefault);
	img.add((String) p.sprites.other.home.frontFemale);
	img.add((String) p.sprites.other.home.frontShinyFemale);
	img.add(p.sprites.other.officialArtwork.frontDefault);
	img.add( p.sprites.versions.generationI.redBlue.frontDefault);
	img.add( p.sprites.versions.generationI.redBlue.frontGray);
	img.add( p.sprites.versions.generationI.redBlue.frontTransparent);
	img.add( p.sprites.versions.generationI.yellow.frontDefault);
	img.add( p.sprites.versions.generationI.yellow.frontGray);
	img.add( p.sprites.versions.generationI.yellow.frontTransparent);
	img.add( p.sprites.versions.generationIi.crystal.frontDefault);
	img.add( p.sprites.versions.generationIi.crystal.frontShiny);
	img.add( p.sprites.versions.generationIi.crystal.frontShinyTransparent);
	img.add( p.sprites.versions.generationIi.crystal.frontTransparent);
	img.add( p.sprites.versions.generationIi.gold.frontDefault);
	img.add( p.sprites.versions.generationIi.gold.frontShiny);
	img.add( p.sprites.versions.generationIi.gold.frontTransparent);
	img.add( p.sprites.versions.generationIi.silver.frontDefault);
	img.add( p.sprites.versions.generationIi.silver.frontShiny);
	img.add( p.sprites.versions.generationIi.silver.frontTransparent);
	img.add(p.sprites.versions.generationIii.emerald.frontDefault);
	img.add(p.sprites.versions.generationIii.emerald.frontShiny);
	img.add(p.sprites.versions.generationIii.fireredLeafgreen.frontDefault);
	img.add(p.sprites.versions.generationIii.fireredLeafgreen.frontShiny);
	img.add(p.sprites.versions.generationIii.rubySapphire.frontDefault);
	img.add(p.sprites.versions.generationIii.rubySapphire.frontShiny);

	img.add( p.sprites.versions.generationIv.diamondPearl.frontDefault);
	img.add( p.sprites.versions.generationIv.diamondPearl.frontShiny);
	img.add( (String) p.sprites.versions.generationIv.diamondPearl.frontFemale);
	img.add( (String) p.sprites.versions.generationIv.diamondPearl.frontShinyFemale);
	
	img.add(p.sprites.versions.generationV.blackWhite.frontDefault);
	img.add(p.sprites.versions.generationV.blackWhite.frontShiny);
	img.add((String) p.sprites.versions.generationV.blackWhite.frontFemale);
	img.add((String) p.sprites.versions.generationV.blackWhite.frontShinyFemale);
	
	img.add((String) p.sprites.versions.generationV.blackWhite.animated.frontDefault);
	img.add((String) p.sprites.versions.generationV.blackWhite.animated.frontShiny);
	img.add((String) p.sprites.versions.generationV.blackWhite.animated.frontFemale);
	img.add((String) p.sprites.versions.generationV.blackWhite.animated.frontShinyFemale);
	
	
	img.add((String) p.sprites.versions.generationVi.omegarubyAlphasapphire.frontDefault);
	img.add((String) p.sprites.versions.generationVi.omegarubyAlphasapphire.frontShiny);
	img.add((String) p.sprites.versions.generationVi.omegarubyAlphasapphire.frontFemale);
	img.add((String) p.sprites.versions.generationVi.omegarubyAlphasapphire.frontShinyFemale);
	
	img.add((String) p.sprites.versions.generationVi.xY.frontDefault);
	img.add((String) p.sprites.versions.generationVi.xY.frontShiny);
	img.add((String) p.sprites.versions.generationVi.xY.frontFemale);
	img.add((String) p.sprites.versions.generationVi.xY.frontShinyFemale);
	
	
	img.add( p.sprites.versions.generationVii.icons.frontDefault);
	img.add( p.sprites.versions.generationVii.ultraSunUltraMoon.frontDefault);
	img.add( p.sprites.versions.generationVii.ultraSunUltraMoon.frontShiny);
	img.add( (String) p.sprites.versions.generationVii.ultraSunUltraMoon.frontFemale);
	img.add( (String) p.sprites.versions.generationVii.ultraSunUltraMoon.frontFemale);
	
	img.add((String) p.sprites.versions.generationViii.icons.frontDefault);
	img.add((String) p.sprites.versions.generationViii.icons.frontFemale);
	
	img.add((String) p.sprites.frontDefault);
	
	img.removeAll(Collections.singletonList(null));
		return img;
		
	
}

public static List<String> cargarImagenesBack(PokeApi p){
List<String> img = new ArrayList<>();

img.add(p.sprites.versions.generationI.redBlue.backDefault);
img.add(p.sprites.versions.generationI.redBlue.backGray);
img.add(p.sprites.versions.generationI.redBlue.backTransparent);
img.add(p.sprites.versions.generationI.yellow.backDefault);
img.add(p.sprites.versions.generationI.yellow.backGray);
img.add(p.sprites.versions.generationI.yellow.backTransparent);
img.add(p.sprites.versions.generationIi.crystal.backDefault);
img.add(p.sprites.versions.generationIi.crystal.backShiny);
img.add(p.sprites.versions.generationIi.crystal.backShinyTransparent);
img.add(p.sprites.versions.generationIi.crystal.backTransparent);
img.add(p.sprites.versions.generationIi.gold.backDefault);
img.add(p.sprites.versions.generationIi.gold.backShiny);
img.add(p.sprites.versions.generationIi.silver.backDefault);
img.add(p.sprites.versions.generationIi.silver.backShiny);
img.add(p.sprites.versions.generationIii.fireredLeafgreen.backDefault);
img.add(p.sprites.versions.generationIii.fireredLeafgreen.backShiny);
img.add(p.sprites.versions.generationIii.rubySapphire.backShiny);
img.add(p.sprites.versions.generationIii.rubySapphire.backShiny);
img.add(p.sprites.versions.generationIv.diamondPearl.backDefault);
img.add(p.sprites.versions.generationIv.diamondPearl.backShiny);
img.add((String) p.sprites.versions.generationIv.diamondPearl.backFemale);
img.add((String) p.sprites.versions.generationIv.diamondPearl.backShinyFemale);
img.add(p.sprites.versions.generationIv.heartgoldSoulsilver.backDefault);
img.add(p.sprites.versions.generationIv.heartgoldSoulsilver.backShiny);
img.add((String) p.sprites.versions.generationIv.heartgoldSoulsilver.backFemale);
img.add((String) p.sprites.versions.generationIv.heartgoldSoulsilver.backShinyFemale);

img.add(p.sprites.versions.generationIv.platinum.backDefault);
img.add(p.sprites.versions.generationIv.platinum.backShiny);
img.add((String) p.sprites.versions.generationIv.platinum.backFemale);
img.add((String) p.sprites.versions.generationIv.platinum.backShinyFemale);

img.add(p.sprites.versions.generationV.blackWhite.backDefault);
img.add(p.sprites.versions.generationV.blackWhite.backShiny);
img.add((String) p.sprites.versions.generationV.blackWhite.backFemale);
img.add((String) p.sprites.versions.generationV.blackWhite.backShinyFemale);

img.add((String) p.sprites.versions.generationV.blackWhite.animated.backDefault);
img.add((String) p.sprites.versions.generationV.blackWhite.animated.backShiny);
img.add((String) p.sprites.versions.generationV.blackWhite.animated.backFemale);
img.add((String) p.sprites.versions.generationV.blackWhite.animated.backShinyFemale);


img.removeAll(Collections.singletonList(null));

return img;
}


}
