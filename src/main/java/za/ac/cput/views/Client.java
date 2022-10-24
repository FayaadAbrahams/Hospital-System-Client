package za.ac.cput.views;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Client {
    public static List<String> list = new ArrayList<>();

    // Fetch all items from Hospital Room and Return in a String
    public static List<String> getAllHospitalRooms() {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/hospitalroom/find-all");
            String encoding = Base64.getEncoder().encodeToString(("client-user:1253208465b").getBytes(StandardCharsets.UTF_8));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String line;
            while ((line = in.readLine()) != null) {
                /*System.out.println(line);*/
                list.add(line);
              /*  String jsonOutput = gson.toJson(line);
                list.add(jsonOutput + " Hello ");*/

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;

    }

    public static void main(String[] args) {
        getAllHospitalRooms();
    }


}
