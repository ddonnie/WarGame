/**
 * Created by Orlov on 09.10.2016.
 */
public class Simulation {
    public static void main(String[] args) {

        Army french = new Army("French", 10000);
        Army english = new Army("English", 10000);
        Battleground geneve = new Battleground(french, english, 1000);

        geneve.battle();

    }
}
