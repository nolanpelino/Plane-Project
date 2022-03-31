public class BasicUser {
    private String username;
    private int age;
    private boolean passport;
    private boolean hasDisability;

    /**
     * A basic class for smaller implementations of a user
     * @param String
     * @param int
     * @param boolean
     * @param boolean
     */
    public BasicUser(String username, int age, boolean hasDisability, boolean passport){
        this.username=username;
        this.age=age;
        this.hasDisability=hasDisability;
        this.passport=passport;
    }

    /**
     * Returns the value of the basic users passport possession
     * @return boolean
     */
    public boolean hasPassport(){
        return passport;
    }

    /**
     * Returns the age of the user
     * @return int 
     */
    public int getAge(){
        return age;
    }

    /**
     * Returns true if the user is disabled
     * @return boolean
     */
    public boolean isDisabled(){
        return hasDisability;
    }
    public void displayAccount() {
        System.out.println(username);
    }
}
