package myProject.unitTests;

import static org.junit.Assert.*;
import myProject.*;
import myProject.models.Stock;
import myProject.models.Stats;
import myProject.models.StockContainer;
import myProject.engine.StockRepository;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
public class StockContainerUnitTest {
  
    // write unit tests cases here
	@Test
	public void addItemAndTestStats_correctValues() 
	{
		StockContainer stockContainer = new StockContainer("test", 5.7);
		
		stockContainer.setValue(9.3);
		stockContainer.setValue(3.6);
		stockContainer.setValue(22.56);
		stockContainer.setValue(-5.4);
		
		Stats returnedStats = stockContainer.getStats();
		
		Assert.isTrue(returnedStats.min == -5.4);
		Assert.isTrue(returnedStats.max == 22.56);
		Assert.isTrue(((double)Math.round(returnedStats.mean * 100d) / 100d) == 7.15);
		Assert.isTrue(returnedStats.median == 5.7);
	}
}