import org.junit.Test;

import java.util.ArrayList;

public class DataLoaderTest {
    
    @Test
    public void testGetUser() {
        DataLoader dl = new DataLoader();
        final ArrayList<User> usList = dl.getUsers();
    }
}
