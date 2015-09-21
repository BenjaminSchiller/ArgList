package argList.types.atomic;

import argList.types.Arg;

@SuppressWarnings("rawtypes")
public class ClassArg extends Arg<Class> {

	public ClassArg(String name, String description) {
		super(Class.class, name, description);
	}

	@Override
	public Class parseValue(String s) {
		try {
			return Class.forName(s);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("cannot parse " + s
					+ " as a class");
		}
	}
}
