package argList.types.atomic;

import argList.types.Arg;

public class EnumArg extends Arg<String> {

	private Object[] list;

	public EnumArg(String name, String description, Object[] list) {
		super(String.class, name, description);
		this.list = list;
	}

	@Override
	public String getDescription(String pre1, String pre2) {
		StringBuffer buff = new StringBuffer();
		for (Object obj : this.list) {
			buff.append(" " + obj.toString());
		}
		return super.getDescription(pre1, pre2) + "\n" + pre2 + "values: "
				+ buff.toString();
	}

	@Override
	public String parseValue(String s) {
		return s;
	}

}
