package hu.uni.miskolc.iit.design.patterns.plum.machine;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tothzs on 2018.03.05..
 */
public class CloningMachineLoggerTest {

    @Test
    public void test() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date produced = df.parse("1999-12-12 12:00:00");
        Date lastMaintenance = df.parse("2012-02-03 23:02:32");
        long maintenancePeriod = 1000 * 60 * 60 * 24* 100;
        String description = "" +
                "Lorem ipsum dolor sit amet, nulla commodo nonummy lobortis amet, nec arcu nulla eget magna id vel, ut congue vestibulum scelerisque dolor et massa, eu elit pede in etiam perspiciatis non, placerat faucibus taciti vestibulum tempus. Eget eu cras tortor quam odio nostrud, faucibus magna morbi sit cras, semper mattis libero id in, aliquet ut orci mus fringilla non. Nonummy magna proin augue, placerat ligula, orci ultricies tortor in pharetra arcu velit, leo nunc duis magna orci quis at. Velit ut ante semper, ornare in nunc pellentesque vitae leo rutrum, dolor augue, nonummy vestibulum. Donec commodo sit, lacus diam consequat amet, velit tortor nunc amet turpis sapien at, dui suspendisse. Non purus elit sem, consectetuer nunc, tincidunt libero et lorem interdum, tellus lacinia justo pede fringilla arcu. Quisque scelerisque congue. Quam libero ultrices at interdum, eu eget vivamus faucibus amet pharetra congue. Ligula vehicula vivamus eget, fringilla praesent non vel consequat. Rhoncus praesent.\n" +
                "\n" +
                "Donec suspendisse luctus arcu vel pede sem, nullam tellus id bibendum bibendum, quas mi eros mauris, libero lorem gravida dolore at elit tortor. Elit orci neque pharetra viverra fermentum neque, aenean feugiat amet auctor nulla donec ultricies. Consequat velit id, volutpat turpis quis pellentesque molestie nec, pellentesque velit nec, quis integer blandit, lorem mollis wisi tristique est eget. Quam at at nullam adipiscing, dolor consequatur congue dui nisl, venenatis donec velit porttitor venenatis dui. Ullamcorper aliquet a condimentum magna placerat, mauris curabitur, donec eget sed quis. Mauris mauris malesuada felis cum vestibulum urna, sit eros id donec rutrum diam amet, ipsum pellentesque et, sit posuere id id, accumsan nec. Sem magna libero. Aliquet accumsan auctor quis voluptates volutpat euismod, aenean lacinia nec porttitor, aliquam euismod cubilia amet lectus blandit cras. Gravida nec libero integer, fusce dolor, dolor bibendum elit quis.\n" +
                "\n" +
                "Duis eget orci, felis viverra turpis, nisl in rutrum, ipsum tristique velit et, vitae justo lobortis malesuada felis. Ultricies amet gravida dui erat consectetuer, erat ante suspendisse ac arcu, vestibulum rhoncus, in pretium purus pellentesque. Faucibus pellentesque ultricies eget ultricies, amet justo, amet turpis imperdiet adipiscing, metus ridiculus maecenas semper sit cum malesuada. Sed eros sapien fusce erat ut quam. Est integer dapibus venenatis dolor nulla, turpis fringilla nibh tellus, eum mollis sagittis vestibulum. Quis sit mattis eget scelerisque, et turpis at. Sodales dictum, diam nobis ultricies irure sed, pulvinar neque arcu gravida ipsum orci, nibh vitae eu ut metus molestie eleifend.\n" +
                "\n" +
                "Dui magna a dictum urna lobortis, aliquam suspendisse a wisi consequat. Fringilla wisi etiam maecenas neque, nullam montes phasellus parturient, dui non urna neque, ut et accumsan pellentesque erat quis ultricies, arcu per in elit in. Elementum ut dui duis, auctor mauris amet ut eget quia aenean. Pede lorem odio diam sagittis, potenti augue. Et elit aliquam id velit pulvinar lorem, quis nullam suspendisse hendrerit aliquam pede. In non, metus diam enim pede fames vestibulum. Auctor metus laoreet enim sed felis, tempus vitae nulla eget, donec semper in feugiat, nam cursus maecenas facilisis, maecenas turpis porttitor. Sodales at vehicula dolor velit mauris dui, mi morbi ac, nec ipsum ornare pede et bibendum." +
                "";
        Employee correspondingEmployee = new Employee("John Doe", "john.doe@plum.com");

        CloningMachine machine = new CloningMachine(
                "machine1",
                produced,
                lastMaintenance,
                maintenancePeriod,
                description,
                correspondingEmployee);
        CloningMachineLogger logger = new CloningMachineLogger();
        machine.cloneLamb(df.parse("2000-01-01 12:01:02"),"Dooly");
        machine.cloneLamb(df.parse("2000-03-01 12:01:02"),"Dooly");
        machine.breakDown(df.parse("2003-09-12 12:23:32"));
        machine.fixMe(df.parse("2003-09-12 13:23:32"));
        machine.cloneLamb(df.parse("2003-01-01 12:01:02"),"Dooly");
        machine.cloneLamb(df.parse("2000-02-01 12:01:02"),"Dooly");
        machine.cloneLamb(df.parse("2010-01-01 12:01:02"),"Dooly");
        machine.cloneLamb(df.parse("2003-11-01 12:01:02"),"Dooly");

        logger.logMachine(machine);
//        System.out.println("hello world");
    }
}
