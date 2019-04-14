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
	 * @param time - This represents the current time that users are looking at the tweet
	 */
	public static boolean getChance(int timeElapsed, int currTime) {
		// The times that users are most active on twitter
		// This data was retrieved from https://coschedule.com/blog/best-times-to-post-on-social-media/#twitter 
		// and represents the best time for a 'business to consumer' business to post on twitter
		int[] peakTimes = new int[]{8,9,10,12,19,20,21};
		
		// Retweet chance is the percent change that any given tweet will be retweeted by a twitter user
		// This data was retrieved from https://www.stonetemple.com/twitter-engagement-umasked/
		//double retweetChance = 0.3;
		
		// peakChance depends on whether or not it is a peak time for the user to see a tweet
		double peakChance = 1.5;
		for (int t : peakTimes) {
			if (t == currTime) {
				peakChance = 1.0;
				break;}
			else
				peakChance = 1.5;
		}
		
		
		double randomChance = Math.random()*100.0;

		double threshold = (-5.0) * Math.log( timeElapsed * 10 * peakChance ) + 30.0;

		if (threshold >= randomChance)
			return true;
		else 
			return false;
		
	}
	

}
