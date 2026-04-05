package characters;

import java.io.Serializable;

public class Pokemon implements Serializable {
	
	private static final long serialVersionUID = 1819836858876732244L;
	
	private String name;
	private String type;
	private int level;
	
	public Pokemon(String name, String type, int level) {
	    this.name = name;
	    this.type = type;
	    this.level = level;
	}

	public String name() {
	    return name;
	}

	public String type() {
	    return type;
	}

	public int level() {
	    return level;
	}

	@Override
	public String toString() {
	    return "Pokemon[name=" + name + ", type=" + type + ", level=" + level + "]";
	}
}
