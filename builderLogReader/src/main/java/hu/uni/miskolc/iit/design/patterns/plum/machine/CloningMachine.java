package hu.uni.miskolc.iit.design.patterns.plum.machine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by tothzs on 2018.03.05..
 * Cloning machine of the Plum company.
 */
public class CloningMachine {

    private enum MachineCodes{
        STARTED(1),
        WORKSTARTED(2),
        WORK_FINISHED_SUCCESSFULLY(4),
        SHIT_HAPPENED(8),
        MAINTENANCE_STARTED(16),
        MAINTENANCE_FINISHED(32);

        private final int code;

        MachineCodes(int code) {
            this.code = code;
        }
        private int code(){return code;}
    }

    public enum Status {
        CLONING_LAMB,
        CLONING_HUMAN_IN_SECRET,
        UNDER_MAINTENANCE,
        WAITING;
    }

    private String machineId;
    private Date produced;
    private Date lastMaintenance;
    private long maintenancePeriod;
    private String description;
    private Employee correspondingEmployee;
    private Status status;

    private Collection<Event> history;

    public CloningMachine(String machineId, Date produced, Date lastMaintenance, long maintenancePeriod, String description, Employee correspondingEmployee) {
        this.machineId = machineId;
        this.produced = produced;
        this.lastMaintenance = lastMaintenance;
        this.maintenancePeriod = maintenancePeriod;
        this.description = description;
        this.correspondingEmployee = correspondingEmployee;
        this.status = Status.WAITING;
        this.history = new ArrayList<Event>();
    }

    protected String getMachineId() {
        return machineId;
    }

    protected Date getProduced() {
        return produced;
    }

    protected Date getLastMaintenance() {
        return lastMaintenance;
    }

    protected long getMaintenancePeriod() {
        return maintenancePeriod;
    }

    protected String getDescription() {
        return description;
    }

    protected Employee getCorrespondingEmployee() {
        return correspondingEmployee;
    }

    protected Status getStatus() {
        return status;
    }

    protected Collection<Event> getHistory() {
        return history;
    }

    public void cloneLamb(Date date, String lambName){
        this.history.add(new Event(date, MachineCodes.WORKSTARTED.code(), String.format("Cloning of lamb named: %s has started",lambName)));
        this.history.add(new Event(new Date(date.getTime() + 1000 * 60* 60 * 24), MachineCodes.WORK_FINISHED_SUCCESSFULLY.code(), String.format("The lamb named %s has been cloned!",lambName)));
    }

    public void breakDown(Date date){
        this.history.add(new Event(date, MachineCodes.SHIT_HAPPENED.code(), String.format("Machine %s has been broken down at %s",machineId,date.toString())));
    }

    public void fixMe(Date date){
        this.history.add(new Event(date, MachineCodes.MAINTENANCE_STARTED.code(), String.format("The maintenance of machine %s has started",machineId)));
        this.history.add(new Event(new Date(date.getTime()+1000*60*60*6), MachineCodes.MAINTENANCE_STARTED.code(), String.format("The maintenance of machine %s has started",machineId)));
    }
}
