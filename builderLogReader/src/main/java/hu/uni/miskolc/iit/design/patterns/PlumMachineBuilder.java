package hu.uni.miskolc.iit.design.patterns;

import java.io.*;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by tothzs on 2018.03.05..
 */
public class PlumMachineBuilder extends MachineBuilder{
    public Machine build(File logFile) {
        Machine machine = new Machine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(logFile));
            String line = null;
            boolean isHistory = false;
            while((line = reader.readLine()) != null){
                if(!isHistory){
                    if(line.startsWith(""+getCommentChar())){
                        if(line.contains("History")){
                            isHistory = true;
                        }
                        continue;
                    }
                    if(line.contains(""+getFieldSeparator())){
                        String[] fields = line.split(""+getFieldSeparator());
                        machine.setProperty(
                                fields[0],
                                fields[1]
                        );
                    }
                }
                else {
                    if (line.startsWith("" + getCommentChar())) {
                        continue;
                    }
                    EventRecord record = parseEventRecord(line);
                    if (record != null) {
                        machine.addHistoryRecord(record);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return machine;
    }

    private EventRecord parseEventRecord(String line){
        String[] fields = line.split(";");
        if(fields.length == 3) {

            try {
                Date occured = getDateFormat().parse(fields[0]);
                return new EventRecord(occured, fields[2]);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
