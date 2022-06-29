package com.demo.unittest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


@SpringBootApplication
public class UnitTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(UnitTestApplication.class, args);
    String test = sendSms();
    System.out.println(test);
  }

  public static String sendSms() {
    try {
      // Construct data
      String apiKey = "apikey=" + "yourapiKey";
      String message = "&message=" + "This is your message";
      String sender = "&sender=" + "Jims Autos";
      String numbers = "&numbers=" + "0927828901";

      // Send data
      HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
      String data = apiKey + numbers + message + sender;
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
      conn.getOutputStream().write(data.getBytes("UTF-8"));
      final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      final StringBuffer stringBuffer = new StringBuffer();
      String line;
      while ((line = rd.readLine()) != null) {
        stringBuffer.append(line);
      }
      rd.close();

      return stringBuffer.toString();
    } catch (Exception e) {
      System.out.println("Error SMS "+e);
      return "Error "+e;
    }
  }
}
