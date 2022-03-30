import java.util.ArrayList;

public class UserList {
    private static UserList userlist;
    private ArrayList<User> users;
    
    private UserList() {
        // TODO
    }

    public static UserList getInstance() {
        if(userlist == null) {
            userlist = new UserList();
            return userlist;
        }
        else {
            return userlist;
        }
    }

    /**
     * 
     * @param userName
     * @return An instance of a user that matches the passed in Username
     */
    public User getUser(String userName) {
        for (User us : users) {
            if(us.getUsername().equalsIgnoreCase(userName))
                return us;
        }
        System.out.println("User not found");
        return null;
    }

<<<<<<< HEAD
    public ArrayList<User> getUsers() {
        return users;
    }
=======
    /**
     * 
     * @return the list of users
     */ 
    public ArrayList<User> getUsers() {
		return users;
	}
>>>>>>> 74d122974d77512b7b47d8685c5775b2c913f6aa
}
