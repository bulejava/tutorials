package com.putsoft.guava.collections;

import java.util.Set;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class RangeSetDemo {

	public static void main(String[] args) {
		
		RangeSet<Integer> rangeSet = TreeRangeSet.create();
		   rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
		   rangeSet.add(Range.closedOpen(11, 15)); // disconnected range: {[1, 10], [11, 15)} 
		   rangeSet.add(Range.closedOpen(15, 20)); // connected range; {[1, 10], [11, 20)}
		   rangeSet.add(Range.openClosed(0, 0)); // empty range; {[1, 10], [11, 20)}
		   rangeSet.remove(Range.open(5, 10)); // splits [1, 10]; {[1, 5], [10, 10], [11, 20)}
	
		   System.out.println(rangeSet);
		   
		   Set<Range<Integer>>  set=rangeSet.asRanges();
		   
		   Range<Integer>[] range=set.toArray(new Range[set.size()]);
	
		   System.out.println(range[0].);
		   
	}

}
