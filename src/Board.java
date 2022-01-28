public class Board {
    private YokaiCard[] cartes = new YokaiCard[16];
    private YokaiClue[] indices = new YokaiClue[7];

    Board(){
        for (int x = 0; x < 4; x++) {
            
                this.cartes[x] = new YokaiCard(YokaiEnum.Kappa);
                this.cartes[x].setPosition(new Position(0, x));
            
           
        }
        for (int x = 4; x < 8; x++) {
                this.cartes[x] = new YokaiCard(YokaiEnum.Oni);
                this.cartes[x].setPosition(new Position(1, x-4));
            

        }
        for (int x = 8; x < 12; x++) {
                this.cartes[x] = new YokaiCard(YokaiEnum.Kitsune);
                this.cartes[x].setPosition(new Position(2, x-8));
            

        }
        for (int x = 12; x < 16; x++) {
                this.cartes[x] = new YokaiCard(YokaiEnum.Rokurokubi);
                this.cartes[x].setPosition(new Position(3, x-12));
            

        }

        for(int indice = 0;indice<indices.length;indice++){
            indices[indice] = new YokaiClue();
        }
        
    }
  
    public YokaiCard[] getCartes(){
        return this.cartes;
    }

    public void setCartes(YokaiCard[] cartes){
        this.cartes = cartes;
    }

    public YokaiClue[] getIndices(){
        return this.indices;
    }

    public void setIndices(YokaiClue[] indices){
        this.indices = indices;
    }

}
