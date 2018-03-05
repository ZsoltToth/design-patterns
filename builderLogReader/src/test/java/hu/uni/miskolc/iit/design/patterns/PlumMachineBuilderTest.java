package hu.uni.miskolc.iit.design.patterns;

import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * Created by tothzs on 2018.03.05..
 */
public class PlumMachineBuilderTest {
    @Test
    public void build() throws Exception {
        MachineBuilder builder = new PlumMachineBuilder();
        builder.setDateFormat(new SimpleDateFormat("yyyy.MM.dd. hh:mm:ss"));
        Machine machine = builder.build(new File("PlumCloningMachnie00.log"));
        System.out.println(machine);
    }

}