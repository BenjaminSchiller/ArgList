package argList.types.atomic;

import argList.types.Arg;

public class BooleanArg extends Arg<Boolean> {

	public BooleanArg(String name, String description) {
		super(Boolean.class, name, description);
	}

	@Override
	public Boolean parseValue(String s) {
		return Boolean.parseBoolean(s);
	}

}
