import java.util.ArrayList;

public class UserList {
    private static UserList users;
    private ArrayList<User> userL;
    
    private UserList() {
        userL = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        if(users == null) {
            users = new UserList();
        }
            return users;
    }
    //Checks to see if user is already created retuns boolean
    public boolean haveUser(String userName){
        for(User user: userL){
            if(user.getUsername().equals(userName)){
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param userName
     * @return An instance of a user that matches the passed in Username
     */
    public User getUser(String userName) {
        for (User user : userList) {
            if(user.getUsername().equals(userName))
                return user;
        }
        System.out.println("User not found");
        return null;
    }

    /**
     * 
     * @return the list of users
     */ 
    public ArrayList<User> getUsers() {
		return userL;
	}

    public boolean addUser(String username, String password, int age, String address, boolean frequentFlyer, String homeAirport, boolean passport, boolean hasDisability) {
    if(haveUser(username)) return false;
    userL.add(new User(username, password, age, address, frequentFlyer, homeAirport, passport, hasDisability))
    return true;
    }

    public void saveUsers(){
        DataWriter.saveUsers();
    }
}