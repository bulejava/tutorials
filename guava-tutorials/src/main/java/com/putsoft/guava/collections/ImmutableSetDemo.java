package com.putsoft.guava.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class ImmutableSetDemo {
	

	public static void main(String[] args) {

		//通过枚举创建不可变集和
		ImmutableSet<String> foobar = ImmutableSet.of("foo", "bar", "baz");
		 
		
		//通过拷贝方式创建
		//ImmutableSet.copyOf(elements)
		//ImmutableList<String> defensiveCopy = ImmutableList.copyOf(foobar);
		//通过builder创建器
		//1、增加一个元素
		System.out.println(ImmutableSet.builder().add("sdfsdf").build());
		//2、通过链式调用，集成多个数据，生成一个新的对象
		System.out.println(ImmutableSet.builder().addAll(foobar).add("3434").add("23refd").build());
		
		//返回List
		//foobar.asList();
		


	}
	
}



/*class Foo {
  final ImmutableSet<Bar> bars;
  Foo(Set<Bar> bars) {
    this.bars = ImmutableSet.copyOf(bars); // defensive copy!
  }
}

class Bar{
	
	
}*/