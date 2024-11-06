package com.example.apimaekotki;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Klasa RetrofitInstance zapewnia singletonową instancję Retrofit do komunikacji z API
public class RetrofitInstance {

    private static Retrofit retrofit;  // Statyczna zmienna do przechowywania instancji Retrofit
    private static final String BASE_URL = "https://api.thecatapi.com/v1/";  // Podstawowy URL API

    // Statyczna metoda, która zwraca instancję Retrofit
    public static Retrofit getRetrofitInstance() {
        // Jeśli instancja Retrofit nie istnieje, utwórz ją
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)  // Ustawiamy podstawowy URL dla API
                    .addConverterFactory(GsonConverterFactory.create())  // Dodajemy konwerter JSON -> obiekty Java
                    .build();  // Tworzymy instancję Retrofit
        }
        return retrofit;  // Zwracamy istniejącą lub nowo utworzoną instancję
    }
}
