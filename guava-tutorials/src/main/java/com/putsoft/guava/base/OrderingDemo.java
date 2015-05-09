package com.putsoft.guava.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;
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
		
		User u1=new User(2,"aa");
		
		User u2=new User(2,"bb");
		
		Ordering<Object> order=Ordering.from(new UserComparetor()).usingToString();
		
		System.out.println(order.compare(u1,u2));
		
		//使用比较器的List，以compare 返回0的规则寻找元素
		//order.binarySearch(sortedList, key)
		
		//根据已经排序好的List 从索引0开始取N个元素
		//order.leastOf(random, 7);
		//根据已经排序好的List 从末尾开始取N个元素
		//order.greatestOf(iterable, k)
		
		
		Comparator<String> byLength = new Comparator<String>() {
		    public int compare(String left, String right) {
		        return Integer.compare(left.length(), right.length());
		    }
		};
		
		List<String> random = Lists.newArrayList(null, "welcome", "to",
	            "leveluplunch", null, null);

	    List<String> firstTwo = Ordering.from(byLength).nullsLast()
	            .leastOf(random, 7);
	    
	    List<String> firstTwo1 = Ordering.from(byLength).nullsLast()
	            .greatestOf(random, 7);

	    System.out.println(firstTwo1);
		
	    //移除了修改元素的接口
	   // order.immutableSortedCopy(elements);
		//是否根据某个排序器排序过
	    //order.isOrdered(iterable)
		// 排除了等于的情况
	   // order.isStrictlyOrdered(iterable)
	    
	    //按字典排序，长的大于短的
	   // order.lexicographical();
	    //取最大值
	   // order.max(iterable)
		
	    //取最小值
	    //order.min();
	    
		//操作的是list拷贝
		list=com.sortedCopy(list);
		//Collections.sort(list,com);
		p1(list);

	}

}

class  UserComparetor implements Comparator<User>{
	

	@Override
	public int compare(User o1, User o2) {
		if(o1.getAge()>o2.getAge()){
			return 1;
		}else if(o1.getAge()<o2.getAge()){
			return -1;
		}
		return 0;
	}
}

class User{
	public int age;
	
	private String name;
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String _name){
		this.name=_name;
	}
	
	public User(int _age,String _name){
		this.age=_age;
		this.name=_name;
	}
	public int getAge(){
		return this.age;
	}
	public void setAge(int _age)
	{
		this.age=_age;
	}
	
	public String toString(){
		
		return this.name;
		
	}
}

