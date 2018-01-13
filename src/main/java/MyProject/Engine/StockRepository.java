package myProject.engine;

import myProject.models.StockContainer;
import myProject.models.Stock;
import java.util.HashMap;
import java.util.*;

public class StockRepository
{
	private HashMap<String, StockContainer> _stockHashMap;
	
	public StockRepository()
	{
		_stockHashMap = new HashMap<>();
	}
	
	// Gets the stockContainer by name if present
	public StockContainer getStock(String name)
	{
		return _stockHashMap.get(name);
	}
	
	// Adds new stockContainer if absent
	public StockContainer addStock(String name, Stock stock)
	{
		StockContainer presentStockContainer = getStock(name);
		if(presentStockContainer == null)
		{
			System.out.println("here2");
			presentStockContainer = new StockContainer(name, stock.getValue());
			_stockHashMap.put(name, presentStockContainer);
			return presentStockContainer;
		}
		return null;
	}
	
	// Modifies stockContainer if present
	public StockContainer modifyStock(String name, Stock stock)
	{
		StockContainer presentStockContainer = getStock(name);
		if(presentStockContainer != null)
		{
			presentStockContainer.setValue(stock.getValue());
			return presentStockContainer;
		}
		return null;
	}
}
