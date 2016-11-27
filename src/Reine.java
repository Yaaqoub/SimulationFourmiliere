/**
 * Class Reine is for instantiate 'Fourmi' of the type 'Reine'
 * @author YAAQOUB
 *
 */
public class Reine extends Fourmi{
	private int cycleNaissance = 0; // Manage the birth cycle 
	
	public int getCycleNaissance(){
		return cycleNaissance;
	}
	
	public void setCycleNaissance(int cycleNaissance){
		this.cycleNaissance = cycleNaissance;
	}
	
	
	// Reine constructor
	public Reine(Fourmiliere f){
		super ("Reine ", 999999, 0, f); // We call Constructor of the class abstart:
										// Reine : Name
										// 999999 : Life point, it is not important really because the  Reine is immortal
										// 0 : speed of the rein, the Reine is not moving
		
		this.cycleNaissance = 0;		// every cycle of the game this variable incremented
	}
	
	@Override
	public void nouveauCycle(Fourmiliere f){
		cycleNaissance++; // increments the birth cycle
		
		if (cycleNaissance == 5){ // if the 'CycleNaissance' is 5
			cycleNaissance = 0; // we set 'CycleNaissance' to 0 to start over
			Evenement e = new Naissance(this); // we create an new Naissance event
			System.out.println("La reine donne naissance a de nouvelles fourmis"); // that one is like Comment :D
			BoiteEvenement.getInstance().ajout(e);
		}
		
		if (f.getNourritureQuantite() > 0) {	// if there is still food in the Fourmiliere
			
			f.setNourritureQuantite(f.getNourritureQuantite() - 1);	// Ant eat from it
			
		}
		// the Reine immortal so she don t loss life point if there is no food in the fourmiliere
	}
}
