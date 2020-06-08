package unac.edu.co.poo2;

public class Student implements Comparator {
	int nAsignature;
	String name;

	public Student(String n, int mat) {
		name = n;
		nAsignature = mat;
	}

	public Student() {
		this(null, 0);
	}

	public String toString() {
		if (name != null)
			return name + nAsignature;
		else
			return "No asignado";
	}

	public boolean menorQue(Object op2) {
		Student p2 = (Student) op2;
		return nAsignature < p2.nAsignature;
	}

	public boolean menorIgualQue(Object op2) {
		Student p2 = (Student) op2;
		return nAsignature <= p2.nAsignature;
	}

	public boolean mayorQue(Object op2) {
		Student p2 = (Student) op2;
		return nAsignature > p2.nAsignature;
	}

	public boolean mayorIgualQue(Object op2) {
		Student p2 = (Student) op2;
		return nAsignature >= p2.nAsignature;
	}

	public boolean igualQue(Object op2) {
		Student p2 = (Student) op2;
		return nAsignature == p2.nAsignature;
	}

}
