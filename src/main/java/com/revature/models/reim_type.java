package com.revature.models;

public class reim_type {
private int typeid;
private String reim_tp;
public reim_type() {
	super();
}
public int getTypeid() {
	return typeid;
}
public void setTypeid(int typeid) {
	this.typeid = typeid;
}
public String getReim_tp() {
	return reim_tp;
}
public void setReim_tp(String reim_tp) {
	this.reim_tp = reim_tp;
}
@Override
public String toString() {
	return "reim_type [typeid=" + typeid + ", reim_tp=" + reim_tp + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((reim_tp == null) ? 0 : reim_tp.hashCode());
	result = prime * result + typeid;
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
	reim_type other = (reim_type) obj;
	if (reim_tp == null) {
		if (other.reim_tp != null)
			return false;
	} else if (!reim_tp.equals(other.reim_tp))
		return false;
	if (typeid != other.typeid)
		return false;
	return true;
}

}
