import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.UUID;


public class UserListTest {
   
    @Test
    public void testGetUser() throws IOException, ParseException, org.json.simple.parser.ParseException {
        /* Testing to see if getUser correctly obtains all the users from the user.json file.
        getUser uses the dataloader within its class  */
        
        ArrayList<User> compList = new ArrayList<User>();
        UserList usList = UserList.getInstance();
        // HARDCODING
        UUID uuid = UUID.fromString("7244f7ac-a242-417d-9aa5-6ad7fb5fde5b");
        UUID uuid2 = UUID.fromString("104207fd-5447-462b-9486-ad309a2e72bc");
        User us1 = new User("KarieMicheals20", "Applest0Bananas3", uuid, 35, "638 W University Boulevard\nOdessa, Texas 79964\nUnited States",
         true, "ODO", true, false);
        User us2 = new User("user", "pass", uuid2, 20, "638 W University Boulevard\nOdessa, Texas 79964\nUnited States",
        true, "ODO", true, false);
        // HARDCODING
        compList.add(us1);
        compList.add(us2);
        assertEquals(compList, usList.getUsers());
    }
}
