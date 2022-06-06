package ut5web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebServerConnection {

    final static String CARDEALERWEB = "http://localhost:8080/concesionario/car_dealer.php";

    public static void main(String[] args) {
        /*List<Car> lCar = getCarsByDelegation(String.valueOf(1));
        int listSize = lCar.size();
        for (int i = 0; i < listSize; i++) {
            System.out.println(lCar.get(i).toString());
        }*/
        deleteSalesman("89778342J");
    }

    public static void deleteSalesman(String DNI) {
        HttpPost post = new HttpPost(CARDEALERWEB);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = null;
        try {
            List<NameValuePair> nvp = new ArrayList<NameValuePair>(2);
            nvp.add(new BasicNameValuePair("tag", "deleteSalesman"));
            nvp.add(new BasicNameValuePair("DNI", DNI));
            post.setEntity(new UrlEncodedFormEntity(nvp));            
            response = client.execute(post);
            
            JSONObject job = new JSONObject(inputStreamToString(response.getEntity().getContent()).toString());

            if (job.getBoolean("success")) {
                System.out.println("Se ha borrado correctamente");
            }else{
                String error = job.getString("error_msg");
                System.out.println("No se ha borrado correctamente: " + error);
            }
            
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            System.out.println("UnsupportedEncodingException: " + ex.getMessage());
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
            System.out.println("IOException: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    public static List<Car> getCarsByDelegation(String idDelegation) {
        HttpPost post = new HttpPost(CARDEALERWEB);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = null;
        List<Car> cars = null;
        try {
            // Params Definition
            List<NameValuePair> nvp = new ArrayList<NameValuePair>(2);
            nvp.add(new BasicNameValuePair("tag", "getCarsByDelegation"));
            nvp.add(new BasicNameValuePair("idDelegation", idDelegation));
            post.setEntity(new UrlEncodedFormEntity(nvp));
            // Execute the request and save the response
            response = client.execute(post);
            JSONObject job = new JSONObject(inputStreamToString(response.getEntity().getContent()).toString());

            // Get answer
            if (job.getInt("success") == 1) {
                // New object that contains the cars
                JSONArray jobCars = job.getJSONArray("cars");
                if (jobCars.length() > 0) {
                    // fill the return array
                    cars = new ArrayList<Car>();
                    for (int i = 0; i < jobCars.length(); i++) {
                        JSONObject jobCar = jobCars.getJSONObject(i);
                        Car car = new Car(Integer.valueOf(jobCar.getInt("id_car")),
                                jobCar.getString("model"),
                                Integer.valueOf(jobCar.getInt("horse_power")),
                                Integer.valueOf(jobCar.getInt("max_speed")),
                                Integer.valueOf(jobCar.getInt("doors")),
                                Integer.valueOf(jobCar.getInt("price")));
                        cars.add(car);
                    }
                }
            }
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            System.out.println("UnsupportedEncodingException: " + ex.getMessage());
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
            System.out.println("IOException: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception: " + ex.getMessage());
        }
        return cars;
    }

    public static StringBuilder inputStreamToString(InputStream is) {
        String line = "";
        StringBuilder total = new StringBuilder();
        // Guardamos la direcci�n en un buffer de lectura
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        // Y la leemos toda hasta el final
        try {
            while ((line = rd.readLine()) != null) {
                total.append(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error: " + ex.getMessage());
        }
        // Devolvemos todo lo leido
        return total;
    }
}
