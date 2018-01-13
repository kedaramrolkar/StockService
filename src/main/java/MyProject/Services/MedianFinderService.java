package myProject.services;

import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;

// Use min and max heap to divide the elements into two buckets and store the large items in min heap and smaller items in max heap.
// finding mean: O(1)
// adding element: o(lg n) 
public class MedianFinderService 
{
	public Queue<Double> minHeap;
	public Queue<Double> maxHeap;
	public int countOfElements;
	
	public MedianFinderService() 
	{
		maxHeap = new PriorityQueue<Double>(20, new MaxHeapComparator()); 
		minHeap = new PriorityQueue<Double>();
		countOfElements = 0;
	}
	
	public void addItem(double num) 
	{
		maxHeap.add(num);
		
		if (countOfElements % 2 != 0) 
		{
			minHeap.add(maxHeap.poll());
		} 
		else 
		{
			if (!minHeap.isEmpty() && (maxHeap.peek() > minHeap.peek())) 
			{
				Double maxHeapRoot = maxHeap.poll();
				Double minHeapRoot = minHeap.poll();
				maxHeap.add(minHeapRoot);
				minHeap.add(maxHeapRoot);
			} 
		}
		countOfElements++;
	}
	
	public Double getMedian() 
	{
		if (countOfElements % 2 == 0)
		{
			return (maxHeap.peek() + minHeap.peek()) / 2; 
		}
		
		return new Double(maxHeap.peek());
	}
	
	private class MaxHeapComparator implements Comparator<Double> 
	{
		@Override
		public int compare(Double d1, Double d2) 
		{
			return (int)(d2 - d1);
		}
	}
}