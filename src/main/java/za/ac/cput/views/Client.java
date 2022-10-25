package za.ac.cput.views;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Client {

    private static String prettyString = null;
    // String used to encode username and password to access secured content on URL.
    private static final String ENCODING = Base64.getEncoder().encodeToString(("client-user:1253208465b").getBytes(StandardCharsets.UTF_8));
    private static InputStream content = null;
    private static BufferedReader in = null;
    private static String line;

    //Opens the Connection to the URL we need to get our information from
    public static HttpURLConnection connectionGET(URL url) throws IOException {
        //Pass the URL into the HttpURLConnection Object to create a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //Specify what kind of request
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        //Specify what kind of authentication + adding encoding
        connection.setRequestProperty("Authorization", "Basic " + ENCODING);
        return connection;
    }

    //Converts the JSON String into a more readable one
    public static String getPrettyString(String line) throws IOException {
        while ((line = in.readLine()) != null) {
            JSONArray json = new JSONArray(line);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement je = JsonParser.parseString(line);
            prettyString = gson.toJson(je);
        }
        return prettyString;
    }

    // Fetch all items from Hospital Room and Return in a String
    public static String getAllHospitalRooms() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/hospitalroom/find-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return getPrettyString(line);
    }


    //ISSUES HERE!!!
    // Fetch all items from Appointments and Return in a String
    public static String getAllAppointments() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/appointment/find-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return  getPrettyString(line);
    }

    // Fetch all items from Appointments and Return in a String
    public static String getAllDrivers() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/driver/get-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return  getPrettyString(line);
    }

    // Fetch all items from Appointments and Return in a String
    public static String getAllCleaningStaff() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/cleaningStaff/find-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return  getPrettyString(line);
    }



}
