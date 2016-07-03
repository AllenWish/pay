package cn.cgy.pojo;

/**
 * 
 * @author CGy 2016-5-4 22:52:44
 */
public class Classification {
	private int id;
	/** 大类 */
	private String class1;
	/** 中类 */
	private String class2;
	/** 小类 */
	private String class3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	public String getClass2() {
		return class2;
	}

	public void setClass2(String class2) {
		this.class2 = class2;
	}

	public String getClass3() {
		return class3;
	}

	public void setClass3(String class3) {
		this.class3 = class3;
	}

	public Classification(int id, String class1, String class2, String class3) {
		super();
		this.id = id;
		this.class1 = class1;
		this.class2 = class2;
		this.class3 = class3;
	}

	public Classification() {
		super();
	}

	@Override
	public String toString() {
		return "Classification [id=" + id + ", class1=" + class1 + ", class2="
				+ class2 + ", class3=" + class3 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((class1 == null) ? 0 : class1.hashCode());
		result = prime * result + ((class2 == null) ? 0 : class2.hashCode());
		result = prime * result + ((class3 == null) ? 0 : class3.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classification other = (Classification) obj;
		if (class1 == null) {
			if (other.class1 != null)
				return false;
		} else if (!class1.equals(other.class1))
			return false;
		if (class2 == null) {
			if (other.class2 != null)
				return false;
		} else if (!class2.equals(other.class2))
			return false;
		if (class3 == null) {
			if (other.class3 != null)
				return false;
		} else if (!class3.equals(other.class3))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
