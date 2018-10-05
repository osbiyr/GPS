package exe_0;

import java.io.File;

public class test extends readFolder{
	public static void main(String[] args) throws Exception {
	/*	
		35.25
		35.26
		500.9
		556.9
		32.14
		32.19
		08:20:42
		08:21:08
		*/
		
		ReadWritOnly t=new csvFilters();
		
		readFolder a = new readFolder("C:/Users/user/Desktop/files/");
		File [] b = a.filterCSV();
		String m = MergeFiles(b);
		System.out.println(m);
		writeMergedFiles(m);
		t.readFile("C:/Users/user/Desktop/files/emek/MergedFiles.csv");
		//t.locationFilter();
		//t.timeFilter();
	//	t.writeFile("C:/Users/user/Desktop/files/emek/new.csv");
			
	}
}
