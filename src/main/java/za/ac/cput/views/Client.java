package za.ac.cput.views;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Client {

    // String used to encode username and password to access secured content on URL.
    private static final String ENCODING = Base64.getEncoder().encodeToString(("client-user:1253208465b").getBytes(StandardCharsets.UTF_8));
    private static final String ENCODING2 = Base64.getEncoder().encodeToString(("admin-user:65ff7492d30").getBytes(StandardCharsets.UTF_8));
    private static String prettyString = null;
    private static InputStream content = null;
    private static OutputStream contentOut = null;
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

    public static HttpURLConnection connectionPOST(URL postURL) throws IOException {
        HttpURLConnection postConnection = (HttpURLConnection) postURL.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Authorization", "Basic "+ENCODING2);
        postConnection.setDoOutput(true);
        return postConnection;
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
//================================================================================================================================================
// Entity Methods

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

    // Fetch all items from Appointments and Return in a String
    public static String getAllAppointments() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/appointment/get-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        System.out.println(line);
        return getPrettyString(line);
    }

    // Fetch all items from Drivers and Return in a String
    public static String getAllDrivers() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/driver/all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return getPrettyString(line);
    }

    // Fetch all items from Cleaning Staff and Return in a String
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
        return getPrettyString(line);
    }

    // Fetch all items from Drivers and Return in a String
    public static String getAllNurses() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/nurse/find-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return getPrettyString(line);
    }

    public static String postNurse(String id, String fname, String lname) throws IOException
    {
        try
        {

            URL url = new URL("http://localhost:8080/hospital-system/nurse/save");

            JSONObject json = new JSONObject();
            json.put("nurseLastName", lname);
            json.put("nurseFirstName", fname);
            json.put("nurseID", id);

            System.out.println("");
            System.out.println(json);

            DataOutputStream dos = new DataOutputStream(connectionPOST(url).getOutputStream());
            dos.writeBytes(json.toString());
            dos.flush();
            dos.close();

            int responseCode = connectionPOST(url).getResponseCode();
            System.out.println("Response Code :" + responseCode);

            System.out.println("");
            return getPrettyString(line);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    // Fetch all items from Suppliers and Return in a String
    public static String getSuppliers() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/supplier/all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return getPrettyString(line);
    }

    // Fetch all items from Invoices and Return in a String
    public static String getInvoices() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/invoice/all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return getPrettyString(line);
    }

    // Fetch all items from Invoices and Return in a String
    public static String getMedicalAids() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/medicalaid/find-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return getPrettyString(line);
    }

    // Fetch all items from Medicines and Return in a String
    public static String getMedicines() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/medicine/find-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return getPrettyString(line);
    }

    // Fetch all items from Patients and Return in a String
    public static String getPatients() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/patient/find-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return getPrettyString(line);
    }

    // Fetch all items from Doctors and Return in a String
    public static String getDoctors() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/doctor/get-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return getPrettyString(line);
    }

    public static String postDoctor(String id, String fname, String lname, String cellNum) throws IOException
    {
        try
        {

            URL url = new URL("http://localhost:8080/hospital-system/doctor/create");

            JSONObject json = new JSONObject();
            json.put("docID", lname);
            json.put("firstName", fname);
            json.put("lastName", id);
            json.put("cellNum", cellNum);

            System.out.println("");
            System.out.println(json);

            DataOutputStream dos = new DataOutputStream(connectionPOST(url).getOutputStream());
            dos.writeBytes(json.toString());
            dos.flush();
            dos.close();

            int responseCode = connectionPOST(url).getResponseCode();
            System.out.println("Response Code :" + responseCode);

            System.out.println("");
            return getPrettyString(line);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    // Fetch all items from Secretaries and Return in a String
    public static String getSecretaries() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/hospital-system/secretary/get-all");
            content = Client.connectionGET(url).getInputStream();
            in = new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPrettyString(line));
        //Returns the final readable JSON Array
        return getPrettyString(line);
    }


}



//            if(urlStr.contains(" "))
//            {
//                urlStr = urlStr.replace(" ", "%20");
//            }
//            URL url = new URL(urlStr);
//            HttpClient httpClient = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(urlStr))
//                    .POST(HttpRequest.BodyPublishers.ofString(jObj))
//                    .build();
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//            System.out.println(response.body());

//            content = connectionPOST(url).getInputStream();
//            in = new BufferedReader(new InputStreamReader(content));
//            in.close();