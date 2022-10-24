package za.ac.cput.factory;

import za.ac.cput.domain.HospitalRoom;
import za.ac.cput.util.StringHelper;

/*
    HospitalRoomFactory.java
    Factory for Hospital Rooms
    Author: Fayaad Abrahams (218221630)
    Date: 12 August 2022
*/
public class HospitalRoomFactory {
    public static HospitalRoom createHospitalRoom(String roomID, int roomFloor) {
        StringHelper.checkStringParam("roomId", roomID);
        return new HospitalRoom.Builder().roomID(roomID).roomFloor(roomFloor).build();
    }
}
