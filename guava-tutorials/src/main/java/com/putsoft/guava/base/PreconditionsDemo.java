package com.putsoft.guava.base;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkPositionIndex;
import static com.google.common.base.Preconditions.checkPositionIndexes;


public class PreconditionsDemo {

	public static void main(String[] args){
		
		//检验参数
		//int i=-9;
		//checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
		
		//判断是否为空
		//Object obj=null;
		//checkNotNull(obj,"Argument was %s but expected nonnegative", obj);
		
		//对boolean进行判断
		//checkState(false);
		
		
		checkElementIndex(5,5);
		
		checkPositionIndex(5,5);
		
		
		//checkPositionIndexes(1,3,5);
		
	}
	
	
}
