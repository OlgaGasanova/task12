package lineAndPoints;

public class Line {

	private float a;
	private float b;
	
	public Line(float a, float b){
		this.a = a;
		this.b = b;
	}
	
	public float getA(){
		return this.a;
	}

	public float getB(){
		return this.b;
	}
	
	@Override
	public String toString(){
		return ("Прямая y=" + this.a + "*x+(" + this.b + ")");
	}
	
	 @Override
	 public int hashCode() {
		 final int prime = 31;
	     int result = 1;
	     result = (int) (prime * result + a);
	     result = (int) (prime * result + b);
	     return result;
	 }
	 
	 @Override
	 public boolean equals(Object obj) {
	     if (this == obj)
	    	 return true;
	     if (obj == null)
	         return false;
	     if (getClass() != obj.getClass())
	         return false;
	     Line other = (Line) obj;
	     if (a != other.a)
	         return false;
	     if (b != other.b)
	         return false;
	     return true;
	    }
}
