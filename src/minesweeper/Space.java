package minesweeper;

public class Space {
	
	boolean bombType;
	boolean selected;
	boolean show;
	String face;
	String coord;
	
	// Random type = new Random();
	
	public Space(boolean type, String coord) {
		this.bombType = type;
		selected = false;
		show = false;
		face = "X";
		this.coord = coord;
	}
	
	

	public boolean isBombType() {
		return bombType;
	}

	public void setBombType(boolean bombType) {
		this.bombType = bombType;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getCoord() {
		return coord;
	}

	public void setCoord(String coord) {
		this.coord = coord;
	}
	
	
	
}
