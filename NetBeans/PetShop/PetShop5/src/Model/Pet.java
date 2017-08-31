/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sonya
 */
public class Pet {
    //Shop,Type,price,dateAcquired,notes
    private String shop;
    private String type;
    private double price;
    private String dateAcquired;
    private String notes;

    

    public Pet() {
    }

    public Pet(String shop, String type, double price, String dateAquired, String notes) {
        this.shop = shop;
        this.type = type;
        this.price = price;
        this.dateAcquired = dateAcquired;
        this.notes = notes;
    }
    
    
    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAquired) {
        this.dateAcquired = dateAcquired;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    @Override
    public String toString()
    {
        return this.shop+"\n"+this.type+"\n"+this.price+"\n"+this.dateAcquired+"\n"+this.notes+"\n";
    }
}
