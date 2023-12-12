package com.zafar.javapractice.designpattern;

public final class RoomBuilder {
    private String name;
    private int area;
    private int price;
    private boolean isFurnished;
    private String roomTyp;
    private String location;
    private boolean isBooked;

    private RoomBuilder() {
    }

    public RoomBuilder(String name, int area, int price, boolean isFurnished, String roomTyp, String location, boolean isBooked) {
        this.name = name;
        this.area = area;
        this.price = price;
        this.isFurnished = isFurnished;
        this.roomTyp = roomTyp;
        this.location = location;
        this.isBooked = isBooked;
    }

    public static RoomBuilder aBuilderRoom() {
        return new RoomBuilder();
    }

    public RoomBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public RoomBuilder withArea(int area) {
        this.area = area;
        return this;
    }

    public RoomBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public RoomBuilder withIsFurnished(boolean isFurnished) {
        this.isFurnished = isFurnished;
        return this;
    }

    public RoomBuilder withRoomTyp(String roomTyp) {
        this.roomTyp = roomTyp;
        return this;
    }

    public RoomBuilder withLocation(String location) {
        this.location = location;
        return this;
    }

    public RoomBuilder withIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
        return this;
    }

    public RoomBuilder build() {
        return new RoomBuilder(name, area, price, isFurnished, roomTyp, location, isBooked);
    }
}
