package com.example.apimaekotki;

// Importujemy klasy z biblioteki Retrofit, aby umożliwić komunikację z API
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

// Interfejs CatApiService definiuje metody API, które będą wykorzystywane przez aplikację.
// Retrofit automatycznie generuje kod do obsługi żądań, które zostaną wysłane do API.
public interface CatApiService {

    // Adnotacja @GET wskazuje, że ta metoda wyśle żądanie GET do określonego punktu końcowego ("breeds").
    // Punkt końcowy "breeds" to ścieżka w API, która zwraca listę ras kotów.

    // Metoda `getCatBreeds()` jest zdefiniowana jako metoda typu Call z parametrem List<CatBreed>.
    // Oznacza to, że po wysłaniu żądania do API otrzymamy odpowiedź w formie listy obiektów CatBreed.
    @GET("breeds")
    Call<List<CatBreed>> getCatBreeds();
    // W praktyce, ta metoda wysyła żądanie do API i, po otrzymaniu odpowiedzi,
    // Retrofit automatycznie konwertuje dane JSON na listę obiektów CatBreed,
    // którą można potem wykorzystać w aplikacji.
}
