package argList.types.array;

import argList.types.ArrayArg;

public class IntArrayArg extends ArrayArg<Integer> {

	public IntArrayArg(String name, String description, String separator) {
		super(Integer[].class, name, description, separator);
	}

	@Override
	public Integer[] parseValues(String[] s) {
		Integer[] values = new Integer[s.length];
		for (int i = 0; i < s.length; i++) {
			values[i] = Integer.parseInt(s[i]);
		}
		return values;
	}

}
