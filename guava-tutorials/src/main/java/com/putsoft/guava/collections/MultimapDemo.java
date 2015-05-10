package com.putsoft.guava.collections;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class MultimapDemo {

	public static void main(String[] args) {

		//创建对象
		Multimap<String,Integer> map=HashMultimap.create();
		//相同key，put多个value
		map.put("aa",1);
		map.put("aa", 3);
		map.put("bb",5);
		System.out.println(map);
		//返回key的value list集和
		System.out.println(map.get("bb"));
		
		
		
	}

}
