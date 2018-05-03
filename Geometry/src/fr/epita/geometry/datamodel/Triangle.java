/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.geometry.datamodel;

/**
 * <h3>Description</h3>
 * <p>This class allows to ...</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */
public class Triangle implements Shape {
	private double sideA;
	private double sideB;
	private double base;
	private double height;

	/**
	 * @param sideA
	 * @param base
	 * @param height
	 */
	public Triangle(double sideA, double base, double height, double sideB) {

		this.sideA = sideA;
		this.base = base;
		this.height = height;
		this.sideB = sideB;
	}

	/**
	 * @return the sideA
	 */
	public double getSideA() {
		return sideA;
	}

	/**
	 * @param sideA
	 *            the sideA to set
	 */
	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	/**
	 * @return the base
	 */
	public double getBase() {
		return base;
	}

	/**
	 * @param base
	 *            the base to set
	 */
	public void setBase(double base) {
		this.base = base;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the sideB
	 */
	public double getSideB() {
		return sideB;
	}

	/**
	 * @param sideB
	 *            the sideB to set
	 */
	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	@Override
	public double calculatePerimeter() {
		return base + sideA + sideB;
	}

	@Override
	public double calculateArea() {
		return base * height / 2;
	}

}
