package JavaConcepts;

class ParentClass {
	
	public ParentClass() {

		System.out.println("inside construtcor of ParentClass");
	}

	public void methodOne() {
		System.out.println(" i am in parent class");
	}

}

class ChildClass extends ParentClass {

	public ChildClass() {

		System.out.println("inside construtcor of ChildClass");
	}
	
	public void methodOne() {
		System.out.println(" i am in parent class");
	}

}

public class RuntimePolymorphism {

	public static void main(String args[]) {
		ParentClass parentObj = new ParentClass();
		System.out.println("---------------------------------");
		
		ChildClass childObj = new ChildClass();
		System.out.println("---------------------------------");
		
		ParentClass parentObj2 = new ChildClass();
	}
}
