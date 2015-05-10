package com.putsoft.guava.collections;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableDemo {

	public static void main(String[] args) {
		
		Table<Integer,String, Double> weightedGraph = HashBasedTable.create();
		weightedGraph.put(1, "aaa", 4.0);
		weightedGraph.put(1,"bbb", 20.0);
		weightedGraph.put(2,"ccc", 5.0);

		System.out.println(weightedGraph.row(1)); // returns a Map mapping v2 to 4, v3 to 20
		System.out.println(weightedGraph.column("bbb")); // returns a Map mapping v1 to 20, v2 to 5

	}

}
