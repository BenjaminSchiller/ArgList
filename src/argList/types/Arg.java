package argList.types;

public abstract class Arg<T> {
	private Class<? extends T> c;

	public Class<? extends T> getType() {
		return this.c;
	}

	private String name;

	public String getName() {
		return this.name;
	}

	private String description;

	public String getDescription(String pre1, String pre2) {
		return pre1 + this.name + " - " + this.description + " ("
				+ c.getSimpleName() + ")";
	}

	public Arg(Class<? extends T> c, String name, String description) {
		this.c = c;
		this.name = name;
		this.description = description;
	}

	public abstract T parseValue(String s);
}
