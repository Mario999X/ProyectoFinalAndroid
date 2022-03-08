package com.example.proyectofinalandroid;

public class Producto {

    private Integer id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;

    //generar un constructor con los datos de inserccion
    public Producto(String title, String price, String category, String description, String image) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.description = description;
        this.image = image;
    }

    //generar los getter y setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }


    public String getImage() {
        return image;
    }

}
