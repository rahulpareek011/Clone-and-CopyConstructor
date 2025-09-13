package cc1;


//Cloneable is a marker interface (no methods).
//It is a signal to Object.clone() that this class allows cloning.
public class CCTest implements Cloneable{
	int id;
	
	CCTest(int id){
		this.id = id;
	}
	
	void getId() {
		System.out.println(id);
	}

//	clone() method in Object is declared with
//	protected native Object clone() throws CloneNotSupportedException;
	
	//SO, declare throws CloneNotSupportedException in your method
	public static void main(String[] args) throws CloneNotSupportedException{
		
		System.out.println("CLONING IN JAVA");
		CCTest d1 = new CCTest(11);
		d1.getId();
		
		//clone() creates a new object that is a copy of the current object.
		CCTest d2 = (CCTest) d1.clone();
		d2.getId(); //same as d1 but different memory address
		d2.id = 12; //changing value
		d2.getId(); //affected on d2
		d1.getId(); //but not in d1 means both are independent
		
		System.out.println("both have same value but different objects");
		System.out.println("d1 object memory address-> "+d1.hashCode());
		System.out.println("d2 object memory address-> "+d2.hashCode());
		//Both d1 and d2 have same values (11).
		//But hashCode is different →(means) they are different objects in memory.
		
		
		
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println();
		
		
		
		System.out.println("Copy Constructor in java");
		
		Student s1 = new Student(101, "Rahul");
		System.out.println("data by s1 -> "+s1.id+" "+s1.name);
		
		Student s2 = new Student(s1);
		System.out.println("data by s2 -> "+s2.id+" "+s2.name);
		
		s2.id = 102;
		System.out.println("data by s2 -> "+s2.id+" "+s2.name);
		System.out.println("CC also have same value but different objects");
		System.out.println("s1 object memory address-> "+s1.hashCode());
		System.out.println("s2 object memory address-> "+s2.hashCode());
		
		//Constructors are called only at object creation → new Student(...).
		//After object is created, any assignment like s2.id = 102;
		//+just updates that object’s field directly.
		//Each object (s1 and s2) has its own separate copy of fields 
		//+ → changing one doesn’t affect the other (for primitive types and immutable objects like String).
		
		System.out.println("data by s1 -> "+s1.id+" "+s1.name); //so s1 still remain same
	}
}
class Student{
	int id;
	String name;
	
	Student(int id , String name){
		this.id = id;
		this.name = name;
	}
	
	Student(Student s){
		this.id = s.id;
		this.name = s.name;
	}
	
}

//Summary in One Line

//Clone() = Built-in but needs Cloneable, throws exception, 
//+shallow copy by default, less control.

//Copy Constructor = Programmer-defined, no exceptions, 
//+full control, cleaner to use, preferred in modern Java.


















