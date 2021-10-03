package lld.parkinglot;

import java.util.List;
import java.util.Optional;

public class ParkingLotService {

    List<Slots> parkingslots;

    public ParkingLotService(List<Slots> parkingslots){
        this.parkingslots=parkingslots;
    }


    public void parkMyVehicle(Vehicle vehcile){
         //get free slots
        Optional<Slots> slots=parkingslots.stream().filter(allslots -> allslots.isFree()).findFirst();
        if(slots.isPresent()){
            slots.get().parkVehicle(vehcile);
        }else{
            System.out.println("No slot is free , i am sorry");
        }
    }

}
