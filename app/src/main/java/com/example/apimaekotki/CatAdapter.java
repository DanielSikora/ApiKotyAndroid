package com.example.apimaekotki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;  // Import biblioteki Glide do ładowania obrazów

import java.util.List;

// Adapter do wyświetlania listy obiektów CatBreed w RecyclerView
public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {

    private List<CatBreed> catBreeds;  // Lista obiektów CatBreed, które chcemy wyświetlić

    // Konstruktor, który przyjmuje listę CatBreed
    public CatAdapter(List<CatBreed> catBreeds) {
        this.catBreeds = catBreeds;
    }

    // Tworzy nową instancję CatViewHolder i inflatuje layout dla pojedynczego elementu
    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cat, parent, false);  // Inflate layoutu item_cat.xml
        return new CatViewHolder(view);
    }

    // Metoda, która wypełnia dane dla danego elementu listy
    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        CatBreed cat = catBreeds.get(position);  // Pobieramy obiekt CatBreed z listy
        holder.nameTextView.setText(cat.getName());  // Ustawiamy nazwę rasy kota
        holder.originTextView.setText(cat.getOrigin());  // Ustawiamy pochodzenie rasy

        // Załaduj obrazek za pomocą biblioteki Glide, korzystając z URL-a obrazu
        Glide.with(holder.catImageView.getContext())
                .load(cat.getImageUrl())  // Pobiera URL obrazu dla danej rasy kota
                .into(holder.catImageView);  // Ustawia obrazek w ImageView
    }

    // Zwraca liczbę elementów w liście
    @Override
    public int getItemCount() {
        return catBreeds.size();
    }

    // Wewnętrzna klasa ViewHolder, która odnosi się do widoków w item_cat.xml
    static class CatViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, originTextView;  // Widoki do wyświetlania nazwy i pochodzenia
        ImageView catImageView;  // Widok do wyświetlania obrazka kota

        // Konstruktor ViewHolder, który mapuje widoki z layoutu do pól klasy
        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);  // Mapa dla nazwy rasy
            originTextView = itemView.findViewById(R.id.originTextView);  // Mapa dla pochodzenia
            catImageView = itemView.findViewById(R.id.catImageView);  // Mapa dla ImageView
        }
    }
}
