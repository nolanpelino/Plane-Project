import java.util.ArrayList;

public class UserList {
    private static UserList userlist;
    private ArrayList<User> users;
    
    private UserList() {
        // TODO
    }

    public UserList getInstance() {
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
}
