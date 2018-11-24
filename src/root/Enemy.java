package root;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Enemy {
	private Clase clase;
	private String nombre;
	private final Integer[] gR = {80, 70, 65, 60, 50, 35, 25, 20};
	private List<Proficiencies> prof;
	//puntos de vida, fuerza, magia,defensa,resistencia, habilidad, suerte, nivel, movimiento, constitucion, alcance de visión
	private Integer pv,str,mag,def,res,skl,spd,luk,nivel, mov,constitution, los;
	private Integer[] growthRate;
	
	public Enemy(Clase c, Integer nv, String nombre, Boolean growthRandom, Integer[] growthRates) {
		this.clase = c;
		this.nombre= nombre;
		this.growthRate = new Integer[8];
		
		if(growthRandom) {
			
			Integer[] var = parametrosAleatorios();
			for(int i =0; i< gR.length;i++) {
				this.growthRate[i] = var[i];
			}
		}else {
			for(int i =0; i< gR.length;i++) {
				this.growthRate[i] = growthRates[i];
			}
		}
		this.nivel = nv;
		generaPersonaje();
	}

	private void generaPersonaje() {
	statsIniciales();
	for(int i =1; i<nivel ; i++) {
		lvlup();
	}
	}

	private void lvlup() {
		Random t = new Random();
		if(growthRate[0]>= t.nextInt(100))  pv++;
		if(growthRate[1]>= t.nextInt(100)) 	str++;	
		if(growthRate[2]>= t.nextInt(100)) 	mag++;
		if(growthRate[3]>= t.nextInt(100)) 	def++;
		if(growthRate[4]>= t.nextInt(100))  res++;
		if(growthRate[5]>= t.nextInt(100)) 	skl++;	
		if(growthRate[6]>= t.nextInt(100)) 	spd++;
		if(growthRate[7]>= t.nextInt(100)) 	luk++;
		
	}


	private  Integer[] parametrosAleatorios() {
		List<Integer> res =  new LinkedList<Integer>();
		Integer[] res2 = new Integer[gR.length];
		for(int i = 0; i<gR.length;i++) {
			res.add(gR[i]);
		}
		Collections.shuffle(res);
		for(int i = 0; i<gR.length;i++) {
			res2[i] =res.get(i);
		}
		return res2;
	}
	public String ToString() {
		return "Name: "+nombre + ", Class: "+ clase.toString()+" Stats:    Nivel: "+nivel+" PV:  "+ pv+"    STR: "+str+ "    MAG: "+ mag 
				+ "DEF: "+ def + " RES: "+ res+ "   SKL: "+ skl+ "    SPD: "+ spd + "   LUK: "+ luk + "   MOV: "+ mov+ "   CON: "+ constitution + "  LoS: "+ los
				+ "\nProficiencies:  "+ prof.toString();
	}

	public Map<String, Integer> dameStats(){
		Map<String, Integer> stats = new HashMap<String, Integer>();
		stats.put("Clase", claseToIndex());
		stats.put("Nivel", nivel);
		stats.put("HP", pv);
		stats.put("STR", str);
		stats.put("MAG", mag);
		stats.put("DEF", def);
		stats.put("RES", res);
		stats.put("SkL", skl);
		stats.put("SPD", spd);
		stats.put("LUK", luk);
		return stats;
	}
	public Clase indexToClase(Integer r) {
		Clase c = Clase.values()[r];
		return c;
	}
	private Integer claseToIndex() {
		Integer res = -1;
for(int i =0;i< Clase.values().length;i++) {
	if(Clase.values()[i].equals(clase)) res= i;
}
		return res;
	}

	private void statsIniciales() {
		prof= new LinkedList<Proficiencies>();
		switch(clase) {
		case Archer:
			pv = 17;
			str = 6;
			mag = 0;
			def = 4;
			res = 3;
			skl = 9;
			spd = 7;
			luk = 5;
			mov = 6;
			constitution = 6;
			los = 4;
			prof.add(Proficiencies.Bow);
			break;
		case Bard:
			pv = 17;
			str = 2;
			mag = 3;
			def = 1;
			res = 5;
			skl = 6;
			spd = 6;
			luk = 11;
			mov = 6;
			constitution = 5;
			los = 4;
			prof.add(Proficiencies.Knife);
			break;
		case Brigand:
			pv = 27;
			str = 10;
			mag = 0;
			def = 1;
			res = 1;
			skl = 3;
			spd = 4;
			luk = 6;
			mov = 5;
			constitution = 11;
			los = 4;
			prof.add(Proficiencies.Axe);
			break;
		case Cavalier:
			pv = 18;
			str = 7;
			mag = 0;
			def = 7;
			res = 1;
			skl = 5;
			spd = 8;
			luk = 3;
			mov = 8;
			constitution = 18;
			los = 4;
			//Selecciona 1
			prof.add(Proficiencies.Axe);
			prof.add(Proficiencies.Lance);
			prof.add(Proficiencies.Sword);
			break;
		case Cleric:
			pv = 16;
			str = 1;
			mag = 5;
			def = 3;
			res = 9;
			skl = 5;
			spd = 6;
			luk = 6;
			mov = 6;
			constitution = 6;
			los = 4;
			prof.add(Proficiencies.Light);
			prof.add(Proficiencies.Staff);
			break;
		case Druid:
			pv = 20;
			str = 3;
			mag = 9;
			def = 4;
			res = 7;
			skl = 3;
			spd = 4;
			luk = 2;
			mov = 5;
			constitution = 7;
			los = 4;
			prof.add(Proficiencies.Dark);
			break;
		case Fighter:
			pv = 24;
			str = 9;
			mag = 0;
			def = 3;
			res = 2;
			skl = 5;
			spd = 5;
			luk = 3;
			mov = 6;
			constitution = 9;
			los = 4;
			prof.add(Proficiencies.Axe);
			break;
		case Knight:
			pv = 21;
			str = 9;
			mag = 0;
			def = 12;
			res = 0;
			skl = 5;
			spd = 3;
			luk = 2;
			mov = 5;
			constitution = 15;
			los = 4;
			prof.add(Proficiencies.Lance);
			break;
		case L_Cat:
			pv = 22;
			str = 5;
			mag = 0;
			def = 3;
			res = 2;
			skl = 7;
			spd = 8;
			luk = 4;
			mov = 6;
			constitution = 10;
			los = 5;
			prof.add(Proficiencies.Fang);
			break;
		case L_Hawk:
			pv = 24;
			str = 6;
			mag = 0;
			def = 5;
			res = 1;
			skl = 5;
			spd = 6;
			luk = 3;
			mov = 7;
			constitution = 8;
			los = 5;
			prof.add(Proficiencies.Talon);
			break;
		case L_Heron:
			pv = 15;
			str = 1;
			mag = 5;
			def = 1;
			res = 7;
			skl = 4;
			spd = 5;
			luk = 12;
			mov = 6;
			constitution = 5;
			los = 5;
			prof.add(Proficiencies.NONE);
			break;
		case L_Raven:
			pv = 18;
			str = 4;
			mag = 0;
			def = 3;
			res = 3;
			skl = 8;
			spd = 9;
			luk = 5;
			mov = 7;
			constitution = 6;
			los = 5;
			prof.add(Proficiencies.Beak);
			break;
		case L_Tiger:
			pv = 25;
			str = 7;
			mag = 0;
			def = 6;
			res = 2;
			skl = 4;
			spd = 5;
			luk = 3;
			mov = 6;
			constitution = 13;
			los = 4;
			prof.add(Proficiencies.Claw);
			break;
		case Mage:
			pv = 15;
			str = 1;
			mag = 7;
			def = 1;
			res = 8;
			skl = 8;
			spd = 6;
			luk = 3;
			mov = 6;
			constitution = 5;
			los = 4;
			//Selecciona 2
			prof.add(Proficiencies.Fire);
			prof.add(Proficiencies.Thunder);
			prof.add(Proficiencies.Wind);
			break;
		case Mercenary:
			pv = 18;
			str = 7;
			mag = 0;
			def = 5;
			res = 2;
			skl = 8;
			spd = 7;
			luk = 4;
			mov = 6;
			constitution = 8;
			los = 4;
			prof.add(Proficiencies.Sword);
			break;
		case Myrmidon:
			pv = 16;
			str = 6;
			mag = 0;
			def = 2;
			res = 2;
			skl = 10;
			spd = 9;
			luk = 6;
			mov = 6;
			constitution = 6;
			los = 4;
			prof.add(Proficiencies.Sword);
			break;
		case Nomad:
			pv = 18;
			str = 6;
			mag = 0;
			def = 3;
			res = 2;
			skl = 6;
			spd = 10;
			luk = 4;
			mov = 8;
			constitution = 14;
			los = 4;
			prof.add(Proficiencies.Bow);
			break;
		case Pegasus_Knight:
			pv = 16;
			str = 6;
			mag = 0;
			def = 4;
			res = 5;
			skl = 5;
			spd = 10;
			luk = 3;
			mov = 8;
			constitution = 16;
			los = 5;
			prof.add(Proficiencies.Lance);
			break;
		case Soldier:
			pv = 17;
			str = 7;
			mag = 0;
			def = 6;
			res = 3;
			skl = 6;
			spd = 6;
			luk = 6;
			mov = 6;
			constitution = 8;
			los = 4;
			prof.add(Proficiencies.Lance);
			break;
		case Thief:
			pv = 15;
			str = 4;
			mag = 0;
			def = 1;
			res = 1;
			skl = 8;
			spd = 15;
			luk = 6;
			mov = 7;
			constitution = 5;
			los = 6;
			prof.add(Proficiencies.Knife);
			break;
		case Wyvern_Rider:
			pv = 20;
			str = 9;
			mag = 0;
			def = 9;
			res = 0;
			skl = 4;
			spd = 5;
			luk = 2;
			mov = 8;
			constitution = 24;
			los = 5;
			prof.add(Proficiencies.Lance);
			break;
		case ERROR:
			System.out.println("Detectada clase ERROR");
			break;
		default:
			break;
		}
	}

}
