package com.revature.models;

public class Users {
private int userid;
private String usrnm;
private String usrpaswd;
private String usr_fname;
private String usr_lname;
private String usreml;
private int usr_rlid;
public Users() {
	super();
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsrnm() {
	return usrnm;
}
public void setUsrnm(String usrnm) {
	this.usrnm = usrnm;
}
public String getUsrpaswd() {
	return usrpaswd;
}
public void setUsrpaswd(String usrpaswd) {
	this.usrpaswd = usrpaswd;
}
public String getUsr_fname() {
	return usr_fname;
}
public void setUsr_fname(String usr_fname) {
	this.usr_fname = usr_fname;
}
public String getUsr_lname() {
	return usr_lname;
}
public void setUsr_lname(String usr_lname) {
	this.usr_lname = usr_lname;
}
public String getUsreml() {
	return usreml;
}
public void setUsreml(String usreml) {
	this.usreml = usreml;
}
public int getUsr_rlid() {
	return usr_rlid;
}
public void setUsr_rlid(int usr_rlid) {
	this.usr_rlid = usr_rlid;
}
@Override
public String toString() {
	return "Users [userid=" + userid + ", usrnm=" + usrnm + ", usrpaswd=" + usrpaswd + ", usr_fname=" + usr_fname
			+ ", usr_lname=" + usr_lname + ", usreml=" + usreml + ", usr_rlid=" + usr_rlid + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + userid;
	result = prime * result + ((usr_fname == null) ? 0 : usr_fname.hashCode());
	result = prime * result + ((usr_lname == null) ? 0 : usr_lname.hashCode());
	result = prime * result + usr_rlid;
	result = prime * result + ((usreml == null) ? 0 : usreml.hashCode());
	result = prime * result + ((usrnm == null) ? 0 : usrnm.hashCode());
	result = prime * result + ((usrpaswd == null) ? 0 : usrpaswd.hashCode());
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
	Users other = (Users) obj;
	if (userid != other.userid)
		return false;
	if (usr_fname == null) {
		if (other.usr_fname != null)
			return false;
	} else if (!usr_fname.equals(other.usr_fname))
		return false;
	if (usr_lname == null) {
		if (other.usr_lname != null)
			return false;
	} else if (!usr_lname.equals(other.usr_lname))
		return false;
	if (usr_rlid != other.usr_rlid)
		return false;
	if (usreml == null) {
		if (other.usreml != null)
			return false;
	} else if (!usreml.equals(other.usreml))
		return false;
	if (usrnm == null) {
		if (other.usrnm != null)
			return false;
	} else if (!usrnm.equals(other.usrnm))
		return false;
	if (usrpaswd == null) {
		if (other.usrpaswd != null)
			return false;
	} else if (!usrpaswd.equals(other.usrpaswd))
		return false;
	return true;
}



}
