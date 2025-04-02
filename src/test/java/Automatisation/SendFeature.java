import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class SendFeature {

    public static void sendResult(String token) throws IOException, InterruptedException {
        String token3 = token.replace("\"", "");
        String filePath = "src/test/resources/cucumber.json";
        String jsonContent = Files.readString(Path.of(filePath));

        Thread.sleep(10000);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://xray.cloud.getxray.app/api/v2/import/execution/cucumber"))
                .header("Content-Type", "application/json")
                .header("Authorization", " Bearer " + token3)
                .POST(HttpRequest.BodyPublishers.ofString(jsonContent))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
