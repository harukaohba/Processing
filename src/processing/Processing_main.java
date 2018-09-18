package processing;

import processing.core.PApplet;

public class Processing_main extends PApplet {

	int x, y;

	public void settings() {
		size(600, 600);
	}

	public void setup() {
		background(50);
	}

	public void mouseMoved() {
		x = mouseX;
		y = mouseY;
	}

	public void draw() {
		ellipse(x, y, 50, 50);

	}

	public static void main(String[] args) {
		// PApplet.main( "Processing" );

		String[] a = { "MA" };
		PApplet.runSketch(a, new Processing_main());
	}

}
