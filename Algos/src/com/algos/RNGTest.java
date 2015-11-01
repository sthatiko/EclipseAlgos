package com.algos;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RNGTest {
	public static void main(String[] args){
		SecureRandom srng;
		try {			
			srng = SecureRandom.getInstance("SHA1PRNG");
			long startTime = System.currentTimeMillis();
			byte[] seed = srng.generateSeed(5);
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken in milli seconds : "+ (endTime - startTime));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
	}
}
