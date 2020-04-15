package pa06;

import java.util.ArrayList;

/**
 * A Sample represents a vector of doubles to be used in a clustering
 * algorithm...
 * 
 * @author presenting
 *
 */

public class Sample {
	ArrayList<Double> sample;
	private int cluster_id;

	public Sample(double[] values) {
		this.sample = new ArrayList<Double>();
		for (int i = 0; i < values.length; i++) {
			sample.add(values[i]);
		}
	}

	public Sample(double x, double y) {
		this.sample = new ArrayList<Double>();
		sample.add(x);
		sample.add(y);
	}

	public double getX() {
		return sample.get(0);
	}

	public double getY() {
		return sample.get(1);
	}

	public void setX(double x) {
		sample.set(0, x);
	}

	public void setY(double y) {
		sample.set(1, y);
	}

	public void set_Clusters(int n) {
		this.cluster_id = n;
	}

	/**
	 * It finds out the distance between itself and other given sample s
	 * 
	 * @param s is another Sample we are going to find the distance in between
	 */
	public double Distance(Sample s) {
		double square = 0;
		for (int i = 0; i < s.sample.size(); i++) {
			double difference = (double) Math.round((this.sample.get(i) - s.sample.get(i)) * 100d) / 100d;
			square += Math.pow(difference, 2);
		}
		return Math.sqrt(square);
	}

	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}

	/**
	 * This method finds out its closest cluster_point
	 * 
	 * @param s is an ArrayList of centroid
	 * @return
	 */
	public Sample find_Closest(ArrayList<Sample> s) {
		int i = 0;
		Sample shortest = null;
		double distance = 0;

		shortest = s.get(0);
		distance = this.Distance(s.get(0));

		while (i < s.size()) {
			double dist = this.Distance(s.get(i));
			if (dist < distance) {
				distance = dist;
				shortest = s.get(i);

			}
			i++;
		}
		return shortest;
	}

	public boolean equals(Sample s) {
		return this.getX() == s.getX() && this.getY() == s.getY();
	}

}
