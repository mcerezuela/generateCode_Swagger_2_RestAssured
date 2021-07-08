package com.smashtik.petstore.client.api.test.utils;

import com.smashtik.petstore.client.model.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PetUtils {
    static boolean debug = false;
    static private List<Pet> petList = new ArrayList<>();

    public static List<Pet> getPetsList() {
        return petList;
    }

    public static void addPets(Pet[] petsBystatus) {
        petList.addAll(Arrays.asList(petsBystatus));
    }

    public static Pet createNewPet() {
        if(petList.isEmpty()){
            return null;
        }else{
            Pet newPet = new Pet();
            newPet.setId((long) generateRandomNumber(100000,0));
            newPet.setCategory(petList.get(generateRandomNumber(petList.size(),0)).getCategory());
            newPet.setName(petList.get(generateRandomNumber(petList.size(),0)).getName());
            newPet.setPhotoUrls(petList.get(generateRandomNumber(petList.size(),0)).getPhotoUrls());
            newPet.setTags(petList.get(generateRandomNumber(petList.size(),0)).getTags());
            newPet.setStatus(petList.get(generateRandomNumber(petList.size(),0)).getStatus());
            if(debug)System.out.println("Pet Candidate: "+newPet);
            return newPet;
        }
    }

    public static Pet modifyRandomPet() {
        Pet randomPet = getRandomPet();
        if(debug)System.out.println("Pet To Modify: "+randomPet);
        randomPet.setCategory(petList.get(generateRandomNumber(petList.size(),0)).getCategory());
        randomPet.setName(petList.get(generateRandomNumber(petList.size(),0)).getName());
        randomPet.setPhotoUrls(petList.get(generateRandomNumber(petList.size(),0)).getPhotoUrls());
        randomPet.setTags(petList.get(generateRandomNumber(petList.size(),0)).getTags());
        randomPet.setStatus(petList.get(generateRandomNumber(petList.size(),0)).getStatus());
        if(debug)System.out.println("Pet Modified: "+randomPet);
        return randomPet;
    }

    public static Pet getRandomPet() {
        return petList.get(generateRandomNumber(petList.size(),0));
    }

    private static int generateRandomNumber(int max, int min){
        return CommonUtils.generateCommonRandomNumber(max, min);
    }
}
