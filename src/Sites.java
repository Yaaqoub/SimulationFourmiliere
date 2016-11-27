/**
 * Management of 'SiteNourriture' arrays
 * @author YAAQOUB
 *
 */import java.util.ArrayList;

public class Sites {
	private SiteNourriture[] sites; // create a variable of the type SiteNourriture like table so we set it with sites
	
	public SiteNourriture[] getSites() {
		return sites;
	}

	public void setSites(SiteNourriture[] sites) {
		this.sites = sites;
	}

	public Sites() {
		
		this.sites = InitSites();
	}
	
	private SiteNourriture[] InitSites() { // we use arraylist to stock the site of nourriture
		
		ArrayList<SiteNourriture> sitesArrayList = new ArrayList<>();
		SiteNourriture[] sitesInit;
		
		for (int i=1 ; i<=5 ; i++) { // we creat just 5 because i didn't finish the class exploratrice yet
			
			sitesArrayList.add(new SiteNourriture(i));
		}
		
		sitesArrayList.toArray(sitesInit = new SiteNourriture[sitesArrayList.size()]);
		
		return sitesInit;
	}
}
