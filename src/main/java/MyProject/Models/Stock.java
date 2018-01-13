package myProject.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stock
{
	private String name;
	private double value;
		
	public Stock(@JsonProperty("value") double value) 
	{
		this.value = value;
	}
	
	public Stock(@JsonProperty("name") String name, @JsonProperty("value") double value) 
	{
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
	
	public void setName(String name) 
	{
	    this.name = name;
	}
	
	public void setValue(double value) 
	{
	    this.value = value;
	}
}