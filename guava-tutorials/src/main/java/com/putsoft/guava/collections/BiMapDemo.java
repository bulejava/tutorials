package com.putsoft.guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapDemo {

	public static void main(String[] args) {
		
		BiMap<String, Integer> userId = HashBiMap.create();
		userId.put("aaa",1);
		userId.put("bbb",2);
		userId.put("ccc",3);
		//根据value 返回ID
		System.out.println(userId.inverse().get(1));
		System.out.println(userId.get("aaa"));

	}

}
