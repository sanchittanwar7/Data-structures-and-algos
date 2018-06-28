package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Bucket{
	ArrayList<Integer> bucket;
	boolean isUsed;
	int bucketMin;
	int bucketMax;

	public Bucket() {
		bucket = new ArrayList<Integer>();
		isUsed = false;
		bucketMin = Integer.MAX_VALUE;
		bucketMax = Integer.MIN_VALUE;
	}
}

public class max_consecutive_gap {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(5, 3, 1, 6, 6, 4, 2, 9));
		System.out.println(maximumGap(arr1));

	}

	public static int maximumGap(final List<Integer> arr) {
		if(arr.size() == 1)
            return 0;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n = arr.size(), i, serialNumber;
		for(Integer ele : arr) {
			if(ele < min)
				min = ele;
			if(ele > max)
				max = ele;
		}
		if(min == max)
			return 0;
		int bucketSize = Math.max(1, (max - min)/(n - 1));
		System.out.println(min + " " + max);
		System.out.println(bucketSize);
		int bucketNum = (max - min)/bucketSize + 1;
		Bucket[] buckets = new Bucket[bucketNum];
		for(i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket();
		}
		for(Integer num : arr) {
			serialNumber = (num - min)/bucketSize;
			buckets[serialNumber].bucket.add(num);
			buckets[serialNumber].isUsed = true;
			buckets[serialNumber].bucketMin = Math.min(buckets[serialNumber].bucketMin, num);
			buckets[serialNumber].bucketMax = Math.max(buckets[serialNumber].bucketMax, num);
		}
		int prevBucketMax = min, maxGap = 0;
		for(Bucket bucket : buckets) {
			if(bucket != null) {
				if(!bucket.isUsed)
					continue;
				maxGap = Math.max(maxGap, bucket.bucketMin - prevBucketMax);
				prevBucketMax = bucket.bucketMax;
			}
		}
		return maxGap;
	}

}
