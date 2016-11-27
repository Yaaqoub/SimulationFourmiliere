/**
 * The abstract class who is related to the all ant 'Fourmi' class
 * @author YAAQOUB
 *
 */
public abstract class Fourmi {
	
	private int nbCycle; 				// Ant life points number
	private boolean isFoActive; 		// is the Ant injured or not
	private boolean priseEnCharge; 	 	// supported by the 'Soigneurs' or not
	private int siteChoix;     			// Ant destination choice
	private String nomFourmi;			// Ant name
	private boolean quitterFourm;    	// Ant leave the 'Fourmiliere' or not
	private int vitesse;				// Speed of the Ant 'Fourmi'
	private int position;				// position of the Ant 'Fourmi'
	
	
	
	
	
	
	public boolean isPriseEnCharge(){
		return priseEnCharge;
	}
	
	public void setPriseEnCharge(boolean priseEnCharge){
		this.priseEnCharge = priseEnCharge;
	}
	
	public boolean isFoActive(){
		return isFoActive;
	}
	
	public void setIsFoActive(boolean isFoActive){
		this.isFoActive = isFoActive;
	}
	
	public int getChoix(){
		return siteChoix;
	}
	
	public void setChoix(int siteChoix){
		this.siteChoix = siteChoix;
	}
	
	public String getNomFourmi(){
		return nomFourmi;
	}
	
	public void setNomFourmi(String nomFourmi){
		this.nomFourmi = nomFourmi;
	}
	
	public int getNbCycle(){
		return nbCycle;
	}
	
	public void setNbCycle(int nbCycle){
		this.nbCycle = nbCycle;
	}
	
	public boolean isQuitterFourm(){
		return quitterFourm;
	}
	
	public void setQuitterForm(boolean quitterFourm){
		this.quitterFourm = quitterFourm;
	}
	
	public int getVitesse(){
		return vitesse; 
	}
	
	public void setVitesse(int vitesse){
		this.vitesse = vitesse;
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setPosition(int position){
		this.position = position;
	}
	
	// Constructor of this abstract class, we call this every time we want to build an Ant 'Fourmi'
	public Fourmi(String nomFourmi, int nbCycle, int vitesse, Fourmiliere f){
		this.priseEnCharge = false;
		this.isFoActive = true;
		this.siteChoix = -1;
		this.nbCycle = nbCycle;
		this.nomFourmi = nomFourmi;
		this.vitesse = vitesse;
		this.position = 0;
		this.quitterFourm = true;
		
		f.setIndexFourmi(f.getIndexFourmi() + 1);
	}
	
	public abstract void nouveauCycle(Fourmiliere f);
}

/**
 * soldat
 * 
 * ouvriere
 **/
