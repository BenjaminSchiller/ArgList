package argList;

import java.io.PrintStream;
import java.lang.reflect.Constructor;

import argList.types.Arg;

@SuppressWarnings("rawtypes")
public class ArgList<T> {

	public Class<? extends T> c;

	public Arg[] argList;

	public ArgList(Class<? extends T> c, Arg... argList) {
		this.c = c;
		this.argList = argList;
	}

	public T getInstance(String... args) {
		if (args.length != this.argList.length) {
			this.printHelp(args);
			throw new IllegalArgumentException("could not create instance of "
					+ this.c.getName());
		}

		Constructor<? extends T> constr;
		try {
			constr = this.c.getConstructor(this.getParameterTypes());
			return constr.newInstance(this.parseParameters(args));
		} catch (Exception e) {
			this.printHelp(args);
			e.printStackTrace();
			throw new IllegalArgumentException("could not create instance of "
					+ this.c.getName());
		}
	}

	protected Class[] getParameterTypes() {
		Class[] types = new Class[this.argList.length];
		for (int i = 0; i < this.argList.length; i++) {
			types[i] = this.argList[i].getType();
		}
		return types;
	}

	protected Object[] parseParameters(String[] args) {
		Object[] obj = new Object[args.length];
		for (int i = 0; i < args.length; i++) {
			obj[i] = this.argList[i].parseValue(args[i]);
		}
		return obj;
	}

	public void printHelp(String... args) {
		this.printHelp(System.err, args);
	}

	public void printHelp(PrintStream out, String... args) {
		out.println("expecting " + this.argList.length + " arguments (got "
				+ args.length + ")");
		for (int i = 0; i < this.argList.length; i++) {
			String pre1 = i < 10 ? "   " + i + ": " : "  " + i + ": ";
			String pre2 = i < 10 ? "      " : "     ";
			out.println(this.argList[i].getDescription(pre1, pre2));
			if (args.length > i) {
				out.println(pre2 + "--> " + args[i]);
			}
			out.println();
		}
		for (int i = this.argList.length; i < args.length; i++) {
			String pre2 = i < 10 ? "      " : "     ";
			out.println(pre2 + "-> " + args[i]);
		}
	}

}
