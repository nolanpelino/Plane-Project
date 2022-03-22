public class Prefrences {
    private String planeSize;
    private String classPrefrence;
    private boolean layoverPrefrence;
    private int[] cost;

    public Prefrences(String planeSize, String classPrefrence, boolean layoverPrefrence, int[] cost)
    {
        this.planeSize=planeSize;
        this.classPrefrence=classPrefrence;
        this.layoverPrefrence=layoverPrefrence;
        this.cost=cost;
    }

    public String getPrefrences(){
        return "Your prefered plane size is "+planeSize+", your prefered class is "+classPrefrence+".";
}
}
