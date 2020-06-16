package object;

public class EqualsDemo {
	public static void main(String[] args) {
		Cell c1 = new Cell(3, 4);
		Cell c2 = new Cell(3, 4);
		Cell c3 = new Cell(5, 6);
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
	}
}

class Cell {
	int row;
	int col;
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
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
		Cell other = (Cell) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
}
