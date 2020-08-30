package com.revature.models;

public class status {
private int reim_statid;
private String reim_status;
public status()
{
	super();
}
public int getReim_statid() {
	return reim_statid;
}
public void setReim_statid(int reim_statid) {
	this.reim_statid = reim_statid;
}
public String getReim_status() {
	return reim_status;
}
public void setReim_status(String reim_status) {
	this.reim_status = reim_status;
}
@Override
public String toString() {
	return "status [reim_statid=" + reim_statid + ", reim_status=" + reim_status + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + reim_statid;
	result = prime * result + ((reim_status == null) ? 0 : reim_status.hashCode());
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
	status other = (status) obj;
	if (reim_statid != other.reim_statid)
		return false;
	if (reim_status == null) {
		if (other.reim_status != null)
			return false;
	} else if (!reim_status.equals(other.reim_status))
		return false;
	return true;
}


}
