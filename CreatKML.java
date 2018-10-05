
package exe_0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class CreatKML extends ReadWritOnly{

	public CreatKML() {
		super();
	}
	
	
	
public void writeFileKML( Vector<Vector<Network>> a, String output) {
    ArrayList<String> content = new ArrayList<String>();
    
    String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n";
    content.add(kmlstart);

    String kmlend = "</kml>";
    try{
        FileWriter fw = new FileWriter(output);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 1; i < a.size(); i++) {
           
            String kmlelement = "<Document>"+"<Placemark>\n" +
                    "<name>"+this.getNets().get(i).get(0).getId()+"</name>\n" +
                    "<description>"+this.getNets().get(i).get(0).getSsid()+"</description>\n" +
                    "<Point>\n" +
                    "<coordinates>"+Double.toString(this.getNets().get(i).get(0).getLat())+","+Double.toString(this.getNets().get(i).get(0).getLon())+"</coordinates>" +
                    "</Point>\n" +
                    "</Placemark>\n"+" <Document>";
            content.add(kmlelement);
        }
        content.add(kmlend);
        String csv = content.toString().replaceAll(",", "").replace("[", "").replace("]", "");
        bw.write(csv);
        bw.close();
    } 
    catch (IOException e) {
        e.printStackTrace();
    }
}
}