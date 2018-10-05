package exe_0;
/**
 * 
 * @author ohad
 *
 */

public class Network implements Comparable<Network>
{

	//date and time
	private String timeAndDate;
	private String id;
	
	//geography data
	private double lat;
	private double lon;
	private double alt;

	//networks information
	private String ssid;
	private String mac;
	private double frequncy;
	private int signal;


	private String type;


	//constructors
	/**
	 * 
	 * @param net the object net recive location information and wifi information
	 */
	public Network(String time,String id,double lat, double lon,double alt,String ssid,String mac,
			double frequncy,int signal,String type) 
	{
		this.timeAndDate = time;
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.ssid = ssid;
		this.mac = mac;
		this.frequncy = frequncy;
		this.signal = signal;
		this.type = type;		
	}

	/**
	 * 
	 * @param get net info and do a deep copygg
	 */
	public Network(Network net) 
	{
		this.timeAndDate = net.timeAndDate;
		this.id = net.id;
		this.lat = net.lat;
		this.lon = net.lon;
		this.alt = net.alt;
		this.ssid = net.ssid;
		this.mac = net.mac;
		this.frequncy = net.frequncy;
		this.signal = net.signal;
		this.type = net.type;
	}

	//Getters
	public String getTime() {
		return timeAndDate;
	}
	
	public String getId() {
		return id;
	}
	
	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public double getAlt() {
		return alt;
	}

	public String getSsid() {
		return ssid;
	}

	public String getMac() {
		return mac;
	}

	public double getFrequncy() {
		return frequncy;
	}

	public int getSignal() {
		return signal;
	}


	public String getType() {
		return type;
	}


	//functions
	/**
	 * 
	 * @return geographic location
	 */
	public String getGeographicLocation() {
		return lat+","+lon+","+alt;
	}
	/**
	 * 
	 * @return the time, the id and the location of the network
	 */
	public String Time_Id_Location() {
		return this.getTime()+","+id+","+lat+","+lon+","+alt;
	}

	
	/**
	 *@Override type the ssid, the mac address, the frequancy and the power of the signal 
	 */
	@Override
	public String toString() {
		return ssid + "," + mac + "," + frequncy + "," + signal+",";
	}

	@Override

	/**
	 * comperting between tow networks and return the strongest network
	 */
	public int compareTo(Network o) 
	{
		if(this.getSignal()<o.getSignal())
		{
			return 1;
		}
		else if(this.getSignal()>o.getSignal())
		{
			return -1;
		}
		return 0;
	}
	public int compareTo2(Network o)
	{
		
		if(  TimeToInt(this.getTime())   <TimeToInt(o.getTime()))
		{
			return 1;
		}
		else if(TimeToInt(this.getTime())  >TimeToInt(o.getTime()))
		{
			return -1;
		}
		return 0;
	}
	public int TimeToInt (String s){
		String [] helparr=s.split(":");
		String s1= helparr[0]+helparr[1]+helparr[2];
		int stringtoint = Integer.parseInt(s1);
		return stringtoint;
	}
	

}
