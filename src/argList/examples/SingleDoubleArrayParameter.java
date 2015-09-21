package argList.examples;

import argList.ArgList;
import argList.types.array.DoubleArrayArg;

public class SingleDoubleArrayParameter {

	public Double[] arg1;

	public SingleDoubleArrayParameter(Double[] arg1) {
		this.arg1 = arg1;
	}

	public static void main(String[] args) {
		args = new String[] { "1,3.0012,5.25,2.7,4,78" };
		ArgList<SingleDoubleArrayParameter> argList = new ArgList<SingleDoubleArrayParameter>(
				SingleDoubleArrayParameter.class, new DoubleArrayArg(
						"double list", "list of double values", ","));

		SingleDoubleArrayParameter example = argList.getInstance(args);
		for (double d : example.arg1) {
			System.out.println(d);
		}
	}

}
