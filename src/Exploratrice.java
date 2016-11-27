/**
 * Class Exploratrice is for instantiate 'Fourmi' of the type 'Exploratrice'
 * @author YAAQOUB
 *
 */
public class Exploratrice extends Fourmi{
	public static int ExploratriceNbr = 1;  // that's for the 'Exploratrice' name
	public Exploratrice (Fourmiliere f){
		super("Exploratrice " + ExploratriceNbr, 100, 1, f); 	// We call Constructor of the class abstart:
																// Exploratrice : Name + ExploratriceNbr : this int is to give the Anst's number the first one will call Exploratrice 1
																// 100 : Life point
																// 1 : speed of the Exploratrice
		
		ExploratriceNbr++;
	}
	
	@Override
	public void nouveauCycle(Fourmiliere f){
		
		if (this.isFoActive()){
			
			if(this.isQuitterFourm()){
				
				if(this.getPosition() == 0){
					
				}
				else if (this.getPosition() > 0 && this.getPosition() < f.getSites().getSites()[this.getChoix()].getDistance()) {
					
				}
				else{
					
				}
			}
			else{
				
				if (this.getPosition() <= f.getSites().getSites()[this.getChoix()].getDistance() && this.getPosition() > 0){
					
				} 
				else {
					
					this.setQuitterForm(true); 
					this.setPosition(0);	
					this.setNbCycle(this.getNbCycle() - 1);
				}
				
			}
		}
		else {
			
			if (!this.isPriseEnCharge()) {
					
			}
		}
	}
}
