package com.revature.models;

public class useRl {
private int useroleid;
private String userole;
public useRl() {
	super();
}
public int getUseroleid() {
	return useroleid;
}
public void setUseroleid(int useroleid) {
	this.useroleid = useroleid;
}
public String getUserole() {
	return userole;
}
public void setUserole(String userole) {
	this.userole = userole;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((userole == null) ? 0 : userole.hashCode());
	result = prime * result + useroleid;
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
	useRl other = (useRl) obj;
	if (userole == null) {
		if (other.userole != null)
			return false;
	} else if (!userole.equals(other.userole))
		return false;
	if (useroleid != other.useroleid)
		return false;
	return true;
}


}
