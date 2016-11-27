/**
 * abstract class to manage the Event
 * @author YAAQOUB
 *
 */
public abstract class Evenement {
	private String message; //
	private Fourmi expediteur;
	
	public String getMessage() {
		return message;
	}
	
	Fourmi getExpediteur() {
		return expediteur;
	}

	void setExpediteur(Fourmi expediteur) {
		this.expediteur = expediteur;
	}
	
	public Evenement(String message , Fourmi expediteur) {		
		this.message = message;
		this.expediteur = expediteur;
	}
	
	public abstract void action(Fourmiliere f);
}
