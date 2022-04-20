import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class DataLoaderTest { 

    @Test
    public void testGetUser() throws IOException, ParseException {
        ArrayList<User> usList = new ArrayList<User>();
        usList = DataLoader.getUsers();
    }
}
