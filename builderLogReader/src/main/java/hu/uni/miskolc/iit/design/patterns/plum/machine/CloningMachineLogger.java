package hu.uni.miskolc.iit.design.patterns.plum.machine;

import java.util.Date;

/**
 * Created by tothzs on 2018.03.05..
 */
public class CloningMachineLogger {

    public void logMachine(CloningMachine machine){
        System.out.println(String.format(
                "# LOG of %s created by %s at %s",
                machine.getMachineId(),
                CloningMachineLogger.class.getName(),
                new Date().toString()));
        System.out.println("#");
        System.out.println("#");
        System.out.println("#");
        System.out.println("#");
        System.out.println(String.format("Id.: %s",machine.getMachineId()));
        System.out.println(String.format("Last Maintenance was: %s",machine.getLastMaintenance().toString()));
        System.out.println("Is it over maintenance period: "+(new Date()).after(new Date(machine.getLastMaintenance().getTime()+machine.getMaintenancePeriod())));
        System.out.println(String.format("Contact Person %s <%s>",machine.getCorrespondingEmployee().getName(),machine.getCorrespondingEmployee().getEmail()));
        System.out.println("Description: "+machine.getDescription());
        System.out.println("Current Status: "+machine.getStatus());
        System.out.println("#");
        System.out.println("# History");
        System.out.println("#");
        for(Event event : machine.getHistory()){
            System.out.println(String.format(
                    "%d. %d. %d. %d:%d:%d;%d;%s",
                    event.getDate().getYear()+1900,
                    event.getDate().getMonth()+1,
                    event.getDate().getDay()+1,
                    event.getDate().getHours(),
                    event.getDate().getMinutes(),
                    event.getDate().getSeconds(),
                    event.getCode(),
                    event.getDescription()
                    ));
        }
    }
}
