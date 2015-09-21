package argList.types.array;

import argList.types.ArrayArg;

public class EnumArrayArg extends ArrayArg<String> {

	private Object[] list;

	public EnumArrayArg(String name, String description, String separator,
			Object[] list) {
		super(String[].class, name, description, separator);
		this.list = list;
	}

	@Override
	public String getDescription(String pre1, String pre2) {
		StringBuffer buff = new StringBuffer();
		for (Object obj : this.list) {
			buff.append(" " + obj.toString());
		}
		return super.getDescription(pre1, pre2) + "\n" + pre2 + "from:"
				+ buff.toString();
	}

	@Override
	public String[] parseValues(String[] s) {
		return s;
	}

}
