import java.util.ArrayList;
public class Startup {
    private ArrayList<String> locationCells;
    private int numOfHits = 0;
    private String name;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }//end if
        }//end outer if
        return result;
    }//end method
}//close class



