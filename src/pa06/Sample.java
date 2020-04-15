package pa06;
//Gordon
import java.util.ArrayList;

/**
 * A Sample represents a vector of doubles to be used in a clustering algorithm...
 * @author presenting
 *
 */

public class Sample {
	ArrayList<Double> sample;
	
	public Sample(double[] values) {
		this.sample = new ArrayList<Double>();
		for (int i=0; i<values.length; i++) {
			sample.add(values[i]);
		}
	}
	
	public Sample(double x, double y, double z) {
		this.sample = new ArrayList<Double>();
		sample.add(x);
		sample.add(y);
		sample.add(z);
	}
	
	public double getX() {
		return sample.get(0);
	}
	
	public double getY() {
		return sample.get(1);
	}
	
	public double getZ() {
		return sample.get(2);
	}
	
	public void setX(double x) {
		sample.set(0, x);
	}
	
	public void setY(double y) {
		sample.set(1, y);
	}
	
	public void setZ(double z) {
		sample.set(2, z);
	}
	
	public double Distance(Sample s) {
		double square = 0;
		for(int i = 0; i<s.sample.size(); i++) {
			square += Math.pow(this.sample.get(i) - s.sample.get(i), 2);
		}
		return Math.sqrt(square);
	}
	

}
