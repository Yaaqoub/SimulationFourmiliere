import java.util.Enumeration;

/**
 * Class Soigneur is for instantiate 'Fourmi' of the type 'Soigneur'
 * @author YAAQOUB
 *
 */
public class Soigneur extends Fourmi{
	private boolean active; // that boolean is to know if the Soigneur is on service or not
	public static int soigneursNbr = 1;		// that's for the 'Soigneurs' name
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Soigneur(Fourmiliere f){
		super("Soigneur " + soigneursNbr, 100, 1, f);	// We call Constructor of the class abstart:
														// Soigneur : Name + SoigneurNbr : this int is to give the Anst's number the first one will call Soigneur 1
														// 100 : Life point
														// 1 : speed of the Soigneur
		
		soigneursNbr++;
		active = false;									// i used this boolean so if he is true the ant will move if it's false she will stay in the fourmiliere
	}
	
	public void nouveauCycle(Fourmiliere f){
		
		if (this.isFoActive()){ // if the Ant 'Fourmi' is not supported launch a new cycle
			
			if (this.getActive()){ // if there is any injured ant out there we set the boolean active to true
				
				if (this.isQuitterFourm()){ // if the Ant 'fourmi' is leaving the 'fourmiliere'
					
					if (this.getPosition() < f.getNbrFourmi().get(this.getChoix()).getPosition()) { // if the Soigneur not with the injured Fourmi yet
						
						this.setPosition(this.getPosition() + this.getVitesse()); // we add the Fourmi vitesse to her position so the Soigneur advanced 
						this.setNbCycle(this.getNbCycle() - 1); // loss life point 
						
						System.out.println("La fourmi (" + this.getNomFourmi() + ") avance vers la fourmi (" + f.getNbrFourmi().get(this.getChoix()).getNomFourmi() + ").");
						
					} else { // if the soigneur is with the injured Froumi
						
						System.out.println("La fourmi (" + this.getNomFourmi() + ") recupere la fourmi " + f.getNbrFourmi().get(this.getChoix()).getNomFourmi() + ".");
						
						this.setNbCycle(this.getNbCycle() - 1); // loss lide point
						
						this.setQuitterForm(false); // set that to false again to start over if there is somthing happen
						
					}
					
					if (this.getNbCycle() <= 0) { // if the Soigneur have no life point
						
						f.getNbrFourmi().get(this.getChoix()).setPriseEnCharge(false);	// 					
						this.setIsFoActive(false);
						
					}
				}
				else{
					if (this.getPosition() > 0) { // if the Soigneur not in the fourmiliere
						
						this.setPosition(this.getPosition() - this.getVitesse()); // set the soigneur to return we decrease the vitesse so the position == 0 
						this.setNbCycle(this.getNbCycle() - 1); // loss life point
						
						System.out.println("La fourmi (" + this.getNomFourmi() + ") retourne a la fourmiliere avec la fourmi (" + f.getNbrFourmi().get(this.getChoix()).getNomFourmi() + ").");
						
					}
					else{
						int index = -1;
						
						Enumeration<Integer> eNbFo = f.getNbrFourmi().keys();
						
						while (eNbFo.hasMoreElements()) {
							
							int key = eNbFo.nextElement();
							
							if (f.getNbrFourmi().get(key) == this) {
								
								index = key;
								break;
								
							}
						}
						
						BoiteEvenement.getInstance().ajout(new RecuperationOK(this , index)); // start the event
						this.setQuitterForm(true);
					}
					
					if (this.getNbCycle() <= 0){
						this.setIsFoActive(false);
						
						f.getNbrFourmi().get(this.getChoix()).setPosition(this.getPosition());
						f.getNbrFourmi().get(this.getChoix()).setPriseEnCharge(false);
					}
				}
			}
			else{
				this.setNbCycle(this.getNbCycle() - 1);
				
				if (this.getNbCycle() <= 0) {
					
					System.out.println(this.getNomFourmi() + " est morte");
					
					int index = -1;
					
					Enumeration<Integer> eNbFo = f.getNbrFourmi().keys();
					
					while (eNbFo.hasMoreElements()) {
						
						int key = eNbFo.nextElement();
						
						if (f.getNbrFourmi().get(key) == this) {
							
							index = key;
							break;
							
						}
						
					}
					
					f.getNbrFourmi().remove(index);					
					
				}
			}
		}
		else{
			if (!this.isPriseEnCharge()) { // if the Ant is supported
				
				int index = -1;
				
				Enumeration<Integer> eNbFo = f.getNbrFourmi().keys();
				
				while (eNbFo.hasMoreElements()) {
					
					int key = eNbFo.nextElement();
					
					if (f.getNbrFourmi().get(key) == this) {
						
						index = key;
						break;
						
					}
					
				}
				
				BoiteEvenement.getInstance().ajout(new Blessee(this , index)); // start the event
				
			}
		}
	}
}
