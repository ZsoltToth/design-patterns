package hu.uni.miskolc.iit.design.patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tothzs on 2018.03.05..
 *
 * This machine class was created based on the review of numerous log files.
 *
 * This machine is meant to represent a machine based on its LOG.
 * It has to be instantiated via the {@link MachineBuilder}.
 */
public class Machine {

    private Map<String, String> properties;
    private List<EvetRecord> history;

    protected Machine(){
        this.properties = new HashMap<String, String>();
        this.history = new ArrayList<EvetRecord>();
    }
}
