package lld.parkinglot;

public class Slots {
    private String slotId;
    private SlotState slotState;
    private Vehicle                                                                                                                                                                                                                                                                                                                                                                                                                                  vehicle;

    public boolean isFree(){
        if(slotState.equals(SlotState.FREE)){
            return true;
        }else{
            return false;
        }
    }



    public boolean parkVehicle(Vehicle v){
        this.vehicle=v;
        this.slotState=SlotState.FULL;
        return true;
    }
}
