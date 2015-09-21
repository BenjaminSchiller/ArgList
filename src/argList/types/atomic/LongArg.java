package argList.types.atomic;

import argList.types.Arg;

public class LongArg extends Arg<Long> {

	public LongArg(String name, String description) {
		super(Long.class, name, description);
	}

	@Override
	public Long parseValue(String s) {
		return Long.parseLong(s);
	}

}
