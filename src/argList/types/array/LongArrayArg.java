package argList.types.array;

import argList.types.ArrayArg;

public class LongArrayArg extends ArrayArg<Long> {

	public LongArrayArg(String name, String description, String separator) {
		super(Long[].class, name, description, separator);
	}

	@Override
	public Long[] parseValues(String[] s) {
		Long[] values = new Long[s.length];
		for (int i = 0; i < s.length; i++) {
			values[i] = Long.parseLong(s[i]);
		}
		return values;
	}

}
