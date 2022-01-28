import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class YokaiGame {
    private Board tableaudejeu;
    private Player[] joueurs;
    Scanner scanner = new Scanner(System.in);
    private int joueur = 0;
    private Player joueuractuel;
    private int niveaudujeu;

    public void initialiserpartie(){

        this.joueurs = new Player[2];
        this.niveaudujeu = 2;
       
        this.tableaudejeu = new Board();
    }

    public void jouerpartie(){
      
        while(true){
            this.initialiserpartie();

            while(true){
              if(!this.demarrermanche()){
                  break;
              }
            }
               
          if(!this.rejouer()){
              System.exit(0);
          }
        }
    
    }

    public boolean demarrermanche(){
        if(joueur == 0){
            joueuractuel = joueurs[1];
            joueur = 1;
        }else{
            joueuractuel = joueurs[0];
            joueur = 0;
        }
        if (this.demandersilesyokaissesontapaises()) {
            this.gererfindepartie();
            return false;
        } else {
            this.montrerdeuxcartes();
            this.changerpositioncarte();
            // this.utiliserindiceouchoisirindice();
            return true;
        }
    }

    public void montrerdeuxcartes(){
        System.out.println("Coordonnées de la carte n1 ?");
        System.out.println("x ?");
        int x = scanner.nextInt();
        System.out.println("y ?");
        int y = scanner.nextInt();
        for(int boucle = 0; boucle < this.tableaudejeu.getCartes().length;boucle ++){
            
            if(x == this.tableaudejeu.getCartes()[boucle].getPosition().getX() && y == this.tableaudejeu.getCartes()[boucle].getPosition().getY()){
                System.out.println("La première carte que vous avez demandée est un: " + this.tableaudejeu
                        .getCartes()[boucle].getNom());

            }
        }
        System.out.println("Coordonnées de la carte n2 ?");
        System.out.println("x ?");
        x = scanner.nextInt();
        System.out.println("y ?");
        y = scanner.nextInt();
        for (int boucle = 0; boucle < this.tableaudejeu.getCartes().length; boucle++) {
            if (x == this.tableaudejeu.getCartes()[boucle].getPosition().getX()
                    && y == this.tableaudejeu.getCartes()[boucle].getPosition().getY()) {
                System.out.println("La deuxieme carte que vous avez demandée est un: " + this.tableaudejeu
                        .getCartes()[boucle].getNom());

            }
        }
        
    }

    public void changerpositioncarte(){
        System.out.println("Quelle carte voulez-vous bouger ?");
        System.out.println("x ?");
        int x = scanner.nextInt();
        System.out.println("y ?");
        int y = scanner.nextInt();

        System.out.println("A quelle position voulez-vous bouger la carte ?");

        System.out.println("x ? ");
        int positionx = scanner.nextInt();
        System.out.println("y ? ");
        int positiony = scanner.nextInt();

        this.validerchangementpositioncarte(x,y,positionx,positiony);
    }

    public void validerchangementpositioncarte(int x, int y, int positionx, int positiony){
        for(int boucle = 0;boucle<this.tableaudejeu.getCartes().length;boucle++){
            if(x == this.tableaudejeu.getCartes()[boucle].getPosition().getX() && y == this.tableaudejeu.getCartes()[boucle].getPosition().getY()){
                Board nouveauBoard = this.tableaudejeu;
                nouveauBoard.getCartes()[boucle].setPosition(new Position(positionx, positiony));
                this.setTableaudejeu(tableaudejeu);
                break;
            }
        }
    }

    public void utiliserindiceouchoisirindice(){
        System.out.println("Voulez-vous utiliser votre indice (0) ou un choisir un de la pioche (1)?");
        int useClue = scanner.nextInt();
        if(useClue == 0){

            System.out.println("Vous pouvez utiliser les indices suivants: ");
            for(int boucle = 0; boucle<joueurs[joueur].getIndices().size();boucle++){
                System.out.println(boucle +"  " +  joueurs[joueur].getIndices().get(boucle).getFamille());
            }

            int indiceChoisi = scanner.nextInt();
            System.out.println("Sur quelle position voulez-vous mettre l'indice ?");
            System.out.println("x ?");
            int x = scanner.nextInt();
            System.out.println("y ?");
            int y = scanner.nextInt();
            for (int boucle = 0; boucle < this.tableaudejeu.getCartes().length; boucle++) {
                if (x == this.tableaudejeu.getCartes()[boucle].getPosition().getX()
                        && y == this.tableaudejeu.getCartes()[boucle].getPosition().getY()) {
                    this.tableaudejeu.getCartes()[boucle].setIndice(joueurs[joueur].getIndices().get(indiceChoisi));

                }
            }

            
        }else{
           System.out.println("Vous avez pioché l'indice: " + this.tableaudejeu.getIndices()[this.tableaudejeu.getIndices().length-1]);
           ArrayList<YokaiClue> ind = new ArrayList<YokaiClue>();
           ind = joueurs[joueur].getIndices();
           ind.add(this.tableaudejeu.getIndices()[this.tableaudejeu.getIndices().length]);
           joueurs[joueur].setIndices(ind);

        }
    }

    public Boolean demandersilesyokaissesontapaises(){
        int choix = 0;
        System.out.println("jouer ? (1) ou arreter ? (0) ");
        choix = scanner.nextInt(); 
        if(choix == 0){
            return true;
        }else{
            return false;
        }
    }

    public void gererfindepartie(){
        if(new Random().nextInt(1) == 0){
            System.out.println("Vous avez gagné");
        }else{
            System.out.println("Vous avez perdu");
        }
    }

    public boolean rejouer(){
        System.out.println("Voulez-vous rester pour jouer une nouvelle partie (1)?");
        int rester = scanner.nextInt();
        if(rester == 1){
            return true;
        }else{
            return false;
        }
    }

    public int getNiveaudujeu() {
        return this.niveaudujeu;
    }

    public void setNiveaudujeu(int niveaudujeu) {
        this.niveaudujeu = niveaudujeu;
    }

    public Board getTableaudejeu() {
        return this.tableaudejeu;
    }

    public void setTableaudejeu(Board tableaudejeu) {
        this.tableaudejeu = tableaudejeu;
    }

    public Player[] getJoueurs() {
        return this.joueurs;
    }

    public void setJoueurs(Player[] joueurs) {
        this.joueurs = joueurs;
    }

    public Player getJoueuractuel() {
        return this.joueuractuel;
    }

    public void setJoueuractuel(Player joueuractuel) {
        this.joueuractuel = joueuractuel;
    }

}
