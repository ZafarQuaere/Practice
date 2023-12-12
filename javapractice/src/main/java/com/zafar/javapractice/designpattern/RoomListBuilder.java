package com.zafar.javapractice.designpattern;

import java.util.ArrayList;
import java.util.List;

public class RoomListBuilder {
    private List<Room> roomList;

    public RoomListBuilder addList(){
        roomList = new ArrayList<>();
        return this;
    }

    public RoomListBuilder addRoom(Room room){
        roomList.add(room);
        return this;
    }


}
