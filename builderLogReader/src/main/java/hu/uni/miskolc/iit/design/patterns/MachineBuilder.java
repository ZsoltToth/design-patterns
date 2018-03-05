package hu.uni.miskolc.iit.design.patterns;

import hu.uni.miskolc.iit.design.patterns.Machine;

import java.io.File;

/**
 * Created by tothzs on 2018.03.05..
 */
public abstract class MachineBuilder {

    public abstract Machine build(File logFile);
}
