package com.putsoft.guava.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Ordering;

public class OrderingDemo {
	
	private static void p1(Collection<Integer> list){
/*		for(Integer in:list){
			System.out.println(in);
		}*/
		
		System.out.println(list);
	}

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(5,3,2,5,6,7);
		//创建自然排序规则的排序器
		Ordering<Integer> com=Ordering.natural();
		
		//返回不排序的排序器，一般为了实例化排序器，调用其他成员函数
		Ordering<Object> o=Ordering.allEqual().nullsFirst();
		
		List<String> l=Arrays.asList("a","b","c","d","e","f","f");
		//List<String> l=Arrays.asList("a","b","c","d","e",new String("f"),new String("f"));
		//返回任意顺序的排序器，相同元素顺序保持不变，同一个JVM生命周期内保持排序顺序不变
		o=Ordering.arbitrary();
		System.out.println(o.sortedCopy(l));
		
		List<Ordering<Integer>> ol=new ArrayList<>();
		ol.add(com);
		//多条件排序，一般针对一个对象的多个属性进行排序
		Ordering.compound(ol);
		
		List<String> el=Arrays.asList("钟","郭","陈","李");
		//自定义一种顺序，然后根据此顺序来排序,对于重复的比较有价值，或在数据存储在数据库，
		//进行排序
		Ordering<String> os=Ordering.explicit(el);
		
		System.out.println(os.sortedCopy(Arrays.asList("陈","李","钟","李","陈","郭","郭")));
		
		//利用对象的tostring产生的字符串的排序器
		Ordering.usingToString();
		
		//操作的是list拷贝
		list=com.sortedCopy(list);
		//Collections.sort(list,com);
		p1(list);

	}

}
