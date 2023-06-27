import ApiMethods.RequestMethods;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;



public class APITests {
    private static final String listOfUsers = "/api/users?page=2";
    public RequestMethods requestMethods;

    public APITests() {
        requestMethods = new RequestMethods();
    }

    @Test
    public void getUserList() throws URISyntaxException, IOException, InterruptedException {
        requestMethods.createRequest(listOfUsers);
    }
}
