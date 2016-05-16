package io.intellijokers;

import java.util.*;

/**
 * Created by dimitrivaughn on 5/11/16.
 */
public class Roulette extends Game{

    /**
     * Initializing hashmap to create roulette table
     */
    Random rand = new Random();
    static HashMap<Integer, String> hashMap = new HashMap<>();
    public enum Command{
        STRAIGHT,
        EVEN,
        ODD,
        BLACK,
        RED,
        EXIT,
        HELP
    }

    static {

        hashMap.put(0, "GREEN");
        hashMap.put(1, "RED");
        hashMap.put(2, "BLACK");
        hashMap.put(3, "RED");
        hashMap.put(4, "BLACK");
        hashMap.put(5, "RED");
        hashMap.put(6, "BLACK");
        hashMap.put(7, "RED");
        hashMap.put(8, "BLACK");
        hashMap.put(9, "RED");
        hashMap.put(10, "BLACK");
        hashMap.put(11, "BLACK");
        hashMap.put(12, "RED");
        hashMap.put(13, "BLACK");
        hashMap.put(14, "RED");
        hashMap.put(15, "BLACK");
        hashMap.put(16, "RED");
        hashMap.put(17, "BLACK");
        hashMap.put(18, "RED");
        hashMap.put(19, "RED");
        hashMap.put(20, "BLACK");
        hashMap.put(21, "RED");
        hashMap.put(22, "BLACK");
        hashMap.put(23, "RED");
        hashMap.put(24, "BLACK");
        hashMap.put(25, "RED");
        hashMap.put(26, "BLACK");
        hashMap.put(27, "RED");
        hashMap.put(28, "BLACK");
        hashMap.put(29, "BLACK");
        hashMap.put(30, "RED");
        hashMap.put(31, "BLACK");
        hashMap.put(32, "RED");
        hashMap.put(33, "BLACK");
        hashMap.put(34, "RED");
        hashMap.put(35, "BLACK");
        hashMap.put(36, "RED");

    }

    /**
     * Initializing fields
     */
    private int winningNumber;

    ArrayList<Integer> bets = new ArrayList<>();

    /**
     * Sets a randomly generated winning number (0-36)
     */
    public void setWinningNumber(){
        this.winningNumber =rand.nextInt(37);
    }

    /**
     * Returns the winning number
     * @return
     */
    public int getWinningNumber(){
        return winningNumber;
    }


    public void setBets(ArrayList<Integer> bets){
        this.bets = bets;
    }
    public ArrayList<Integer> getBets(){
        return bets;
    }

    /**
     * Stores a straight bet (single number)
     * @param number
     */
    public void betStraight(int number){
        bets.add(number);
    }

    /**
     * Stores an even bet
     */
    public void betEven(){
        for(int i=2; i <= 36; i= i+2){
            betStraight(i);
        }
    }

    /**
     * Stores an odd bet
     */
    public void betOdd(){
        for(int i=1; i <= 36; i= i+2){
            betStraight(i);
        }
    }

    /**
     * Stores a color bet
     * @param player
     * @param color
     */
    public void betColor(Player player, String color){
            player.setBetColor(color);
    }

    public boolean determineByNum(Player player){
        System.out.println("Winning number: "+getWinningNumber());
        boolean bool = player.getBets().contains(getWinningNumber());
        System.out.println(bool);
        return bool;
    }

    public boolean determineByColor(Player player){
        System.out.println("winning color: "+ hashMap.get(getWinningNumber()));
        return hashMap.get(getWinningNumber()).equalsIgnoreCase(player.getBetColor());
    }

    public boolean determineWinner(Player player){

        boolean playerWins = false;

        if(player.getBetType() == Player.Choice.NUMBER){
           playerWins = determineByNum(player);
        }
        else{
            playerWins = determineByColor(player);
        }
        return playerWins;
    }

//    public boolean askForInput(Player player, Scanner scanner, String input){
//        input = scanner.nextLine();
//        return CLI(player, input);
//    }

    public int printGameResults(Player player){
        setWinningNumber();
        if(determineWinner(player)){
            System.out.println("\nYou Won! #gettingpunchedintheface");
            player.setCash(player.getCash()+payOut());

        }else{
            System.out.println("Bad Luck!\n");
        }
        System.out.println("you now have "+player.getCash()+" in cash");
        return player.getCash();
    }

    public ArrayList<Integer> resetGame(Player player){
        ArrayList<Integer> clearBets = new ArrayList<>();
        player.setBets(clearBets);
        setBets(clearBets);
        return clearBets;
    }

    public void engine(Player player){

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String commandList = Arrays.asList(Command.values()).toString();
        System.out.println("\n\nWelcome To roulette "+player.getName());
        do{
            System.out.println("\n \n please make a bet "+"\n"+commandList.substring(1, commandList.length()-1));
            String input = "";
            boolean commandWork = false;
            do{
                input = scanner.next();
                commandWork = CLI(player, input);
            }while(!commandWork);
           printGameResults(player);

            System.out.println("\nwould you like to play again? \n" + " type any key and ENTER to continue...\n" + "\n" + " otherwise, type N\n");
            input = scanner.nextLine();
            resetGame(player);
            if(input.equalsIgnoreCase("n")) loop = false;
        }while(loop);
    }

    public boolean CLI(Player player, String input){
        boolean didCommandWork = false;
        String[] inputs = input.split(" ");
        Command comm = Command.HELP;
        try {
            int i = Command.valueOf(inputs[0].toUpperCase()).ordinal();
            comm = Command.values()[i];
        }catch(Exception e){
            System.out.println("That does not seem to be an available type of bet in this game");
        }

        if(inputs.length <= 3 && inputs.length > 1) {
            switch (comm) {
                case STRAIGHT:
                    if(inputs.length < 3){
                        System.out.println("try this command with a spaced with the number you want to bet on,\n and how much you want to bet");
                    }else {
                        this.betStraight(Integer.parseInt(inputs[1]));
                        player.setBets(this.getBets());
                        this.setAmountBet(player.placeBet(Integer.parseInt(inputs[2])));
                        player.setBetType(Player.Choice.NUMBER);
                        didCommandWork = true;
                    }
                    break;
                case EVEN:
                    this.betEven();
                    player.setBets(this.getBets());
                    this.setAmountBet(player.placeBet(Integer.parseInt(inputs[1])));
                    player.setBetType(Player.Choice.NUMBER);
                    didCommandWork = true;
                    break;
                case ODD:
                    this.betOdd();
                    player.setBets(this.getBets());
                    this.setAmountBet(player.placeBet(Integer.parseInt(inputs[1])));
                    player.setBetType(Player.Choice.NUMBER);
                    didCommandWork = true;
                    break;
                case RED:
                    this.betColor(player, comm.toString().toUpperCase());
                    this.setAmountBet(player.placeBet(Integer.parseInt(inputs[1])));
                    player.setBetType(Player.Choice.COLOR);
                    didCommandWork = true;
                    break;
                case BLACK:
                    this.betColor(player, comm.toString().toUpperCase());
                    this.setAmountBet(player.placeBet(Integer.parseInt(inputs[1])));
                    player.setBetType(Player.Choice.COLOR);
                    didCommandWork = true;
                    break;
                default:
                    System.out.println("try typing in one of the commands listed to continue. ");
                    break;
            }

        }else if(inputs.length <= 1){
            System.out.printf("Don't you want to bet some money? \n\n Try typing \n\n  EVEN 100 \n or \n straight 9 50\n");
        }else{
            System.out.println("that is too many arguments");
        }
        return didCommandWork;
    }
}
