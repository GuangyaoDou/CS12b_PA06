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
	ArrayList<Sample> cluster;
	Sample Cluster_Point;
	
	public Cluster(ArrayList<Sample> s) {
		cluster = new ArrayList<Sample>();
		for(int i = 0; i<s.size();i++) {
			cluster.add(s.get(i));
		}
	}
	
	/**
	 * Returns an ArrayList of randomly chosen cluster points used when we initiallze K means algorithim
	 * @param k is the number of cluster points we are looking for in a given cluster
	 * @return
	 */
	public ArrayList<Sample> Centroid(int k){
		Random random = new Random();
		ArrayList<Sample> centroid = new ArrayList<Sample>();
		while(centroid.size()!= k) {
			int ran = random.nextInt(cluster.size());
			if(!centroid.contains(cluster.get(ran))){
				centroid.add(cluster.get(ran));
			}
		}
		return centroid;
	}

}
