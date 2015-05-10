package com.putsoft.guava.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultisetDemo {

	public static void main(String[] args) {
		
		//创建D对象
		Multiset<String> set=HashMultiset.create();
		//增加元素
		set.add("aa");
		set.add("bb");
		set.add("aa");
		//获取元素个数
		System.out.println(set.count("aa"));
		//增加一个集和
		set.addAll(set);
		System.out.println(set);
		//转换成jdk set
		Set<String> cset=set.elementSet();
		
		System.out.println(cset);
		
		List<String> test=new ArrayList<String>();
		test.add("aa");
		//移除指定容器元素外的所有元素
		set.retainAll(test);
		System.out.println(set);
		
		set.setCount("aa", 5);
		
		System.out.println(set);
		

	}

}
