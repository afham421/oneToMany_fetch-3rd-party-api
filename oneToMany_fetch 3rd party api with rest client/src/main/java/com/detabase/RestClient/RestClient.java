package com.detabase.RestClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RestClient {



    public static void main(String[] args) {

        try {

            URL url = new URL("https://esbtest.sn3.com.sa:443/cxf/loginwfmroute/wfm/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"loginWfmEsbRequest\":{\"username\":\"126003\",\"password\":\"aaa\",\"lang\":\"en\",\"channel\":\"wfm\"}}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();



            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), StandardCharsets.UTF_8));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
