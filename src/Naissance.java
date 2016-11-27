/**
 * Management of 'Naissance'
 * @author YAAQOUB
 *
 */
public class Naissance extends Evenement{
	
	
	public Naissance(Fourmi expediteur) {
		super("Dix nouvelles fourmis viennent dans la fourmiliere", expediteur); //call the constructor of the class abstract
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Fourmiliere f){
		
		int i;
		
		for (i = 0; i < 5; i++){
			f.getNbrFourmi().put(f.getIndexFourmi(), new Ouvriere(f)); // create 5 Ouvriere
		}
		
		for (i = 0; i < 2; i++){
			f.getNbrFourmi().put(f.getIndexFourmi(), new Soldat(f)); // create 2 Soldat
		}

		for (i = 0; i < 2; i++){
			f.getNbrFourmi().put(f.getIndexFourmi(), new Soigneur(f)); // create 2 Soigneur
		}

		for (i = 0; i < 1; i++){
			f.getNbrFourmi().put(f.getIndexFourmi(), new Exploratrice(f)); // create 1 Exploratrice
		}
	}
}
