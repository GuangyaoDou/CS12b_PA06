package pa06;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class K_Means {
	private int k;
	private ArrayList<Cluster> clusters;
	private ArrayList<Sample> centroid = new ArrayList<Sample>();
	private ArrayList<Sample> samples;
	public final static int NUM_CLUSTERS = 3;

	public K_Means(ArrayList<Sample> sample, int k) {
		this.samples = new ArrayList<Sample>();
		this.clusters = new ArrayList<Cluster>();
		for (int i = 0; i < sample.size(); i++) {
			this.samples.add(sample.get(i));
		}
		centroid = Centroid(k); // initialize centroid
		for (int i = 0; i < NUM_CLUSTERS; i++) {
			Cluster cluster = new Cluster(i);
			Sample centro = centroid.get(i);
			cluster.set_Cluster_Point(centro);
			clusters.add(cluster);
		}
		assignCluster();
		System.out.println("Initially: ");
		printClusters();
	}

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner in = new Scanner(System.in);
//		System.out.println("Filename: ");
//		String Filename = in.nextLine();
//		File textfile = new File(Filename);
//		Scanner data = new Scanner(textfile);

		Sample a = new Sample(1, 2);
		Sample b = new Sample(2, 2);
		Sample c = new Sample(4, 5);
		Sample d = new Sample(-1, -2);
		Sample e = new Sample(6, 3);
		Sample f = new Sample(4, 3.333);
		ArrayList<Sample> sample = new ArrayList<Sample>();
		sample.add(a);
		sample.add(b);
		sample.add(c);
		sample.add(e);
		sample.add(d);
//		ArrayList<Sample> test = new ArrayList<Sample>();
//		test.add(e);
//		test.add(a);
//		test.add(b);
		K_Means k_means = new K_Means(sample, 2);
		System.out.println("");
		k_means.conduct_K_Means();
		System.out.println("");
		System.out.println("The Final result is: ");
		k_means.printClusters();
	}

	/**
	 * Calculates the entire k_means algorithm and make sure the algorithm is
	 * working
	 */
	public void conduct_K_Means() {
		boolean done = false;
		int move = 0;

		while (!done) {
			ArrayList<Sample> old_centroid = get_Centroid();
			calculate_Centroid();
			clearClusters();
			assignCluster();

			move++;
			double distance = 0;
			for (int i = 0; i < centroid.size(); i++) {
				distance += old_centroid.get(i).Distance(centroid.get(i));
			}
			System.out.println("----------");
			System.out.println("Move: " + move);
			System.out.println("Centroid distances: " + distance);
			System.out.println("");

			if (distance == 0) {
				done = true;
			}
		}
	}

	/**
	 * Have a copy of Centroid that contains all the cluster points in each cluster
	 * so that we can keep track of the change in Centroid
	 * 
	 * @return the copy of Centroid
	 */
	public ArrayList<Sample> get_Centroid() {
		ArrayList<Sample> centroid = new ArrayList<Sample>();
		for (Cluster cluster : clusters) {
			Sample sample = cluster.Cluster_Point;
			centroid.add(sample);
		}
		return centroid;
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
		ArrayList<Sample> centroid = new ArrayList<Sample>();
		while (centroid.size() <= k) {
			int ran = random.nextInt(samples.size());
			if (!centroid.contains(samples.get(ran))) {
				centroid.add(samples.get(ran));
			}
		}
		return centroid;
	}

	/**
	 * Prints out all the clusters in this K_means algorithm
	 */
	public void printClusters() {
		for (int i = 0; i < clusters.size(); i++) {
			System.out.println("Cluster " + i + " :");
			clusters.get(i).printCluster();
			System.out.println("");
		}
	}

	/**
	 * It clears all clusters
	 */
	public void clearClusters() {
		for (Cluster c : clusters) {
			c.clear();
		}
	}

	/**
	 * Assign each sample to the cluster that has closest cluster point
	 */
	public void assignCluster() {
		for (int i = 0; i < samples.size(); i++) {
			int cluster_id = 0;
			Sample closest_centro = samples.get(i).find_Closest(centroid);
//			System.out.println(samples.get(i).toString() + ": " + closest_centro);
			for (int j = 0; j < clusters.size(); j++) {
				if (clusters.get(j).Cluster_Point.equals(closest_centro)) {
					cluster_id = clusters.get(j).id;
					break;
				}
			}
			samples.get(i).set_Clusters(cluster_id);
			clusters.get(cluster_id).addSample(samples.get(i));
		}
	}

	/**
	 * It recalculates all the cluster points in a given ArrayList of clusters
	 */
	public void calculate_Centroid() {
		for (Cluster cluster : clusters) {
			int id = cluster.id;
			Sample centro = cluster.new_Centroid();
			centroid.set(id, centro);
			cluster.set_Cluster_Point(centro);
		}
	}

}
