import java.util.ArrayList;

public class UserList {
    private static UserList userlist;
    private ArrayList<User> users;
    
    private UserList() {

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

    public User getUser(String userName) {
        for (User us : users) {
            if(us.getUsername().equalsIgnoreCase(userName))
                return us;
        }
        System.out.println("User not found");.
        return null;
    }
}
