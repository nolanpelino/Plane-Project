public class BasicUser {
    private String username;
    private int age;
    private boolean passport;
    private boolean hasDisability;

    public BasicUser(String username, int age, boolean hasDisability, boolean passport){
        this.username=username;
        this.age=age;
        this.hasDisability=hasDisability;
        this.passport=passport;
    }

    public boolean hasPassport(){
        return passport;
    }

    public int getAge(){
        return age;
    }

    public boolean isDisabled(){
        return hasDisability;
    }

}
