package pa06;

import java.util.ArrayList;
import java.util.Random;

/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of Samples (the one's closest to that sample point, ideally).
 *
 */
public class Cluster {
	private ArrayList<Sample> Samples;
	Sample Cluster_Point;
	public int id;
	
	
	public Cluster(int id) {
		Samples = new ArrayList<Sample>();
		this.Cluster_Point = null;
		this.id = id;
	}
	
	public void set_Cluster_Point(Sample s) {
		this.Cluster_Point = s;
	}
	
	public ArrayList<Sample> getSamples(){
		return Samples;
	}
	
	public void addSample(Sample sample) {
		this.Samples.add(sample);
	}

	public void set_Samples(ArrayList<Sample> s) {
		this.Samples = s;
	}
	/**
	 * It prints out the cluster with its cluster point
	 */
	public void printCluster() {
		System.out.print("This cluster has centroid of: [");
		System.out.print(Cluster_Point + " ");		
		System.out.print("]");
		System.out.println("");
		System.out.print("This cluster contains sample points: [");
		for(Sample  s: Samples) {
			System.out.print(s +"");
		}
		System.out.print("]");
	}

	public void clear() {
		Samples.clear();
	}
	
	/**
	 * It calculates the average value and returns a new Cluster point
	 * @return
	 */
	public Sample new_Centroid() {
		double avgX = 0;
		double avgY = 0;
		for(Sample sample: Samples) {
			avgX += sample.getX();
			avgY += sample.getY();
		}
		avgX /= Samples.size();
		avgY /= Samples.size();
		avgX = (double)Math.round(avgX * 100d) / 100d;
		avgY = (double)Math.round(avgY * 100d) / 100d;
		Sample new_centroid = new Sample(avgX, avgY);
		
		return  new_centroid;
	}
}
