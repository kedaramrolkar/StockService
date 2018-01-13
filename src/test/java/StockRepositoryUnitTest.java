package myProject.unitTests;

import static org.junit.Assert.*;
import myProject.*;
import myProject.models.Stock;
import myProject.models.StockContainer;
import myProject.engine.StockRepository;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
public class StockRepositoryUnitTest {
  
    // write unit tests cases here
	@Test
	public void addNewStock_returnsStock() 
	{
		StockRepository stockRepository = new StockRepository();
		
		Stock stock = new Stock("xyz", 33);
		stockRepository.addStock(stock.getName(), stock);
		
		Stock returnedStock = stockRepository.getStock(stock.getName()).getStock();
		
		Assert.isTrue(stock.getName().equals(returnedStock.getName()));
		Assert.isTrue(stock.getValue() == returnedStock.getValue());
	}
	
	@Test
	public void addAlreadyAddedStock_returnsNull() 
	{
		StockRepository stockRepository = new StockRepository();
		
		Stock stock = new Stock("xyz", 33);
		stockRepository.addStock(stock.getName(), stock);
		
		StockContainer returnedStockContainer = stockRepository.addStock(stock.getName(), stock);
		Assert.isTrue(returnedStockContainer == null);
	}
	
	@Test
	public void getPresentStock_returnsStock() 
	{
		StockRepository stockRepository = new StockRepository();
		
		Stock stock = new Stock("xyz", 33);
		stockRepository.addStock(stock.getName(), stock);
		
		Stock returnedStock = stockRepository.getStock(stock.getName()).getStock();
		Assert.isTrue(stock.getName().equals(returnedStock.getName()));
		Assert.isTrue(stock.getValue() == returnedStock.getValue());
	}
	
	@Test
	public void getAbsentStock_returnsNull() 
	{
		StockRepository stockRepository = new StockRepository();
		StockContainer returnedStockContainer = stockRepository.getStock("dummy");
		
		Assert.isTrue(returnedStockContainer == null);
	}
	
	@Test
	public void modifyPresentStock_returnsStock() 
	{
		StockRepository stockRepository = new StockRepository();
		
		Stock stock = new Stock("xyz", 33);
		stockRepository.addStock(stock.getName(), stock);
		
		Stock changedStock = new Stock("xyz", 44);
		stockRepository.modifyStock(stock.getName(), changedStock);
		
		Stock returnedStock = stockRepository.getStock(stock.getName()).getStock();
		Assert.isTrue(changedStock.getName().equals(returnedStock.getName()));
		Assert.isTrue(changedStock.getValue() == returnedStock.getValue());
	}
	
	@Test
	public void modifyAbsentStock_returnsNull() 
	{
		StockRepository stockRepository = new StockRepository();
		Stock stock = new Stock("xyz", 33);
		StockContainer returnedStockContainer = stockRepository.modifyStock(stock.getName(), stock);
		
		Assert.isTrue(returnedStockContainer == null);
	}
}