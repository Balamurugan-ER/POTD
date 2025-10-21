//$Id$
package com.bm.gfg.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * -------------------------------- <br>
 * Problem: Top K Frequent in Array <br>
 * -------------------------------- <br>
 * Difficulty: Medium
 * Accuracy: 40.23%
 * Submissions: 101K+
 * Points: 4
 * Average Time: 30m
 *
 * <p><b>Problem Statement:</b>
 * Given a non-empty integer array arr[]. Your task is to find and return
 * the top k elements which have the highest frequency in the array.
 *
 * <p><b>Note:</b> If two numbers have the same frequency, the larger number
 * should be given the higher priority.
 *
 * <p><b>Examples:</b>
 *
 * <pre>
 * Input:  arr[] = [3, 1, 4, 4, 5, 2, 6, 1], k = 2
 * Output: [4, 1]
 * Explanation:
 * Frequency of 4 is 2 and frequency of 1 is 2.
 * These two have the maximum frequency and 4 is larger than 1.
 * 
 * Input:  arr[] = [7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9], k = 4
 * Output: [5, 11, 7, 10]
 * Explanation:
 * Frequency of 5 is 3,
 * frequency of 11 is 2,
 * frequency of 7 is 2,
 * frequency of 10 is 1.
 * </pre>
 *
 * <p><b>Constraints:</b>
 * <ul>
 *   <li>1 ≤ arr.size() ≤ 10<sup>5</sup></li>
 *   <li>1 ≤ arr[i] ≤ 10<sup>5</sup></li>
 *   <li>1 ≤ k ≤ number of distinct elements</li>
 * </ul>
 *
 * <p><b>Expected Complexities:</b>
 * <ul>
 *   <li>Time Complexity: O(n log n)</li>
 *   <li>Auxiliary Space: O(n)</li>
 * </ul>
 *
 * <p><b>Company Tags:</b> Amazon, Microsoft
 * <br><b>Topic Tags:</b> Arrays, Hashing, Sorting, Data Structures, Algorithms
 *
 * <p><b>Source:</b> 
 * <a href="https://practice.geeksforgeeks.org/problems/top-k-frequent-in-array/1">
 * GeeksforGeeks – Top K Frequent in Array
 * </a>
 */

public class TopKFrequentInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
//		int k = 2;
		int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
		int k = 4;
		Map<Integer, Integer> freqMap = new HashMap<>();
		int maxFreq = 1;
		for(int i = 0; i < arr.length; i++) {
			Integer freq = freqMap.getOrDefault(arr[i], 0);
			if(maxFreq < freq + 1) {
				maxFreq = freq + 1;
			}
			freqMap.put(arr[i], ++freq);
		}
		System.out.println(freqMap);
		List<Integer> result = freqMap.entrySet().stream()
				.sorted((a, b) -> {
					if (!a.getValue().equals(b.getValue()))
						return b.getValue() - a.getValue();
					return b.getKey() - a.getKey();
				})
				.limit(k)
				.map(Map.Entry::getKey)
				.toList();
		
		ArrayList<Integer> answer = new ArrayList<>();
		answer.addAll(result);
		System.out.println(answer);
	}

}
