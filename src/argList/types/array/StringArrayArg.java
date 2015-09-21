package argList.types.array;

import argList.types.ArrayArg;

public class StringArrayArg extends ArrayArg<String> {

	public StringArrayArg(String name, String description, String separator) {
		super(String[].class, name, description, separator);
	}

	@Override
	public String[] parseValues(String[] s) {
		return s;
	}

}
