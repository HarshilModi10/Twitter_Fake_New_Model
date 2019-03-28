package graph;

import java.util.*;

/**
 * This class implements the random generator that decides if a given tweet is retweeted in an iteration 
 * @author Justin Rosner and Justin Prez
 * @since 03/27/2019
 */
public class RandomGenerator {
	
	/**
	 * This method returns a boolean value on what the chance is for a user
	 */
	public static double getChance(int time) {
		// The times that users are most active on twitter
		// This data was retrieved from https://coschedule.com/blog/best-times-to-post-on-social-media/#twitter 
		// and represents the best time for a 'business to consumer' business to post on twitter
		int[] peakTimes = new int[]{8,9,10,12,19,20,21};
		
		// Retweet chance is the percent change that any given tweet will be retweeted by a twitter user
		// This data was retrieved from https://www.stonetemple.com/twitter-engagement-umasked/
		double retweetChance = 0.3;
		
		// peakChance depends on whether or not it is a peak time for the user to see a tweet
		double peakChance = 0.0;
		for (int t : peakTimes) {
			if (t == time)
				peakChance = 0.6;
			else
				peakChance = 0.4;
		}
		
		double randomChance = Math.random();
		
		double tempChance = peakChance * retweetChance;
		
		
		double k = Math.log(0.9) / 0.9;
		
		double chance = Math.exp(k * time) * randomChance;

		return chance;
		
	}
	
	public static void main(String[] args) {
		getChance(0);
		getChance(1);
		getChance(2);
		getChance(3);
		getChance(4);
		getChance(5);
		getChance(6);
		getChance(7);
		getChance(8);
		getChance(9);
		getChance(10);
		getChance(11);
		getChance(12);
		getChance(13);
		getChance(14);
		getChance(15);
		getChance(16);
		getChance(17);
		getChance(18);
		getChance(19);
		getChance(20);
		getChance(21);
		getChance(22);
		getChance(23);
	}
}
