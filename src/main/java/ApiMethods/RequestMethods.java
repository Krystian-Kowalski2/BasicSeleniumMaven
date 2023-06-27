package ApiMethods;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.testng.Assert;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class RequestMethods {
    private static final String targetURI = "https://reqres.in";

    private HttpClient setupClient() {
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    private HttpRequest createGetRequest(String endpoint) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(targetURI + endpoint))
                .header("Accept", "application/json")
                .GET()
                .build();
    }

    private JsonObject parseJson(String responseBody) {
        return new Gson().fromJson(responseBody, JsonObject.class);
    }

    private void assertDataFormat(JsonObject jsonData) {
        JsonArray dataArray = jsonData.getAsJsonArray("data");

        if (dataArray != null && dataArray.size() > 0) {
            JsonObject firstUserData = dataArray.get(0).getAsJsonObject();
            JsonElement idElement = firstUserData.get("id");
            JsonElement emailElement = firstUserData.get("email");

            Assert.assertTrue(idElement != null && idElement.isJsonPrimitive() && idElement.getAsJsonPrimitive().isNumber(),
                    "The 'id' field is not an integer.");

            Assert.assertTrue(emailElement != null && emailElement.isJsonPrimitive() && emailElement.getAsJsonPrimitive().isString(),
                    "The 'email' field is not a string.");
        } else {
            System.out.println("No data elements found in the response.");
        }
    }

    public void createRequest(String endpoint) throws URISyntaxException, IOException, InterruptedException {
        HttpResponse<String> response = setupClient().send(createGetRequest(endpoint), HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        assertDataFormat(parseJson(response.body()));
    }
}
