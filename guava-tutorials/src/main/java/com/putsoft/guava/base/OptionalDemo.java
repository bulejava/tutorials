package com.putsoft.guava.base;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Optional;

public class OptionalDemo {
	
	

	public static void main(String[] args) {
		
		
		Optional<Integer> possible=Optional.of(1);
		
		//不为null 返回true
		possible.isPresent();
		
		//保证获取的不为null，为null则抛出异常
		possible.get();
		
		//为了遍历使用，for(T obj:asSet)
		possible.asSet();
		
		//如果为null，则返回传入的值
		possible.or(5);
		
		//如果为null，则返回null
		possible.orNull();
		
		//创建为Absent 空对象，没有实际意义
		Optional.absent();
		
		//如果实例为null，曾返回absent，如果不为null，则应由function转换
		possible.transform(new ObjectConver());
		
		//如果为空 返回Absent
		Optional.fromNullable(444);
		Optional.fromNullable(null);
		
		List<Optional<String>> list=new ArrayList<Optional<String>>();
		//过滤一个容器里的null元素
		Optional.presentInstances(list);

	}

}

//类型转换
class ObjectConver implements Function<Integer, Double>{

	@Override
	public Double apply(Integer input) {
		return Double.valueOf(input);
	}
	
}
