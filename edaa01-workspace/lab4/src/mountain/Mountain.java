package mountain;

import java.util.HashMap;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {

	private Point a;
	private Point b;
	private Point c;

	private double dev;
	
	private HashMap<Side, Point> sides;

	public Mountain(Point a, Point b, Point c, double dev) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
		this.sides = new HashMap<>();
	}

	@Override
	public String getTitle() {
		return "Mountain fractal";
	}

	@Override
	public void draw(TurtleGraphics g) {
		fractalTriangle(g, this.order, this.a, this.b, this.c, this.dev);
	}

	private void fractalTriangle(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev) {
		if (order == 0) {
			// Move to starting position
			turtle.moveTo(a.getX(), a.getY());

			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());

			// back to start
			turtle.forwardTo(a.getX(), a.getY());

			return;
		}
		
		// Middle of the two points
		Point ab = calcPoint(a, b, RandomUtilities.randFunc(dev));
		Point ac = calcPoint(a, c, RandomUtilities.randFunc(dev));
		Point bc = calcPoint(b, c, RandomUtilities.randFunc(dev));

		// Points for the new triangles
		Point[][] triangles = new Point[][] { { a, ab, ac }, { ab, b, bc }, { ac, bc, c }, { bc, ac, ab } };

		// Draw all triangles
		for(Point[] p : triangles) {
			this.fractalTriangle(turtle, order - 1, p[0], p[1], p[2], dev / 2);
		}

	}

	private Point calcPoint(Point a, Point b, double random) {
		// Create new side from points
		Side s = new Side(a,b);
		
		// Check if side with those points exists
		if(sides.containsKey(s)) {
			Point p = sides.get(s);
			sides.remove(s);
			return p;
		}
		
		// Calculate center between two X-points
		int x = a.getX() + (b.getX() - a.getX()) / 2;
		
		// Center between Y:s, and adding an offset
		int y = (int) ((a.getY() + (b.getY() - a.getY()) / 2) + random);	
		
		// Generate new point
		Point p = new Point(x, y);
		
		// Save it to the map
		this.sides.put(s,  p);
		
		return p;
	}

}
