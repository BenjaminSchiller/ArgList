package argList.types;

public abstract class ArrayArg<T> extends Arg<T[]> {

	protected String separator;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayArg(Class c, String name, String description, String separator) {
		super(c, name, description);
		this.separator = separator;
	}

	@Override
	public String getDescription(String pre1, String pre2) {
		return super.getDescription(pre1, pre2) + " sep. by '" + this.separator
				+ "'";
	}

	@Override
	public T[] parseValue(String s) {
		return this.parseValues(s.split(this.separator));
	}

	public abstract T[] parseValues(String[] s);

}
