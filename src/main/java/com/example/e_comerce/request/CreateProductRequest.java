package com.example.e_comerce.request;

import com.example.e_comerce.model.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private String title;
    private String description;
    private int price;
    private int dicountedPrice;
    private int dicountPercent;
    private int quantity;
    private String brand;
    private String color;
     private Set<Size> size =new HashSet<>();
    private String imageUrl;
    private String topLevelCategory;
    private String secondLevelCategory;
    private String thirdLevelCategory;

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public int getDicountedPrice() {
//        return dicountedPrice;
//    }
//
//    public void setDicountedPrice(int dicountedPrice) {
//        this.dicountedPrice = dicountedPrice;
//    }
//
//    public int getDicountPercent() {
//        return dicountPercent;
//    }
//
//    public void setDicountPercent(int dicountPercent) {
//        this.dicountPercent = dicountPercent;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public Set<Size> getSize() {
//        return size;
//    }
//
//    public void setSize(Set<Size> size) {
//        this.size = size;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public String getTopLavelCategory() {
//        return topLavelCategory;
//    }
//
//    public void setTopLavelCategory(String topLavelCategory) {
//        this.topLavelCategory = topLavelCategory;
//    }
//
//    public String getSecondLavelCategory() {
//        return secondLavelCategory;
//    }
//
//    public void setSecondLavelCategory(String secondLavelCategory) {
//        this.secondLavelCategory = secondLavelCategory;
//    }
//
//    public String getThirdLavelCategory() {
//        return thirdLavelCategory;
//    }
//
//    public void setThirdLavelCategory(String thirdLavelCategory) {
//        this.thirdLavelCategory = thirdLavelCategory;
//    }
}
