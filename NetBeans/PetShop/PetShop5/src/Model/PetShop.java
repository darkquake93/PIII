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
public class PetShop {
    //name,address,phoneNumbers,website,openingtimes
    private String name;
    private String address;
    private String phoneNumbers;
    private String website;
    private String openingTimes; 

    public PetShop() {
    }

    public PetShop(String name, String address, String phoneNumbers, String website, String openingTimes) {
        this.name = name;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.website = website;
        this.openingTimes = openingTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }

    public void setOpeningTimes(String openingTimes) {
        this.openingTimes = openingTimes;
    }
    
    @Override
    public String toString()
    {
        return this.name+"\n"+this.address+"\n"+this.phoneNumbers+"\n"+this.website+"\n"+this.openingTimes+"\n";
    }
}
