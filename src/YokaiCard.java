public class YokaiCard {
    private YokaiEnum nom;
    private Position position;
    private YokaiClue indice;

    YokaiCard(YokaiEnum nom){
        this.nom = nom;
        this.position = new Position(0,0);
    }

    public YokaiEnum getNom(){
        return this.nom;
    }

    public void setNom(YokaiEnum nom){
        this.nom = nom;
    }

    public Position getPosition(){
        return this.position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public YokaiClue getIndice(){
        return this.indice;
    }

    public void setIndice(YokaiClue indice){
        this.indice = indice;
    }
}
