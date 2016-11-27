/**
 * Management of 'Blessee'
 * @author YAAQOUB
 *
 */
import java.util.Enumeration;

public class Blessee extends Evenement{
	
	private int index;
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public Blessee(Fourmi expediteur , int index) {
		
		super("La fourmi " + expediteur.getNomFourmi() + " est blessee", expediteur); // call the constructor of the class abstract
		
		this.index = index;
		
	}
	@Override
	public void action(Fourmiliere f){
		Enumeration<Integer> eNbFo = f.getNbrFourmi().keys();
		
		while (eNbFo.hasMoreElements()) {
			
			int key = eNbFo.nextElement();
			
			if (f.getNbrFourmi().get(key) instanceof Soigneur) { // we use instanceof to know if that object is an anstance of the class Soigneur
				
				if (!((Soigneur) f.getNbrFourmi().get(key)).getActive()) {
					
					f.getNbrFourmi().get(key).setChoix(this.getIndex());
					((Soigneur) f.getNbrFourmi().get(key)).setActive(true); // set the active true so the soigneur will be in service Look the class Soigneur
					this.getExpediteur().setPriseEnCharge(true); // we set the injured ant to Prise en charge active (true)
					
					break;
					
				}
				
			}
			
		}
	}
}
