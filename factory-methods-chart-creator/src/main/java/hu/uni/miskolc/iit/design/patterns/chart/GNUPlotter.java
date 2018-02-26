package hu.uni.miskolc.iit.design.patterns.chart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by tothzs on 2018.02.26..
 */
public class GNUPlotter extends ChartPlotter{

    private static final String GENERATED_FILE_NAME = "generated.png";

    public GNUPlotter(int width, double height, ImageFormats outputFormat) {
        super(width, height, outputFormat);
    }

    public Image plot(Chart chart) throws UnableToPlotException {
        try {
            File tmpDir = new File("gnuplotTmp"); //File.createTempFile("gnuplotTmp","");
            if(!tmpDir.exists()) {
                if (!tmpDir.mkdir()) {
                    throw new IOException("Unable to create " + tmpDir.getAbsolutePath());
                }
            }

            File dataFile = writeDataFile(tmpDir,chart);
            File scriptFile = createScriptFile(tmpDir,chart, dataFile);
            Runtime rt = Runtime.getRuntime();
            Process process = rt.exec("gnuplot "+scriptFile.getAbsolutePath());
            BufferedReader b = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            System.out.println("Result");
            while ((line = b.readLine()) != null) {
                System.out.println(line);
            }

            b.close();
            File generatedImage = new File(tmpDir.getAbsolutePath()+File.separator+GENERATED_FILE_NAME);
            System.out.println(generatedImage.exists());
            Image result = ImageIO.read(generatedImage);
            return result;

        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToPlotException(e);
        }
    }

    private File writeDataFile(File tmpDir, Chart chart) throws IOException {
        File result = new File(tmpDir.getAbsolutePath()+File.separator+"data.csv");
        FileWriter writer = new FileWriter(result);
        writer.write(chart.lookupTable());
        writer.close();
        return result;
    }

    private File createScriptFile(File tmpDir, Chart chart, File dataFile) throws IOException {
        File result = new File(tmpDir.getAbsolutePath()+File.separator+"script.gp");
        FileWriter writer = new FileWriter(result);
        if(this.getOutputFormat() == ImageFormats.PNG) {
            writer.write("set terminal png\n");
            writer.write("set output \""+tmpDir.getName()+File.separator+GENERATED_FILE_NAME+"\"\n");
        }
        writer.write("plot ");
        for(int i = 0; i < chart.getFunctions().size(); i++){
            if(i!=0){
                writer.append(", ");
            }
            writer.append("\""+dataFile.getAbsolutePath()+"\" using 1:"+(i+2)+" with lines");
        }
        writer.close();
        return result;
    }
}
