package myProject.models;

import myProject.services.*;
import com.fasterxml.jackson.annotation.JsonProperty;

// Holds the data related to one stock commodity.
public class StockContainer 
{
	private static final double DEFAULT_STOCK_VALUE = 0.0;
	
    private String name;
    private double currValue;
	private ValueHistory valueHistory = new ValueHistory();
		
    public StockContainer(@JsonProperty("name") String name, @JsonProperty("value") double value) 
	{
        setName(name);
        setValue(value);
    }
	
	public StockContainer(String name) {
        this.name = name;
        this.currValue = DEFAULT_STOCK_VALUE;
    }
	
    public String getName() {
        return name;
    }

    public double getValue() {
        return currValue;
    }
	
	public Stats getStats()
	{
		return new Stats(valueHistory.getMinValue(), valueHistory.getMaxValue(), valueHistory.getMeanValue(), valueHistory.getMedianValue()); 
	}
	
	public Stock getStock()
	{
		return new Stock(name, currValue); 
	}
	
	public void setName(String name) 
	{
	    this.name = name;
	}
	
	public void setValue(double value) 
	{
		System.out.println("adding "+ value);
		valueHistory.addValue(value);
	    this.currValue = value;
	}
	
	// Holds the history of stock value and return the stats when asked
	class ValueHistory
	{
		private double minValue = Double.MAX_VALUE;
		private double maxValue = Double.MIN_VALUE;
		private double sum;
		private int count;
		
		// This data structure is used to return the current running median
		private MedianFinderService medianFinderService = new MedianFinderService();
		
		// adding item: O(lg n)
		public void addValue(double value)
		{
			medianFinderService.addItem(value);
			count++;
			
			if(value < minValue)
			{
				System.out.println("min "+ value);
				minValue = value;
			}
			
			if(value > maxValue)
			{
				System.out.println("max "+ value);
				maxValue = value;
			}
			
			sum += value;
		}
		
		// finding min: O(1)
		public double getMinValue()
		{
			return minValue;
		}
		
		// finding max: O(1)
		public double getMaxValue()
		{
			return maxValue;
		}
		
		// finding mean: O(1)
		public double getMeanValue()
		{
			return sum / count;
		}
		
		// finding median: O(1)
		public double getMedianValue()
		{
			return medianFinderService.getMedian();
		}
	}
}
