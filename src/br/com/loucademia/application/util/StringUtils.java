package br.com.loucademia.application.util;

public class StringUtils {
	
	public static boolean isEmpty(String s) {
		if(s == null) {
			return true;
		}
		return s.trim().length() == 0;
	}
	
	public static String leftZeroes(int value, int finalSize) {
		return String.format("%0" + finalSize + "d", value);
	}
	
	/*
	public static void main(String[] args) {
		String st = "   ";
		
		boolean b = StringUtils.isEmpty(st);
		System.err.println(b);
		
		int v = 100;
		
		System.err.println(StringUtils.leftZeroes(v, 5));
	} 
	*/

}
