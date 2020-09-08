package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userRl")
public class useRl implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int useroleid;
	@Column(name="userole",nullable=false)
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
