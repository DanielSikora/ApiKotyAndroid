package com.example.apimaekotki;

public class CatBreed {
    private String id;
    private String name;
    private String origin;
    private String description;
    private String life_span;
    private Weight weight;
    private String reference_image_id;

    // Getter i Setter
    public String getName() { return name; }
    public String getOrigin() { return origin; }
    public String getDescription() { return description; }
    public String getLifeSpan() { return life_span; }
    public Weight getWeight() { return weight; }

    public class Weight {
        private String metric;

        public String getMetric() { return metric; }
    }
    // Getter dla URL obrazu
    public String getImageUrl() {
        return "https://cdn2.thecatapi.com/images/" + reference_image_id + ".jpg";
    }
}

