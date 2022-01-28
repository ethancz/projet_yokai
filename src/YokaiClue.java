import java.util.Random;
public class YokaiClue {
    private YokaiEnum famille;
    private Position position;


    YokaiClue(){
        Random random = new Random();
        famille = YokaiEnum.values()[random.nextInt(YokaiEnum.values().length)];
           
    }
    public YokaiEnum getFamille(){
        return this.famille;
    }

    public void setFamille(YokaiEnum famille){
        this.famille = famille;
    }

    public Position getPosition(){
        return this.position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    

}
