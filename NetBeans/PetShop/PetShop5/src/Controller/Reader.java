/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pet;
import Model.PetShop;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sonya
 */
public class Reader {
    //Returns an arraylist of pets
    public static ArrayList<Pet> getAllPets()
    {
        //An arraylist will be used to store pets.
        ArrayList<Pet> petList = new ArrayList();
        try{
            //A scanner is used to read the CSGV file
            Scanner scannerPet = new Scanner(new File("src/Files/Pets.csv"));
            //A comma will be used to seperate data in each row 
            scannerPet.useDelimiter(",");
            while(scannerPet.hasNextLine())
            {
                //Each bit of data will be assigned to a variable
                String shop = scannerPet.next();
                String type = scannerPet.next();
                String price = scannerPet.next();
                    double dPrice = Double.parseDouble(price);
                String dateAquired = scannerPet.next();
                String notes = scannerPet.next();
                
                //The variables are passed into a constructor to create an instance of a Pet
                Pet pet = new Pet(shop, type, dPrice, dateAquired, notes);
                //The object is added to the arraylist
                petList.add(pet);
                
                //Read the nexxt line
                scannerPet.nextLine();
            }
        }catch(Exception ex){
            System.out.println("File could not be found");
        }
        return petList;
    }

    //A Search System
    public ArrayList<String> Search(String keyword, ArrayList data) {
        ArrayList<String> result = new ArrayList();
        for (int i = 0; i < data.size(); i++) {
            String item = data.get(i).toString().toUpperCase();
            if (keyword.length() == 0) {
                result.add("Please enter a keyword");
                i = data.size();
            } else if (keyword.toUpperCase().equals(item)) {
                result.add(item);
            } else {
                int stopAt = item.length() - keyword.length();
                for (int j = 0; j < stopAt + 1; j++) {
                    int k = keyword.length() + j;
                    String sub = item.substring(j, k).toUpperCase();
                    if (sub.equals(keyword.toUpperCase())) {
                        result.add(item);
                        //stop iterating through the letters of this string, to prevent it from appearing on the results more than once
                        j = stopAt;
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add("No Results Found");
        }
        return result;
    }
 
    public ArrayList<String> searchPet(String keyword)
    {
        ArrayList<String> result = Search(keyword, Reader.getAllPets());
        return result;
    }
    
    //Returns an arraylist of stores
    public ArrayList<PetShop> getAllStores()
    {
        //An arraylist will be used to store shops
        ArrayList<PetShop> storeList = new ArrayList();
        try{
            //A scanner is used to read the CSGV file
            Scanner scannerStore = new Scanner(new File("src/Files/Stores.csv"));
            //A comma will be used to seperate data in each row 
            scannerStore.useDelimiter(",");
            while(scannerStore.hasNextLine())
            {
                //Each bit of data will be assigned to a variable
                String name = scannerStore.next();
                String address = scannerStore.next();
                String phoneNumbers = scannerStore.next();
                String website = scannerStore.next();
                String openingTimes = scannerStore.next();
                
                //The variables are passed into a constructor to create an instance of a store
                PetShop store = new PetShop(name, address, phoneNumbers, website, openingTimes);
                 //The object is added to the arraylist
                storeList.add(store);
                
                //Read the nexxt line
                scannerStore.nextLine();
            }
        }catch(Exception ex){
            System.out.println("File could not be found");
        }
        return storeList;
    }
    
    public ArrayList<String> searchPetShop(String keyword)
    {
       ArrayList<String> result = Search(keyword, getAllStores());
        return result;
    }
    
    public ArrayList<String> getSearchHistory()
    {
        ArrayList<String> searchHistory = new ArrayList();
        try{
            Scanner scanner = new Scanner(new File("src/Files/searchHistory.csv"));
            while(scanner.hasNextLine())
            {
                String keyword = scanner.nextLine();
                searchHistory.add(keyword);
            }
        }catch(Exception ex){
            System.out.println("File could not be found");
        }
        return searchHistory;
    }
    
}
