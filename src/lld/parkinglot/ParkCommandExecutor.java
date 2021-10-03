package lld.parkinglot;

public class ParkCommandExecutor extends CommandExecutor{

    ParkingLotService parkingLotService;

    public ParkCommandExecutor(ParkingLotService parkingLotService){
        super(parkingLotService);
    }

    private final String commandId="PARK";


    @Override
    public String getCommandId() {
        return commandId;
    }

    @Override
    public void execute(Command command) {

    }

    @Override
    public boolean isValid(Command command) {
        return false;
    }
}
