package com.zafar.javapractice.designpattern;

public class BuilderDpExample {
    public static void main(String[] args) {

        RoomBuilder room = RoomBuilder.aBuilderRoom()
                .withName("Zafar")
                .withArea(10)
                .withPrice(100)
                .withIsFurnished(true)
                .withRoomTyp("Single")
                .build();
    }
}
