/**
 * in this class there is the launcher of the game
 * @author YAAQOUB
 *
 */
public class Lanceur {
	
	public static void main(String[] args){
		Fourmiliere f = new Fourmiliere();
		int i;
		f.setSites(new Sites());
		
		
		for (i=0 ; i<5 ; i++) {
			f.getNbrFourmi().put(f.getIndexFourmi(), new Ouvriere(f));
		}
		
		for (i=0 ; i<3 ; i++) {
			f.getNbrFourmi().put(f.getIndexFourmi(), new Soldat(f));
		}
		
		for (i=0; i < 2; i++){
			f.getNbrFourmi().put(f.getIndexFourmi(), new Soigneur(f));
		}
		
		for (i=0; i < 1; i++){
			f.getNbrFourmi().put(f.getIndexFourmi(), new Exploratrice(f));
		}
		
		for (i = 0; i < 150; i++){
			System.out.println("—– Début d’un nouveau cycle —–");
			for (i=0 ; i < f.getNbrFourmi().size(); i++){
				f.getNbrFourmi().get(i).nouveauCycle(f);
			}
			
			
			
			System.out.println("== Gestion des événements");
			
			// Traitement des événements
			while(!BoiteEvenement.getInstance().estVide()){
				Evenement e = BoiteEvenement.getInstance().getProchainEvenement() ;
				// Ici est traité chaque événement
				System.out.println(e.getMessage());
				e.action(f);
			}
			System.out.println("== Fin des événements");
			System.out.println("—– Fin du cycle —–\n\n");
		}
	}
}
