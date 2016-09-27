package fillList;

public class Stone {
	private String name;
	private int number;
	
	public Stone(String name) {
		this.name = name;
		this.number = name.hashCode();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = name.hashCode();
	}
	
	@Override
	public String toString(){
		return (this.getName() + ' ' + this.getNumber());
	}
	
	@Override
	public boolean equals(Object o){
		Stone e = (Stone) o;
		return (this.number == e.number);
	}
	
	@Override
	 public int hashCode()
	 {
	    return this.number;
	 }
}
