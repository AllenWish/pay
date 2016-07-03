package cn.cgy.pojo;

import java.math.BigDecimal;

/**
 * 
 * @author CGy
 *
 */
public class Outpay {
	private int id;
	private int classId;
	private int type;
	private BigDecimal money;
	private String createUser = "";
	private String createTime = "";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Outpay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Outpay(int id, int classId, int type, BigDecimal money,
			String createUser, String createTime) {
		super();
		this.id = id;
		this.classId = classId;
		this.type = type;
		this.money = money;
		this.createUser = createUser;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Outpay [id=" + id + ", classId=" + classId + ", type=" + type
				+ ", money=" + money + ", createUser=" + createUser
				+ ", createTime=" + createTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classId;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + id;
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + type;
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
		Outpay other = (Outpay) obj;
		if (classId != other.classId)
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (id != other.id)
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
