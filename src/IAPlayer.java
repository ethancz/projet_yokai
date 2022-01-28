public class IAPlayer extends Player{
    private int niveauIA;

    IAPlayer(String nom){
       this.setNom(nom);
    }
    public int getNiveauIA(){
        return this.niveauIA;
    }

    public void setNiveauIA(int niveauIA){
        this.niveauIA = niveauIA;
    }
}
