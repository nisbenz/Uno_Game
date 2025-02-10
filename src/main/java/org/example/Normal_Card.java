package org.example;
import java.util.Random;

public class Normal_Card extends Card {
    private int num;
    public Normal_Card() {
        generatevalue();
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    void generatevalue(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(10);
        setNum(x);
    }
    void Displaycard(){
        int k;
    }
    boolean Isitplayable(Card previous){
        if(previous instanceof Normal_Card){
            if(((Normal_Card) previous).getNum()==this.getNum()||((Normal_Card) previous).getColor()==this.getColor()){
                return true;
            }else{
                return false;
            }
        }else{
            if(previous instanceof  Special_Card){
                if(((Special_Card) previous).getEffect()){
                    return false;
                }
            }
        }
    };

}
