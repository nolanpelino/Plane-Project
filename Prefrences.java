public class Prefrences {
    private String classPrefrence;
    private boolean layoverPrefrence;
    private int[] cost;

    public Prefrences(String classPrefrence, boolean layoverPrefrence, int[] cost) {
        this.classPrefrence = classPrefrence;
        this.layoverPrefrence = layoverPrefrence;
        this.cost = cost;
    }

    public String getClassPref() {
        return this.classPrefrence;
    }

    public boolean getLayPref() {
        return this.layoverPrefrence;
    }

    public int getMinCost() {
        return this.cost[0];
    }

    public int getMaxCost() {
        return this.cost[cost.length - 1];
    }
    
}
