package za.ac.cput.views;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class HttpConnect {

    private static InputStream inputStream = null;
    private static BufferedReader bufferedReader = null;
    private static String result;
    private static final String ENCODING = Base64.getEncoder().encodeToString(("admin-user:65ff7492d30").getBytes(StandardCharsets.UTF_8));
    public static String post(String urlDest, String urlParam)
    {
        try
        {
            HttpURLConnection connect = null;
            URL url = new URL(urlDest);
            connect = (HttpURLConnection)url.openConnection();
            connect.setRequestMethod("POST");
            connect.setRequestProperty("Content-Type",
                    "application/json");
            connect.setRequestProperty("Accept", "application/json");

            connect.setDoOutput(true);
            connect.setDoInput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connect.getOutputStream ());
            wr.writeBytes (urlParam);
            wr.flush ();
            wr.close ();



            //Get Response
            InputStream is = connect.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null)
            {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    //Opens the Connection, passes the ID we need to delete
    public static void connectionDELETE(String entity, String deleteID) throws IOException {
        //Pass the URL into the HttpURLConnection Object to create a connection
        String urlDest = "http://localhost:8080/hospital-system/" + entity + "/delete/" + deleteID;
        URL url = new URL(urlDest);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setDoOutput(true);

        //Specify what kind of authentication + adding encoding
        connection.setRequestProperty("Authorization", "Basic " + ENCODING);
        connection.connect();
        System.out.println("Deleted ID: " + deleteID);
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
    }

/*    //Opens the Connection, passes the ID we need to read
    public static String connectionREAD(String entity, String readID) throws IOException {
        //Pass the URL into the HttpURLConnection Object to create a connection
        String urlDest = "http://localhost:8080/hospital-system/" + entity + "/read/" + readID;
        URL url = new URL(urlDest);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        //Specify what kind of authentication + adding encoding
        connection.setRequestProperty("Authorization", "Basic " + ENCODING);
        connection.connect();

        inputStream = connection.getInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String finalString = Client.getPrettyString(result);
        System.out.println("Reading ID: " + readID);
        System.out.println(finalString);
        return finalString;
    }*/

    public static String connectionREAD(String entity, String readID) throws IOException {
        String json = null;
        try {
            String urlDest = "http://localhost:8080/hospital-system/" + entity + "/read/" + readID;
            URL url = new URL(urlDest);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            //Specify what kind of authentication + adding encoding
            connection.setRequestProperty("Authorization", "Basic " + ENCODING);
            connection.connect();

            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        String indented = (new JSONObject(text).toString(4));
        return indented;
    }

 /*   public static void main(String[] args) {
        try {
            //connectionREAD("nurse","12");
            System.out.println(connectionREAD("nurse","12"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
