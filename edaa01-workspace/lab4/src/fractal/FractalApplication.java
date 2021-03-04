package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[] {
				new Mountain(new Point(100, 400), new Point(370, 200), new Point(510, 443), 20),
				new Koch(300),
				
		};
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}
	
}
