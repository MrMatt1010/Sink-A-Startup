







//Keeping the below code to compare it to the final full version of the game
//public class StartupGame {
//    public static void main(String[] args) {
//        int numOfGuesses = 0;
//
//        GameHelper helper = new GameHelper();
//
//        Startup theStartup = new Startup();
//        int randomNum = (int) (Math.random() * 5);
//        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
//
//        theStartup.setLocationCells(locations);
//
//        boolean isAlive = true;
//        while (isAlive){
//            int guess = helper.getUserInput("Enter a number");
//            String result = theStartup.checkYourself(guess);
//            numOfGuesses++;
//
//            if (result.equals("kill")){
//                isAlive = false;
//                System.out.println(" You took " + numOfGuesses + " guesses ");
//            }//close if
//        }//close while
//    }
//}
