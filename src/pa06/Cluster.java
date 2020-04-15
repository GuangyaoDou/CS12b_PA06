package pa06;

import java.util.ArrayList;
import java.util.Random;

/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of Samples (the one's closest to that sample point, ideally).
 * @author presenting
 * Jiaying
 *
 */
public class Cluster {
	ArrayList<Sample> Samples;
	Sample Cluster_Point;
	
	
	public Cluster(ArrayList<Sample> s) {
		Samples = new ArrayList<Sample>();
		for(int i = 0; i<s.size();i++) {
			Samples.add(s.get(i));
		}
	}
	
	public void set_Cluster_Point(Sample s) {
		this.Cluster_Point = s;
	}

	
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

}
