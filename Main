import MG3D.geometrie.*;
import java.util.ArrayList; 

public class MainPartie1{

	//Méthode qui permet de remplir le tableau d'arêtes.
	//Prend le maillage qu'on étudie en paramètre.	
	public static ArrayList genereArete(Maillage m){
		ArrayList<Arete> tabArete = new ArrayList<Arete>();
		int nbFaces = m.getNbFaces(); //On récupère le nombre de faces du maillage étudié

		for(int i=1; i<=nbFaces-1; i++){ //Pour toutes les faces de m
			Face f = m.getFace(i); //On récupère la face en cours
			int s1 = f.getS1(); //On récupère les indices de ses sommets
			int s2 = f.getS2();
			int s3 = f.getS3();

			if(!tabArete.contains(new Arete(s1,s2))){ //Si l'arête s1,s2 n'est pas dans le tableau, on l'ajoute
				tabArete.add(new Arete(s1,s2));
			}
			if(!tabArete.contains(new Arete(s1,s3))){ //Si l'arête s1,s3 n'est pas dans le tableau, on l'ajoute
				tabArete.add(new Arete(s1,s3));
			}
			if(!tabArete.contains(new Arete(s2,s3))){ //Si l'arête s2,s3 n'est pas dans le tableau, on l'ajoute
				tabArete.add(new Arete(s2,s3));
			}		
			
		}
		return tabArete; //On retourne le tableau d'arêtes
	}

	//Méthode qui permet de vérifier si la figure est fermée ou non
	//Renvoie true si elle est fermée, false sinon
	public static boolean verifFigureFermee(Maillage m){
		ArrayList<Arete> tab = genereArete(m);
		int nbSommets = m.getNbSommets(); //On récupère le nombre de sommets du maillage
		int nbFaces = m.getNbFaces(); //On récupère le nombre de faces du maillage
		int nbAretes = tab.size(); //On récupère le nombre d'arêtes du maillage
		if(nbSommets - nbAretes + nbFaces == 2){ //Théorème de Descartes-Euler
			return true;
		}else{
			return false;
		}
	}

	//Méthode qui permet de vérifier si un rayon intersecte un triangle
	public static boolean MollerTrumbore(Point3D origineRayon, Vecteur3D rayon, Sommet sommet0, Sommet sommet1, Sommet sommet2){
		double EPSILON = 0.0000001;
		
		//On récupère les coordonnées du sommet0
		double s0X = sommet0.getX();
		double s0Y = sommet0.getY();
		double s0Z = sommet0.getZ();

		//On récupère les coordonnées du sommet1
		double s1X = sommet1.getX();
		double s1Y = sommet1.getY();
		double s1Z = sommet1.getZ();

		//On récupère les coordonnées du sommet2
		double s2X = sommet2.getX();
		double s2Y = sommet2.getY();
		double s2Z = sommet2.getZ();

		//On créé 3 points avec les coordonnées des sommets 
		Point3D pointS0 = new Point3D(s0X,s0Y,s0Z);
		Point3D pointS1 = new Point3D(s1X,s1Y,s1Z);
		Point3D pointS2 = new Point3D(s2X,s2Y,s2Z);

		//On créé 2 vecteurs avec ces points
		Vecteur3D arete1 = new Vecteur3D(pointS0,pointS1);
		Vecteur3D arete2 = new Vecteur3D(pointS0,pointS2);

		//On fait le produit vectoriel de rayon avec arete2
		Vecteur3D h = rayon.produitVectoriel(arete2);
		//On fait le produit scalaire de arete1 avec h
		double a = arete1.produitScalaire(h);

		if(a>-1*EPSILON && a<EPSILON){
			return false;
		}

		//Création de nouvelles variables (suivre algorithme du sujet) 
		double f = 1/a;
		Vecteur3D s = new Vecteur3D(pointS0,origineRayon);
		double prodScalaireFetH = s.produitScalaire(h);
		double u = f*prodScalaireFetH;

		if(u<0 || u>1){
			return false;
		}

		//Création de nouvelles variables (suivre algorithme du sujet) 
		Vecteur3D q = s.produitVectoriel(arete1);
		double prodScalaireRetQ = rayon.produitScalaire(q);
		double v = f*prodScalaireRetQ;

		if(v<0 || u+v>1){
			return false;
		}

		//Création de nouvelles variables (suivre algorithme du sujet) 
		double prodScalaireA2etQ = arete2.produitScalaire(q);
		double t = f*prodScalaireA2etQ;

		if(t>EPSILON && t<(1-EPSILON)){
			return true;
		}

		return false;
	}

	//Méthode qui permet de vérifier si la figure comporte des auto-intersections
	//Retourne true si elle en comporte une, false sinon
	public static boolean autoIntersection(Maillage m){
		ArrayList<Arete> tabArete = genereArete(m);
		for(int i=0; i<=tabArete.size()-1; i++){ //Pour toutes les arêtes de m
			Arete areteEnCours = tabArete.get(i); //On récupère l'arete qu'on est en train d'étudier
			int indiceS1 = areteEnCours.getS1(); // On récupère les indices de ses sommets
			int indiceS2 = areteEnCours.getS2();
			Sommet s1 = m.getSommet(indiceS1); //On créé maintenant un sommet à partir de l'indice 
			double s1X = s1.getX(); //On récupère les coordonnées 
			double s1Y = s1.getY();
			double s1Z = s1.getZ();
			Point3D origineRayon = new Point3D(s1X,s1Y,s1Z); //On créé origineRayon qui est un point formé avec les 3 coordonnées de s1
			Sommet s2 = m.getSommet(indiceS2); //Même processus que pour s1
			double s2X = s2.getX();
			double s2Y = s2.getY();
			double s2Z = s2.getZ();
			Point3D pointIndice2 = new Point3D(s2X,s2Y,s2Z);
			Vecteur3D rayon = new Vecteur3D(origineRayon,pointIndice2); //On créé le vecteur rayon qui part du point origineRayon et qui arrive au pointIndice2
			for(int j=0; j<=m.getNbFaces()-1; j++){ //Pour toutes les faces de ù
				Face f = m.getFace(j); //On récupère la face en cours
				int indiceS1Face = f.getS1(); //On récupère les indices de ses sommets
				int indiceS2Face = f.getS2();
				int indiceS3Face = f.getS3();
				Sommet sommet0 = m.getSommet(indiceS1Face); //On créé des sommets à partir des indices
				Sommet sommet1 = m.getSommet(indiceS2Face);
				Sommet sommet2 = m.getSommet(indiceS3Face);
				boolean molTrumb = MollerTrumbore(origineRayon, rayon, sommet0, sommet1, sommet2); //On appelle la méthode MollerTrumbore (qui renvoie un booléen)
					if(molTrumb){ //Si la méthode MollerTrumbore retourne true, on retourne true
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args){

		if(args.length!=1){
			System.out.println("usage : java MainPartie1 fichier.off");
			System.exit(0);
		}
		String fichier=args[0];
	
		Maillage m = new Maillage(fichier); //Maillage à étudier
		boolean figureFermee = verifFigureFermee(m); //Appel de la méthode qui vérifie si la figure est fermée
		boolean intersection = autoIntersection(m); //Appel de la méthode qui vérifie si la figure comporte une auto-intersection

		if(!figureFermee){ //Si la figure n'est pas fermée
			System.out.println("Le maillage triangulaire n'est pas imprimable car la surface n'est pas fermée");
		}else if(intersection){ //Si la figure comporte au moins une auto/intersection
			System.out.println("Le maillage triangulaire n'est pas imprimable car il présente au moins une auto-intersection");
		}else if(!figureFermee && intersection){ //Si la figure n'est pas fermée et qu'elle comporte au moins  une auto-intersection
			System.out.println("Le maillage triangulaire n'est pas imprimable car la surface n'est pas fermée et il présente au moins une auto intersection");
		}else{ //Si la figure est fermée et sans auto-intersection
			System.out.println("Le maillage triangulaire est imprimable");
		}

	}

}
