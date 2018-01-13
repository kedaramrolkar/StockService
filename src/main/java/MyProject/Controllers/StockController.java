package myProject.controllers;

import myProject.engine.*;
import myProject.models.Stock;
import myProject.models.Stats;
import myProject.models.StockContainer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import java.util.*;
import java.lang.Exception;
import java.io.IOException;

@RestController
@RequestMapping("/stock")
public class StockController 
{
    private StockRepository stockRepository = new StockRepository();
		
	//http://localhost:8080/stock/abc
	@RequestMapping(method = RequestMethod.PUT, value = "/{name}")
	@ResponseBody
    public Stock createStock(@PathVariable("name") String name, @RequestBody Stock stock) 
	{
		System.out.println("here1");
        StockContainer stockContainer = stockRepository.addStock(name, stock);
		
		if(stockContainer == null)
		{
			throw new StockAlreadyExistException(name);
		}
		
		return stockContainer.getStock();
    }
	
	
	//http://localhost:8080/stock/abc
	@RequestMapping(method = RequestMethod.POST, value = "/{name}")
	@ResponseBody
    public Stock modifyStock(@PathVariable(value="name") String name, @RequestBody Stock stock) 
	{
        StockContainer stockContainer = stockRepository.modifyStock(name, stock);
		
		if(stockContainer == null)
		{
			throw new StockNotFoundException(name);
		}
		
		return stockContainer.getStock();
    }
	
	
	//http://localhost:8080/stock/abc
	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	@ResponseBody
    public Stock getStock(@PathVariable(value="name") String name) 
	{
        StockContainer stockContainer = stockRepository.getStock(name);
		
		if(stockContainer == null)
		{
			throw new StockNotFoundException(name);
		}
		
		return stockContainer.getStock();
    }	
	
	//http://localhost:8080/stock/abc
	@RequestMapping(method = RequestMethod.GET, value = "/{name}/stats")
	@ResponseBody
    public Stats getStats(@PathVariable(value="name") String name) 
	{
        StockContainer stockContainer = stockRepository.getStock(name);
				
		if(stockContainer == null)
		{
			throw new StockNotFoundException(name);
		}
		
		return stockContainer.getStats();
    }
	
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class StockNotFoundException extends RuntimeException {

	public StockNotFoundException(String stockName) {
		super("Could not find stock '" + stockName + "'.");
	}
}

@ResponseStatus(HttpStatus.CONFLICT)
class StockAlreadyExistException extends RuntimeException {

	public StockAlreadyExistException(String stockName) {
		super("Stock '" + stockName + "' already exists.");
	}
}