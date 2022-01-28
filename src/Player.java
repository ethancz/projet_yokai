import java.util.ArrayList;
public class Player {
    
    private String nom;
    private ArrayList<YokaiClue> indices;
  
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public ArrayList<YokaiClue> getIndices(){
        return this.indices;
    }

    public void setIndices(ArrayList<YokaiClue> indices){
        this.indices = indices;
    }

}