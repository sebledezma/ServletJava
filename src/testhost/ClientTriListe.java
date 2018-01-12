package testhost;

public class ClientTriListe {
	private int[] liste=null;

	private ClientTriListe(int[] liste) {
		super();
		this.liste = liste;
	}

	public static void main(String[] args) {
		int[] l = {1,20,5,8,7,9,14,3,6,5,2,1,4,6,3,8,7};

		ClientTriListe.afficheTableauInt(new ClientTriListe(l).triFusionJava());
	}

	public static void afficheTableauInt(int[] l) {
		for (int i : l) {

			System.out.print(i+" - ");
		}
		//System.out.println("\nfin");
	}

	public int[] triFusionJava() {
		int taille = liste.length;
		int[] rep;
		if (taille > 1) {
			int moitie = taille/2;
			int[] lDeb = decoupe(0, moitie-1);
			lDeb=new ClientTriListe(lDeb).triFusionJava();
			int[] lFin = decoupe(moitie, taille-1);
			lFin=new ClientTriListe(lFin).triFusionJava();
			rep = fusion(lDeb, lFin);
		}
		else {
			rep = new int[1];
			rep[0] = liste[0];
		}
		return rep;
	}

	private int[] fusion(int[] lDeb, int[] lFin) {
		int[] rep = new int[lDeb.length+lFin.length];
		int indiceDeb = 0;
		int indiceFin = 0;
		boolean lDebVide = false;
		boolean lFinVide = false;
		int indice = 0;
		while (!lDebVide || !lFinVide) {
			if (lFinVide || (!lDebVide && lDeb[indiceDeb]<lFin[indiceFin])) {
				rep[indice++] = lDeb[indiceDeb++];
				lDebVide = (indiceDeb==lDeb.length);
			}
			else {
				rep[indice++]=lFin[indiceFin++];
				lFinVide= (indiceFin==lFin.length);
			}
		}
		return rep;
	}

	private int[] decoupe(int debut, int fin) {
		int[] rep = new int[fin-debut+1];
		int i=0;
		for (int j = debut; j <= fin; j++) {
			rep[i++]= liste[j];
		}
		return rep;
	}
}