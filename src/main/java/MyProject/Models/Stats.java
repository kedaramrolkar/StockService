package myProject.models;
	
public class Stats
{
	//Min value for metric
	public double min;
	
	//Max value for metric
	public double max;
	
	//Arithmetic Mean of a values posted to metric
	public double mean;
	
	//Median of a values posted to metric
	public double median;
	
	public Stats(double min, double max, double mean, double median)
	{
		this.min = min;
		this.max = max;
		this.mean = mean;
		this.median = median;
	}
}