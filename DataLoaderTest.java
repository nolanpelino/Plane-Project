import org.json.simple.parser.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class DataLoaderTest { 

    @Test
    public void testGetUser() throws IOException, ParseException {
        // Tetsing to see if getUser correctly obtains all the users from the user.json file
        ArrayList<User> usList = new ArrayList<User>();
        ArrayList<User> compList = new ArrayList<User>();
        usList = DataLoader.getUsers();
        UUID uuid = UUID.fromString("7244f7ac-a242-417d-9aa5-6ad7fb5fde5b");
        UUID uuid2 = UUID.fromString("104207fd-5447-462b-9486-ad309a2e72bc");
        User us1 = new User("KarieMicheals20", "Applest0Bananas3", uuid, 35, "638 W University Boulevard\nOdessa, Texas 79964\nUnited States",
         true, "ODO", true, false);
        User us2 = new User("user", "pass", uuid2, 20, "638 W University Boulevard\nOdessa, Texas 79964\nUnited States",
        true, "ODO", true, false);
        compList.add(us1);
        compList.add(us2);
        assertEquals(compList, usList);
    }
}
