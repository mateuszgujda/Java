package pl.edu.agh.kis.java2015.domain;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends  Comparable<T>> {
	private int heapSize = 0;
	private ArrayList<T> tab = new ArrayList<>();

	public void insert(T value) {
		int currentIndex = heapSize;
		int parentIndex = parentIndex(currentIndex);
		tab.add(value);
		while( isChildGreaterThanParent(currentIndex, parentIndex)>0 ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
		heapSize++;
	}

	public int isChildGreaterThanParent(int currentIndex, int parentIndex) {
		return  tab.get(currentIndex).compareTo(tab.get(parentIndex));
	}

	public void swapElements(int currentIndex, int parentIndex) {
		T parentValue = parentValue(currentIndex);
		T currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public T parentValue(int currentIndex) {
		T parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public T extractMax(){
		T value = tab.get(0);
		T last = tab.get(heapSize-1);
		tab.remove(heapSize-1);
		tab.set(0,last);
		heapSize--;
		resortHeap();
		return value;
	}

	public void deleteMax(){
		T last = tab.get(heapSize-1);
		tab.remove(heapSize-1);
		tab.set(0,last);
		heapSize--;
		resortHeap();
	}

	public void replace(T newElement){
		tab.set(0,newElement);
		resortHeap();
	}
	private void resortHeap(){
		int currentIndex = 1;
		int parentIndex = parentIndex(currentIndex);
		while( currentIndex<heapSize ) {
			if(currentIndex+1<heapSize && tab.get(currentIndex+1).compareTo(tab.get(currentIndex))>0){
				currentIndex = currentIndex+1;
			}
			if(isChildGreaterThanParent(currentIndex,parentIndex)>0)
			{
				swapElements(currentIndex,parentIndex);
			}
			parentIndex = currentIndex;
			currentIndex = 2*currentIndex+1;

		}
	}

	public void heapify(T[] args){
		for(T value: args){
			insert(value);
		}
	}

	public void heapify(ArrayList<T> args){
		for(T value : args){
			insert(value);
		}
	}

	public Heap merge(Heap toMerge){
		Heap merged = new Heap();

		merged.tab.addAll(tab);
		merged.tab.addAll(toMerge.tab);
		merged.heapSize = merged.tab.size();

		return merged;
	}

	public Heap meld(Heap toMeld){
		Heap melded = new Heap();
		ArrayList<T> toAdd = new ArrayList<>();
		toAdd.addAll(toMeld.tab);
		toAdd.addAll(tab);
		for(T element: toAdd){
			melded.insert(element);
		}

		return melded;
	}

	public int parentIndex(int currentIndex) { return (currentIndex-1)/2; }

	public int size() {
		return heapSize ;
	}

	public T top() {
		return tab.get(0);
	}


}
