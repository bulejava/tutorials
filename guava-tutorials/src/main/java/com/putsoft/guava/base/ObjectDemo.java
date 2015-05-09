package com.putsoft.guava.base;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class ObjectDemo {

	public static void main(String[] args) {
/*		Person p=new Person("旺财");
		Dog d=new Dog("旺财");
		System.out.println(p.equals(d));*/
		
		Objects.equal("a", "a"); // returns true
		Objects.equal(null, "a"); // returns false
		Objects.equal("a", null); // returns false
		Objects.equal(null, null); // returns true
		//使用MoreObjects firstNonNull
		//Objects.firstNonNull(first, second);
		
		//对多个值生成hashcode
		//Objects.hashCode(objects)
		
		//java.util.Objects.hash(values)
		
		
		// Returns "ClassName{x=1}"
		   System.out.println(MoreObjects.toStringHelper(new ObjectDemo())
		       .add("x", 1)
		       .toString());

		   // Returns "MyObject{x=1}"
		   System.out.println(MoreObjects.toStringHelper("MyObject")
		       .add("x", 1)
		       .toString());
		   
		   //true<false
       System.out.println(ComparisonChain.start().compareTrueFirst(false, true).result()
		   );
	}

}



class Person implements Comparable<Person>{
	
	@Override
	public int compareTo(Person o) {
		return ComparisonChain.start().compare(name,o.name).result();
	}
	
	
	public String name;
	public Person(String _name){
		name=_name;
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
	public String toString(){
		return this.name;
	}
}

class Dog{
public String name;
	public Dog(String _name){
		name=_name;
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
	public String toString(){
		return this.name;
	}
}
