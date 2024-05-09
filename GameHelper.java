    import java.util.ArrayList;
    import java.util.Random;
    import java.util.Scanner;

    public class GameHelper {
        private static final String ALPHABET = "abcdefg";
        private static final int GRID_LENGTH = 7;
        private static final int GRID_SIZE = 49;
        private static final int MAX_ATTEMPTS = 200;
        static final int HORIZONTAL_INCREMENT = 1;
        static final int VERTICAL_INCREMENT = GRID_LENGTH;

        private final int[] grid = new int[GRID_SIZE];
        private final Random random = new java.util.Random();
        private int startupCount = 0;

        public String getUserInput(String prompt) {
            System.out.print(prompt + ": ");
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine().toLowerCase();
        }//end getUserInput

        public ArrayList<String> placeStartup(int startupSize){
        //holds index to grid (0 - 48)
        int[] startupCoords = new int[startupSize];
        int attempts = 0;
        boolean success = false;

        startupCount++;
        int increment = getIncrement();

        while (!success & attempts++ < MAX_ATTEMPTS){
            int location = random.nextInt(GRID_SIZE);

            for (int i = 0; i < startupCoords.length; i++){
                startupCoords[i] = location;
                location += increment;
            }
            //System.out.println("Trying: " + Arrays.toString(startupCoords));

            if (startupFits(startupCoords, increment)) {                        //startup fits on grid?
                success = coordsAvailable(startupCoords);                       //...and locations aren't taken
            }                                                                   //end loop
        }                                                                       //end while
        savePositionToGrid(startupCoords);                                      //coords passed checks, save
        ArrayList<String> alphaCells = convertCoordsToAlphaFormat(startupCoords)
                //System.out.println("placed at: " + alphaCells);
            return alphaCells;
        }//end placeStartup

        private boolean startupFits(int[] startupCoords, int increment){
            int finalLocation = startupCoords[startupCoords.length -1];
            if (increment == HORIZONTAL_INCREMENT){
                //check end is on same row as start
                return calcRowFromIndex(startupCoords[0]) == calcRowFromIndex(finalLocation);
            }else{
                return finalLocation < GRID_SIZE;
            }
        }//end startupFits
        private boolean coordsAvailable(int[] startupCoords){
            for (int coord : startupCoords){
                if (grid[coord] ! = 0){
                    //System.out.println("position: " + coord + " already taken.");
                    return false; //no success
                }
            }
            return true;         //there were no clashes
        }//end coordsAvailable
        private void savePositionToGrid(int[] startupCoords){
            for (int index : startupCoords){
                grid[index] = 1;
            }
        }//end savePositionToGrid
        private ArrayList<String> convertCoordsToAlphaFormat(int[] startupCoords){
            ArrayList<String> alphaCells = new ArrayList<String>();
            for (int index : startupCoords){                        //for each grid coordinate
                String alphaCoords = getAlphaCoordsFromIndex(index);//turn it into an "a0" style
                alphaCells.add(alphaCoords);                        //add to a list
            }
            return alphaCells;                                      //return the "a0" style coords
        }//end convertCoordsToAlphaFormat
        private String getAlphaCoordsFromIndex(int index){
            int row = calcRowFromIndex(index);                      //get row value
            int colum = index % GRID_LENGTH;                        //get numeric column value
            String letter = ALPHABET.substring(column, column + 1);
            return letter + row;
        }//end getAlphaCoordsFromIndex
        private int calcRowFromIndex(int index){
            return index / GRID_LENGTH;
        }//end calcRowFromIndex
        private int getIncrement(){
            if (startupCount % 2 == 0){                             //if EVEN Startup
                return HORIZONTAL_INCREMENT;                        //place horizontally
            }else{                                                  //else ODD
                return VERTICAL_INCREMENT;                          //place vertically
            }
        }//end getIncrement
    }//end class


