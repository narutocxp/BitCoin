package com.bitcoin.utils;

import java.util.ArrayList;
import java.util.List;

public class VCodeUtils {

	public static String Vcode(int bit) {
		String[] code = new String[] { "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z", "陈","小","平","林","梦","兰","张","秋","霞","林","晓","飞"}; 
		List<Integer> set = new ArrayList<Integer>();
		int r;
		for (int i = 0; i < bit; i++) {
			r = (int) (Math.random() * 47);
			set.add(r);
		}

		StringBuffer StrBuff = new StringBuffer("");

		for (int index : set) {
			StrBuff.append(code[index]);
		}

		return StrBuff.toString();
	}

}
