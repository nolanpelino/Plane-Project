import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> uList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < uList.size(); i++) {
            jsonUsers.add(getUserJSON(uList.get(i)));
        }

        try (FileWriter file = new FileWriter(USERS_FILENAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject getUserJSON(User usr) {
        JSONObject userInfo = new JSONObject();
        userInfo.put(USER_USERNAME, usr.getUsername());
        userInfo.put(USER_PASSWORD, usr.getPassword());
        userInfo.put(USER_ADDRESS, usr.getAddress());
        userInfo.put(USER_AGE, usr.getAge());
        userInfo.put(USER_ADDRESS, usr.getAddress());
        userInfo.put(USER_FRQFLYER, usr.getFrFlyer());
        userInfo.put(USER_HOMEAIRPORT, usr.getHomeAirport());
        userInfo.put(USER_PASSPORT, usr.hasPassport());
        userInfo.put(USER_HASDISABILITY, usr.getHasDisability());
        userInfo.put(USER_FAMILYUSERS, usr.getFamilyUsers());

        return userInfo;
    }
}
