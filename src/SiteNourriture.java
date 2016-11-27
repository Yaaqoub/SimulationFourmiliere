/**
 * Management of the 'SiteNourriture'
 * @author YAAQOUB
 *
 */
public class SiteNourriture {
	private int quantite; // amount of food in the SiteNourriture
	private int distance; // distance to the Site
	private String nom; // name of the site
	
	private static int siteNbr = 1; // we use that to give site name like : site 1, site 2 // we set it to one
	
	public int getQuantite(){
		return quantite;
	}
	
	public void setQuantite(int quantite){
		this.quantite = quantite;
	}
	
	public int getDistance(){
		return distance;
	}
	
	public void setDistance(int distance){
		this.distance = distance;
	}
	
	public String getNom(){
		return nom;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public SiteNourriture(int distance){
		this.nom = ("Site " + siteNbr); // the first name is Site 1
		this.distance = distance; // we set the distance here
		this.quantite = 200; // every site of the nourriture have 200 amount of food
		siteNbr++; // increase the site number so it will be site 1 / site 2 / ...
	}
}
