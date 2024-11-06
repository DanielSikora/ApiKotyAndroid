package com.example.apimaekotki;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ustawienie layoutu głównego dla tej aktywności
        setContentView(R.layout.activity_main);

        // Inicjalizacja RecyclerView i ustawienie układu liniowego (pionowego) dla elementów listy
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Wywołanie metody pobierającej dane o rasach kotów z API
        getCatBreeds();
    }

    /**
     * Metoda odpowiedzialna za pobranie danych o rasach kotów z API.
     */
    private void getCatBreeds() {
        // Tworzenie instancji API za pomocą Retrofit
        CatApiService apiService = RetrofitInstance.getRetrofitInstance().create(CatApiService.class);

        // Tworzenie zapytania do API, które zwróci listę obiektów typu CatBreed
        Call<List<CatBreed>> call = apiService.getCatBreeds();

        // Wysyłanie zapytania asynchronicznego do API
        call.enqueue(new Callback<List<CatBreed>>() {
            @Override
            public void onResponse(Call<List<CatBreed>> call, Response<List<CatBreed>> response) {
                // Jeśli odpowiedź jest poprawna, pobierz listę ras kotów
                List<CatBreed> catBreeds = response.body();

                // Ustaw adapter dla RecyclerView, przekazując listę ras kotów do wyświetlenia
                recyclerView.setAdapter(new CatAdapter(catBreeds));
            }

            @Override
            public void onFailure(Call<List<CatBreed>> call, Throwable t) {
                // Jeśli wystąpił błąd podczas komunikacji z API, wyświetl go w logach
                Log.e("MainActivity", "Błąd: " + t.getMessage());
            }
        });
    }
}
