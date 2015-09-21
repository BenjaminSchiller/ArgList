package argList.types.atomic;

import argList.types.Arg;

public class StringArg extends Arg<String> {

	public StringArg(String name, String description) {
		super(String.class, name, description);
	}

	@Override
	public String parseValue(String s) {
		return s;
	}

}
