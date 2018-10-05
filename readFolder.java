package exe_0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class readFolder extends ReadWritOnly{
	private File folder;

	public readFolder(String folderPathName){

		this.folder = new File(folderPathName);
	}	

	public readFolder() {
		// TODO Auto-generated constructor stub
	}

	public File[] filterCSV(){
		//Implementing FilenameFilter to retrieve only csv files

		FilenameFilter csvFileFilter = new FilenameFilter()
		{    
			@Override
			public boolean accept(File dir, String name)
			{
				if(name.endsWith(".csv"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		};
		//Passing txtFileFilter to listFiles() method to retrieve only csv files
		File[] files = folder.listFiles(csvFileFilter);
		return files;
	}
	public static  String MergeFiles(File[] files) throws IOException {
		//readFolder a = new readFolder("C:/Users/barak/Desktop/ex0/");
		//File [] b = a.filterCSV();	
		
		String MergedFile="";
		String str="";
		String str1 = "";
		FileReader ar = new FileReader(files[0]);
		BufferedReader r = new BufferedReader(ar);	
		
		str1 = r.readLine()+"\n";
		str1 += r.readLine()+"\n";
		r.close();
		for(int i=0;i<files.length;i++) {
			FileReader fr = new FileReader(files[i]);
			BufferedReader br = new BufferedReader(fr);	
			
			str = br.readLine();
			str = br.readLine();
			str = br.readLine();
			while(str!=null) {
				str1+=str+"\n";
				str =br.readLine();
			}
		 //writeFile("C:/Users/user/Desktop/newfile.csv");
		MergedFile = MergedFile + str1; 
		
		br.close();
		fr.close();
		
		} 
	
		
		System.out.println(MergedFile);
		return MergedFile;
		
	}
	public static void writeMergedFiles(String s) {
		try
		{
			FileWriter fw = new FileWriter("C:/Users/user/Desktop/files/emek/MergedFiles.csv");
			PrintWriter outs = new PrintWriter(fw);
			
				outs.println(s);
			
			outs.close();
		}
		catch(IOException ex) 
		{
			System.out.print("Error writing file\n" + ex);
		}
	}
	/*public static void main(String[] args) throws IOException {
		readFolder a = new readFolder("C:/Users/user/Desktop/files/");
		File [] b = a.filterCSV();
//		String m = MergeFiles(b);
		System.out.println(Arrays.toString(b));
	}
		System.out.println(m);
		 
	//	PrintWriter out = new PrintWriter("C:/Users/user/Desktop/files/new");
		//out.println(m);
		//out.close();
	}*/
}
