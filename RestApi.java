import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestAPIClient {

    public static void main(String[] args) {

        try {
            String apiUrl = "https://api.github.com/users/octocat";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            System.out.println("Response Code: " + responseCode);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }

            br.close();

            System.out.println("\nAPI Response:\n");
            System.out.println(response.toString());

            connection.disconnect();
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
