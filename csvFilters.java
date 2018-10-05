package exe_0;

import java.util.Scanner;
/**
 * 
 * @author ohadj
 *
 */
public class csvFilters extends ReadWritOnly{
	static Scanner input;
	
	public csvFilters(){
		super();
	}
	/**
	 * filter a csv file of networks list by an Id filter
	 */
	public void IdFilter() {
		System.out.println("Type the id you want to save:");
		input = new Scanner(System.in);
		String id = "["+input.nextLine()+"]";
		if(this.getNets()!=null){
			for (int i = 0; i < this.getNets().size(); i++) {
				if(!(this.getNets().get(i).get(0).getId().equals(id))){
					this.getNets().remove(i);
					i--;
				}
			}
		}
	}

	@Override
	/**
	 *  filter a csv file of networks list by a location parameters filter
	 */
	public void locationFilter()
	{
		input = new Scanner(System.in);
		System.out.println("Please enter the location coordinate you want to save by flow:");
		System.out.println("enter minlon:");
		Double minLon=input.nextDouble();
		
		System.out.println("enter maxlon:");
		input=new Scanner(System.in);
		Double maxLon=Double.valueOf(input.nextLine());
		
		System.out.println("enter minalt:");
		input=new Scanner(System.in);
		Double minalt=input.nextDouble();
		
		
		System.out.println("enter maxalt:");
		input =new Scanner(System.in);
		Double maxalt=input.nextDouble();
		
		
		System.out.println("enter minlat:");
		input=new Scanner(System.in);
		Double minlat=input.nextDouble();
		
		
		System.out.println("enter maxlat:");
		input=new Scanner(System.in);
		Double maxlat=input.nextDouble();
		
				
		for(int i=0;i<super.getNets().size();i++)
		{
			
			if(super.getNets().get(i).get(0).getLon()<minLon || super.getNets().get(i).get(0).getLon()>maxLon || super.getNets().get(i).get(0).getLat()<minlat || super.getNets().get(i).get(0).getLat()>maxlat||super.getNets().get(i).get(0).getAlt()<minalt||super.getNets().get(i).get(0).getAlt()>maxalt)
			{
				super.getNets().remove(i);
				i--;
			}
		}
		
	}
	
	
	@Override
	/**
	 * filter a csv file of networks list networks list by a time range filter
	 */

	public void timeFilter() {
		System.out.println("Type the time you want to strat saving from :");
		input = new Scanner(System.in);
		String timeStart = input.nextLine();
		System.out.println("Type the time you want to end saving from :");
		input = new Scanner(System.in);
		String timeEnd = input.nextLine();
		int time1=TimeToInt(timeStart);
		int time2=TimeToInt(timeEnd);
		System.out.println(time1);
		System.out.println(time2);
		int count=0;
		if(this.getNets()!=null){
			for (int i = 0; i < this.getNets().size(); i++) {
				
				String [] helparr=getNets().get(i).get(0).getTime().substring(11).split(":");
				String s= helparr[0]+helparr[1]+helparr[2];
				int currenttime = Integer.parseInt(s);
				System.out.println(currenttime);
				if(currenttime<time1 || currenttime>time2){
					count++;
					this.getNets().remove(i);
					i--;
				}
			}
			System.out.println(count+"count");
		}
	}
	
}
