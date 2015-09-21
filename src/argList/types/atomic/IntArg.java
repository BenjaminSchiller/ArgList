package argList.types.atomic;

import argList.types.Arg;

public class IntArg extends Arg<Integer> {

	public IntArg(String name, String description) {
		super(Integer.class, name, description);
	}

	@Override
	public Integer parseValue(String s) {
		return Integer.parseInt(s);
	}

}
