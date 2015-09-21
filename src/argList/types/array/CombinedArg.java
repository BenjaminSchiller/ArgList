package argList.types.array;

import argList.types.Arg;
import argList.types.ArrayArg;


@SuppressWarnings("rawtypes")
public class CombinedArg extends ArrayArg<Object> {

	protected Arg[] argList;

	public CombinedArg(String name, String description, String separator,
			Arg... argList) {
		super(Object[].class, name, description, separator);
		this.argList = argList;
	}

	@Override
	public String getDescription(String pre1, String pre2) {
		StringBuffer buff = new StringBuffer(super.getDescription(pre1, pre2));
		for (Arg arg : this.argList) {
			buff.append("\n" + arg.getDescription(pre2, pre2 + "  "));
		}
		return buff.toString();
	}

	@Override
	public Object[] parseValues(String[] s) {
		if (s.length != this.argList.length) {
			throw new IllegalArgumentException(
					"invalid number of arguments for " + this.getName()
							+ " (got " + s.length + " but "
							+ this.argList.length + " expected)");
		}
		Object[] values = new Object[this.argList.length];
		for (int i = 0; i < s.length; i++) {
			values[i] = this.argList[i].parseValue(s[i]);
		}
		return values;
	}

}
