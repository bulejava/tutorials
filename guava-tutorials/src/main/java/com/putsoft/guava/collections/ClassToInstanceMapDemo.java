package com.putsoft.guava.collections;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

public class ClassToInstanceMapDemo {

	public static void main(String[] args) {
		
		
		ClassToInstanceMap<Number> numberDefaults = MutableClassToInstanceMap.create();
		numberDefaults.putInstance(Integer.class, Integer.valueOf(0));
		//numberDefaults.putInstance(Integer.class, Integer.valueOf(5));
		numberDefaults.putInstance(Double.class,Double.valueOf(2.0));
		System.out.println(numberDefaults.get(Integer.class));

	}

}
