package com.example.proyectofinalandroid;

public class Producto {

    private Integer id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;

    //general un constructor con los datos de inserccion


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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
