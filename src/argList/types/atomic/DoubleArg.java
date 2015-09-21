package argList.types.atomic;

import argList.types.Arg;

public class DoubleArg extends Arg<Double> {

	public DoubleArg(String name, String description) {
		super(Double.class, name, description);
	}

	@Override
	public Double parseValue(String s) {
		return Double.parseDouble(s);
	}

}
