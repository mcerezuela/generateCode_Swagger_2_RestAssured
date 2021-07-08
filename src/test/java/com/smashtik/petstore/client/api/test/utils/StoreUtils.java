package com.smashtik.petstore.client.api.test.utils;

import com.smashtik.petstore.client.model.Order;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreUtils {
    static boolean debug = false;
    static private List<Order> orderList = new ArrayList<>();

    public static List<Order> getOrderList() {
        return orderList;
    }


    public static void addOrders(Order[]orders){
        orderList.addAll(Arrays.asList(orders));
    }

    public static Order createRandomOrder(){
        Order newOrder = new Order();
        newOrder.setPetId(PetUtils.getRandomPet().getId());
        newOrder.setQuantity(generateRandomNumber(100,0));
        newOrder.setShipDate(generateShipDate(2));
        newOrder.setStatus(generateRandomStatus());
        newOrder.setComplete(5>=CommonUtils.generateCommonRandomNumber(10,0));
        Order[] tempArray = {newOrder};
        addOrders(tempArray);
        return newOrder;
    }

    private static Order.StatusEnum generateRandomStatus() {
        Order.StatusEnum[] values = Order.StatusEnum.values();
        return values[CommonUtils.generateCommonRandomNumber(values.length,0)];
    }

    private static OffsetDateTime generateShipDate(int i) {
        OffsetDateTime dateTime = OffsetDateTime.now(ZoneOffset.ofHours(i));
        if(debug)System.out.println("DATE: "+dateTime);
        return dateTime;
    }

    private static int generateRandomNumber(int max, int min){
        return CommonUtils.generateCommonRandomNumber(max, min);
    }
}
