package pa06;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class K_Means {
	private int k;
	private Cluster[] clusters;
	private ArrayList<Sample> centroid = new ArrayList<Sample>();

	public K_Means(int k) {
		clusters = new Cluster[k];
		centroid = Centroid(k);
	}

	/**
	 * Returns an ArrayList of randomly chosen cluster points used when we
	 * initialize K means algorithm
	 * 
	 * @param k is the number of cluster points we are looking for in a given
	 *          cluster
	 * @return
	 */
	public ArrayList<Sample> Centroid(int k) {
		Random random = new Random();
		for (int i = 0; i < clusters.length; i++) {
			while (centroid.size() < i + 1) {
				int ran = random.nextInt(clusters[i].Samples.size());
				if (!centroid.contains(clusters[i].Samples.get(ran))) {
					centroid.add(clusters[i].Samples.get(ran));
				}
			}
		}
		return centroid;
	}

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner in = new Scanner(System.in);
//		System.out.println("Filename: ");
//		String Filename = in.nextLine();
//		
//		File textfile = new File(Filename);
//		Scanner data = new Scanner(textfile);

		Sample a = new Sample(1, 2);
		Sample b = new Sample(2, 2);
		Sample c = new Sample(4, 5);
		Sample d = new Sample(-1, -2);
		Sample e = new Sample(6, 3);
		ArrayList<Sample> sample = new ArrayList<Sample>();
		sample.add(a);
		sample.add(b);
		sample.add(c);
		sample.add(e);
		sample.add(d);
		Cluster cluster = new Cluster(sample);
//		cluster.Centroid(2);
		cluster.printCluster();
	}

}
