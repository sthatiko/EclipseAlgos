package com.algos;


/**
 * http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 * if last digit is !=0 and <=9 getChar
 * if last 2 digits is <27 && >9 get char
 */
import java.util.ArrayList;
import java.util.List;

public class DigitSequence {

	public static void main(String... args) {
		System.out.print(getDecodings(121121));
	}

	public static ArrayList<String> getDecodings(int num) {
		ArrayList<String> str = new ArrayList<String>();
		if (num ==0 ) {
			str.add("");
			return str;
		} 
		else {
			int lastdigit = num % 10;
			if (lastdigit != 0) {
				List<String> res = getDecodings(num / 10);
				for (String s : res) {
					str.add(s + getCharForNum(lastdigit));
				}
			}
			lastdigit = num % 100; //last 2 digits
			if (lastdigit >9 && lastdigit < 27) {
				List<String> res = getDecodings(num / 100);//remaining number
				for (String s : res) {
					str.add(s + getCharForNum(lastdigit));
				}
			}
		} 
		return str;
	}

	public static char getCharForNum(int num) {
		if (num >= 1 && num <= 26) {
			return ((char) (num + 64));
		}
		return '0';
	}

}
