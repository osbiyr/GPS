package exe_0;

import java.io.*;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * 
 * @author Barak yehuda gortler
 * @version 1.3 last update  made on 13/11/2017 
 * in this update we use the arrayList "nets" with constructors instead of static arrayList
 * 
 * the last update include:
 * new exception will file is not "CSV" type (Lines 69-72)
 * fix bug of wrong Coordinates (insert String Constants into while loop Line 36);
 * 
 */
public class ReadWritOnly 
{
	private Vector<Vector<Network>> nets; //networks in A list
	
	
	public ReadWritOnly() {
		this.nets = new Vector<Vector<Network>>();
	}

	public Vector<Vector<Network>> getNets() {
		return this.nets;
	}
	public void setNets(Vector<Vector<Network>> nets) {
		this.nets = new Vector<>(nets);
	}

	/**
	 * 
	 * @param fileName writes the file in the path of fileName in a csv formation
	 */
	public void writeFile(String fileName)	
	{
		// try write to the file
		try 
		{
			FileWriter fw = new FileWriter(fileName);
			PrintWriter outs = new PrintWriter(fw);
			String line1 = "Time,ID,Lat,Lon,Alt,Wifi networks,";
			for (int i = 1; i < 11; i++) 
			{
				line1 += "SSID"+i+",MAC"+i+",Frequncy"+i+",Signal"+i+",";
			}
			outs.println(line1);		//write the first line of the file
			int index = 0;				//will choose the nets in place index
			while(index<this.getNets().size())
			{	

				String Constants = this.getNets().get(index).get(0).Time_Id_Location();
				Collections.sort(this.getNets().get(index));	//sort nets.get(index)
				String afterConstants = "";				
				int numberOfNetworks = 0;

				for (int i = 0; i < 10 && i<this.getNets().get(index).size(); i++) 
				{
					numberOfNetworks++;
					afterConstants += this.getNets().get(index).get(i).toString();
				}
				outs.println(Constants +","+ numberOfNetworks +"," + afterConstants );
				numberOfNetworks = 0;
				index++;
			}

			outs.close();
		}
		
		catch(IOException ex) 
		{
			System.out.print("Error writing file\n" + ex);
		}
	}

	/**
	 * 
	 * @param fileName
	 
	 */
	public void readFile (String fileName) throws Exception
	{
		try 				// try read from the file
		{
			//if(!(fileName.substring(fileName.length()-3).equalsIgnoreCase("csv")))
			//if(!(fileName.endsWith(".csv")))
			//{
			//throw new Exception("Not CSV file!");
			//}
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			str = br.readLine();
			str = br.readLine();

			int index = 0;
			String [] temp = str.split(",");
			String correntTime = temp[3];

			this.getNets().add(new Vector<Network>());

			while(str!=null)
			{
				String [] fileLine = str.split(",");
				if(fileLine[10].equals("WIFI"))
				{	
					Network tempNet = new Network(fileLine[3], fileLine[2],Double.valueOf(fileLine[6]), Double.valueOf(fileLine[7]),
							Double.valueOf(fileLine[8]),fileLine[1],fileLine[0],Double.valueOf(fileLine[4]),
							Integer.valueOf(fileLine[5]),fileLine[10]);
					if(tempNet.getTime().equals(correntTime))
					{						
						this.getNets().get(index).add(tempNet);
					}
					else
					{
						this.getNets().add(new Vector<Network>());
						index++;
						this.getNets().get(index).add(tempNet);
						correntTime = tempNet.getTime();
					}
				}
				str = br.readLine();	
			}
			for(int i=0;i<this.getNets().size();i++) {
			Collections.sort(this.getNets().get(i));
			}
			br.close();
		}
		catch(IOException ex) 
		{
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}
	
	public int TimeToInt (String s){
		String [] helparr=s.split(":");
		String s1= helparr[0]+helparr[1]+helparr[2];
		int stringtoint = Integer.parseInt(s1);
		return stringtoint;
	}
	
	public void locationFilter() {
		// TODO Auto-generated method stub
	}

	public void timeFilter() {
		// TODO Auto-generated method stub
		
	}
}	
