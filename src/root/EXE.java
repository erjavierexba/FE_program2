package root;

import java.io.IOException;
import java.util.List;

public class EXE {
	public static void main(String[] args) throws IOException {
	
	List<Enemy> res = Enemy_Utility.generaEjercitoEnemigo();
		Enemy_Utility.guardaEjercitoTXT(res);
		//d
	}
	

}
