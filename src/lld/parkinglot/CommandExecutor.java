package lld.parkinglot;

public abstract class CommandExecutor {
     protected ParkingLotService parkingLotService;

     public CommandExecutor(ParkingLotService parkingLotService) {
          this.parkingLotService = parkingLotService;
     }

     abstract String getCommandId();
     abstract void execute(Command command);
     abstract boolean isValid(Command command);
}
