class Arete{
    //Attributs
    private int s1;
    private int s2;

    //Constructeur par défaut
    public Arete(){
	s1 = 0;
	s2 = 1;
    }

    //Constructeur qui prend 2 indices de sommet pour créer une arête
    public Arete(int s1, int s2){
	this.s1 = s1;
	this.s2 = s2;
    }

    //Constructeur par copie
    public Arete(Arete a){
	this.s1 = a.s1;
	this.s2 = a.s2;
    }

    //Retourne l'indice du premier sommet
    public int getS1(){
	return s1;
    }

    //Retourne l'indice du deuxième sommet
    public int getS2(){
	return s2;
    }

    //Permet de modifier la valeur de l'indice du sommet s1
    public void setS1(int s1){
	this.s1 = s1;
    }

    //Permet de modifier la valeur de l'indice du sommmet s2
    public void setS2(int s2){
	this.s2 = s2;
    }

    //Retourne une description de l'arête
    //La chaîne de caractères est donnée sous la forme: (s1,s2)
    public String toString(){
	return "("+getS1()+","+getS2()+")";
    }

    //Permet de comparer deux arêtes
    //La méthode retourne vrai si les indices des deux sommets sont les mêmes
    public boolean equals(Object obj){
	if(this == obj)
	    return true;
	if (obj == null)
	    return false;
	if(getClass() != obj.getClass())
	    return false;
	Arete other = (Arete) obj;
	return ((s1==other.s1 && s2==other.s2) || (s1==other.s2 && s2==other.s1));
    }
}
