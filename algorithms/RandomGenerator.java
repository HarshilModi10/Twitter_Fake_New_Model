package graph;


/**
 * This class implements the random generator that decides if a given tweet is retweeted in an iteration 
 * @since 03/27/2019
 */
public class RandomGenerator {
	
	/**
	 * This method returns a boolean value on what the chance is for a user
	 * @param currTime - This represents the current time that users are looking at the tweet.
	 * @param timeElapsed - This represents the total time elapsed from the initial fake tweet.
	 * @return boolean value indicating whether the node will be marked as "retweeted"
	 */
	public static boolean getChance(int timeElapsed, int currTime) {
		// The times that users are most active on twitter
		// This data was retrieved from https://coschedule.com/blog/best-times-to-post-on-social-media/#twitter 
		// and represents the best time for a 'business to consumer' business to post on twitter
		int[] peakTimes = new int[]{8,9,10,12,19,20,21};
		
		// peakChance depends on whether or not it is a peak time for the user to see a tweet from the data above
		double peakChance = 1.5;
		for (int t : peakTimes) {
			if (t == currTime) {
				peakChance = 1.0;
				break;}
			else
				peakChance = 1.5;
		}
		
		// This is just a random double generated from 0-100 to represent the element of randomness that goes
		// into whether or not someone sees a tweet
		double randomChance = Math.random()*100.0;

		// This mathematical expression models the half life of a tweet, look to the specifications for further knowledge
		double threshold = (-5.0) * Math.log( timeElapsed * 10 * peakChance ) + 30.0;

		if (threshold >= randomChance)
			return true;
		else 
			return false;
		
	}
	

}
