import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

public class UserList {
    private static UserList users;
    private ArrayList<User> userL;
    
    private UserList() throws IOException, ParseException {
        userL = DataLoader.getUsers();
    }

    public static UserList getInstance() throws IOException, ParseException {
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
        for (User user : userL) {
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

    /**
     * Adds a user to the UserList contained ArrayList<User>
     * @param username
     * @param password
     * @param age
     * @param address
     * @param frequentFlyer
     * @param homeAirport
     * @param passport
     * @param hasDisability
     * @return True if the user does not already exist
     */
    public boolean addUser(String username, String password, int age, String address, boolean frequentFlyer, String homeAirport, boolean passport, boolean hasDisability) {
        if(haveUser(username)) 
            return false;
        userL.add(new User(username, password, age, address, frequentFlyer, homeAirport, passport, hasDisability));
        return true;
    }

    public void saveUsers() throws IOException, ParseException{
        DataWriter.saveUsers();
    }
}