package pl.edu.agh.kis.java2015.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class HeapTest {
	
	@Test
	public void insert0intoNewHeap_topIs0() {
		
		Heap heap = new Heap<Double>();
		heap.insert(0);
		
		assertEquals("size should be 1",1,heap.size());
		assertEquals(0, (Integer) heap.top(),0.001);
		assertEquals(1,heap.size());
	}
	
	@Test
	public void insert0AndThen2intoNewHeap_topIs2() {
		
		Heap heap = new Heap<Double>();
		heap.insert(0);
		heap.insert(2);
		
		assertEquals("size should be 2",2,heap.size());
		assertEquals(2, (Integer) heap.top(),0.001);
	}
	
	@Test
	public void insert0And2And3And5And6intoNewHeap_topIs6() {
		
		Heap heap = new Heap<Double>();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		
		assertEquals(6,(Integer) heap.top(),0.001);
	}

	@Test
	public void extractRootAndGetValue(){

		Heap heap = new Heap<Double>();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);

		assertEquals("Value should be 6",6,(Integer)heap.extractMax(),0.001);
		assertEquals("size should be 4",4,heap.size());
		assertEquals("the head now should be  next kin element",5,(Integer) heap.top(),0.001);

	}

	@Test
	public void extractRootValue(){
		Heap heap = new Heap<Double>();
		heap.insert(0);
		heap.insert(4);
		heap.insert(8);
		heap.insert(5);
		heap.insert(3);

		heap.deleteMax();

		assertEquals("Size should be 4",4,heap.size());
		assertEquals("Next head should be the biggest child",5,(Integer) heap.top(),0.001);
	}

	@Test
	public void ReplaceTheBiggestValueAndDoHeapConditions(){
		Heap heap = new Heap<Double>();
		heap.insert(0);
		heap.insert(4);
		heap.insert(8);
		heap.insert(5);
		heap.insert(3);

		heap.replace(2);
		assertEquals("Top should be now 5",5, (Integer) heap.top(),0.001);
		assertEquals("Size should be the same",5,heap.size(),0.001);
	}

	@Test
	public void MakeNewHeapFromAnDoubleArray(){
		Heap heap = new Heap<Double>();
		heap.heapify(new Double[] {0.0,4.0,8.0,5.0,3.0});

		assertEquals("Top should be 8",8, (Double) heap.top(),0.001);
		assertEquals("Size should be 5",5,heap.size(),0.001);
	}
	@Test
	public void MakeNewHeapFromAnDoubleList(){
		Heap heap = new Heap<Double>();
		ArrayList<Double> toHeapify = new ArrayList<>();
		toHeapify.add(0.0);
		toHeapify.add(3.0);
		toHeapify.add(4.0);
		toHeapify.add(5.0);
		toHeapify.add(8.0);
		heap.heapify(toHeapify);

		assertEquals("Top should be 8", 8, (Double) heap.top(),0.001);
		assertEquals("Size should be 5",5,heap.size(),0.001);
	}

	@Test
	public void MergeTwoHeaps(){
		Heap heap1 = new Heap<Double>();
		Heap heap2 = new Heap<Double>();
		heap1.heapify(new Double[] {0.0,4.0,8.0,5.0,3.0});
		heap2.heapify(new Double[] {3.0,1.0,10.0,4.0,2.0});
		Heap heap = heap1.merge(heap2);

		assertEquals("First element should still be 8",8, (Double) heap.top(),0.001);
		assertEquals("Size should be 10",10,heap.size(),0.001);

	}

	@Test
	public void MeldTwoHeaps(){
		Heap heap1 = new Heap<Double>();
		Heap heap2 = new Heap<Double>();
		heap1.heapify(new Double[] {0.0,4.0,8.0,5.0,3.0});
		heap2.heapify(new Double[] {3.0,1.0,10.0,4.0,2.0});
		Heap heap = heap1.meld(heap2);

		assertEquals("First element should  be 10",10, (Double) heap.top(),0.001);
		assertEquals("Size should be 10",10,heap.size(),0.001);
	}
}
