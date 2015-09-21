package argList.examples;

import argList.ArgList;
import argList.types.atomic.IntArg;

public class SingleIntParameter {

	public int arg1;

	public SingleIntParameter(Integer arg1) {
		this.arg1 = arg1;
	}

	public static void main(String[] args) {
		args = new String[] { "1,3.0012,5.25,2.7,4,78" };
		args = new String[] { "158235" };

		ArgList<SingleIntParameter> argList = new ArgList<SingleIntParameter>(
				SingleIntParameter.class, new IntArg("int value",
						"this is an example int argument"));

		SingleIntParameter example = argList.getInstance(args);
		System.out.println(example.arg1);
	}

}
