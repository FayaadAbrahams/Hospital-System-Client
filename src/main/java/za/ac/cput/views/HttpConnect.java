package za.ac.cput.views;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HttpConnect {
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
    public static HttpURLConnection connectionDELETE(String entity, String deleteID) throws IOException {
        //Pass the URL into the HttpURLConnection Object to create a connection
        String urlDest = "http://localhost:8080/hospital-system/" + entity + "/delete/" + deleteID;
        URL url = new URL(urlDest);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //Specify what kind of request
        connection.setRequestMethod("DELETE");
        connection.setDoOutput(true);
        //Specify what kind of authentication + adding encoding
        connection.setRequestProperty("Authorization", "Basic " + ENCODING);

        //Send request
        DataOutputStream wr = new DataOutputStream(
                connection.getOutputStream ());
    /*    wr.writeBytes (urlParam);*/
        wr.flush ();
        wr.close ();
        return connection;
    }

}
