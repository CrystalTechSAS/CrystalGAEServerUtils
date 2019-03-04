package jcrystal.entity.types;

public class LongText {
	public final String text;
	public LongText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return text;
	}
	public static LongText create(String val) {
		if(val == null)
			return null;
		return new LongText(val);
	}
}
