public class Prefrences {
    private String classPrefrence;
    private boolean layoverPrefrence;
    private int[] cost;

    /**
     * Object constructor
     * @param classPrefrence String
     * @param layoverPrefrence boolean
     * @param cost int[]
     */
    public Prefrences(String classPrefrence, boolean layoverPrefrence, int[] cost) {
        this.classPrefrence = classPrefrence;
        this.layoverPrefrence = layoverPrefrence;
        this.cost = cost;
    }

    /**
     * @return User's seat class preference
     */
    public String getClassPref() {
        return this.classPrefrence;
    }

    /**
     * @return User's layover preference 
     */
    public boolean getLayPref() {
        return this.layoverPrefrence;
    }

    /**
     * @return User's minimum price they'd pay for a seat
     */
    public int getMinCost() {
        return this.cost[0];
    }

    /**
     * @return The highest price a User would spend for a seat
     */
    public int getMaxCost() {
        return this.cost[cost.length - 1];
    }
    
}
