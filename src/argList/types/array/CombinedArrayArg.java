package argList.types.array;

import argList.types.ArrayArg;

public class CombinedArrayArg extends ArrayArg<Object[]> {

	CombinedArg combined;

	public CombinedArrayArg(String name, String description, String separator,
			CombinedArg combined) {
		super(Object[][].class, name, description, separator);
		this.combined = combined;
	}

	@Override
	public String getDescription(String pre1, String pre2) {
		StringBuffer buff = new StringBuffer(super.getDescription(pre1, pre2));
		buff.append("\n"
				+ this.combined.getDescription(pre2 + "  ", pre2 + "    "));
		return buff.toString();
	}

	@Override
	public Object[][] parseValues(String[] s) {
		if (s.length == 1 && (s[0].equals(this.separator) || s[0].equals(""))) {
			return new Object[0][0];
		}
		Object[][] values = new Object[s.length][];
		for (int i = 0; i < s.length; i++) {
			values[i] = this.combined.parseValue(s[i]);
		}
		return values;
	}

}
