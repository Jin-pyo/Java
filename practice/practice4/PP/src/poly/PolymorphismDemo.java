package poly;

import Geometric.CircleFromSGO;
import Geometric.RectangleFromSGO;
import Geometric.SimpleGeometricObject;

public class PolymorphismDemo {
	 public static void main(String[] args) {
		    // Display circle and rectangle properties
		    displayObject(new CircleFromSGO(1, "red", false));
		    displayObject(new RectangleFromSGO(1, 1, "black", true));
		  }

		  /** Display geometric object properties */
		  public static void displayObject(SimpleGeometricObject object) {
		    System.out.println("Created on " + object.getDateCreated() +
		      ". Color is " + object.getColor());
		  }
}
