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

    }
}
