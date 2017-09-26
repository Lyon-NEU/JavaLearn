package com.liang.jvm;
 abstract class Human{
}
class Man extends Human{
}
 class Woman extends Human{
}
public class StaticDispatch {
//	static abstract class Human{
//	}
//	static class Man extends Human{
//	}
//	static  class Woman extends Human{
//	}
	public void sayHello(Human guy){      //若没有此方法会报错
		System.out.println("Hello,guy!");
	}
	public void sayHello(Man man){
		System.out.println("Hello,gentlemam!");
	}
	public void sayHello(Woman girl){
		System.out.println("Hello,lady!");
	}
	public static void main(String[]args){
		Human man=new Man();
		Human woman=new Woman();
		StaticDispatch sr=new StaticDispatch();
		sr.sayHello(man);  //"Hello,guy" 调用父类的方法
		sr.sayHello(woman);//"Hello,guy"
	}
}
