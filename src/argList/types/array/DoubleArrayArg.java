package argList.types.array;

import argList.types.ArrayArg;

public class DoubleArrayArg extends ArrayArg<Double> {

	public DoubleArrayArg(String name, String description, String separator) {
		super(Double[].class, name, description, separator);
	}

	@Override
	public Double[] parseValues(String[] s) {
		Double[] values = new Double[s.length];
		for (int i = 0; i < s.length; i++) {
			values[i] = Double.parseDouble(s[i]);
		}
		return values;
	}

}
