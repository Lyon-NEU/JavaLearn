package com.liang.jvm;

public class ByteCodeDemo {
	public static class Bird{
		private String type;
		private String color;
		public Bird(String type,String color){
			this.type=type;
			this.color=color;
		}
		public Bird(){}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bird b=new Bird();
		b.setColor("Red");
		System.out.println(b.getType());
	}

}
