import java.util.ArrayList;

public class BoiteEvenement {
	private static BoiteEvenement instance = null;
	private ArrayList <Evenement> boite;
	
	private BoiteEvenement () {
		boite =new ArrayList<>();
	}
	
	boolean estVide(){
		return boite.isEmpty();
	}
	
	void ajout(Evenement e){
		boite.add(e);
	}
	
	Evenement getProchainEvenement (){
		Evenement e = boite.get(0);
		boite.remove(0);
		return e;
	}
	static BoiteEvenement getInstance(){
		if (instance == null){
			instance = new BoiteEvenement();
		}
		return instance;
	}
}
