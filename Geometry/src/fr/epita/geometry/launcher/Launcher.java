/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.geometry.launcher;

import java.util.Arrays;
import java.util.List;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Shape;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

/**
 * <h3>Description</h3>
 * <p>
 * This class allows to ...
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used as follows:
 *
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class Launcher {

	public static void main(String[] args) {
		double totalPerimeter = 0.0;

		final Circle c1 = new Circle(20.0);
		System.out.println("area of c1: " + c1.calculateArea());
		System.out.println("perimeter of c1 : " + c1.calculatePerimeter());
		totalPerimeter += c1.calculatePerimeter();
		final Circle c2 = new Circle(30.0);
		System.out.println("area of c2: " + c2.calculateArea());
		System.out.println("perimeter of c2 : " + c2.calculatePerimeter());
		final Circle c3 = new Circle(40.0);
		totalPerimeter += c2.calculatePerimeter();
		c3.calculateArea();
		System.out.println("perimeter of c3 : " + c3.calculatePerimeter());
		totalPerimeter += c3.calculatePerimeter();

		final Triangle t1 = new Triangle(10, 20, 30, 20);
		System.out.println("area of t1: " + t1.calculateArea());
		System.out.println("perimeter of t1 : " + t1.calculatePerimeter());
		totalPerimeter += t1.calculatePerimeter();
		final Triangle t2 = new Triangle(20, 10, 30, 20);
		System.out.println("area of t2: " + t2.calculateArea());
		System.out.println("perimeter of t2 : " + t2.calculatePerimeter());
		totalPerimeter += t2.calculatePerimeter();
		final Triangle t3 = new Triangle(30, 10, 30, 20);
		System.out.println("area of t1: " + t3.calculateArea());
		System.out.println("perimeter of t1 : " + t3.calculatePerimeter());
		totalPerimeter += t3.calculatePerimeter();

		final Square s1 = new Square(10);
		System.out.println("area of s1: " + s1.calculateArea());
		System.out.println("perimeter of s1 : " + s1.calculatePerimeter());
		totalPerimeter += s1.calculatePerimeter();
		final Square s2 = new Square(20);
		System.out.println("area of s2: " + s2.calculateArea());
		System.out.println("perimeter of s2 : " + s2.calculatePerimeter());
		totalPerimeter += s2.calculatePerimeter();
		final Square s3 = new Square(30);
		System.out.println("area of s3: " + s3.calculateArea());
		System.out.println("perimeter of s3 : " + s3.calculatePerimeter());
		totalPerimeter += s3.calculatePerimeter();

	}

	public static void secondOption() {
		double perimeter = 0.0;
		double area = 0.0;
		final Circle c1 = new Circle(20.0);

		final Circle c2 = new Circle(30.0);

		final Circle c3 = new Circle(40.0);

		final Triangle t1 = new Triangle(10, 20, 30, 20);

		final Triangle t2 = new Triangle(20, 10, 30, 20);

		final Triangle t3 = new Triangle(30, 10, 30, 20);

		final Square s1 = new Square(10);

		final Square s2 = new Square(20);

		final Square s3 = new Square(30);

		final List<Shape> shapes = Arrays.asList(c1, c2, c3, t1, t2, t3, s1, s2, s3);
		for (final Shape shape : shapes) {
			perimeter += shape.calculatePerimeter();
			area += shape.calculateArea();
		}

	}

}
