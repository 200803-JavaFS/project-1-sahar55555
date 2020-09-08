package com.revature.models;

import java.io.Serializable;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users implements Serializable {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="userid")
private int userid;
@Column(name="usrnm",nullable=false)
private String usrnm;
@Column(name="usrpaswd", nullable=false)
private String usrpaswd;
@Column(name="usr_fname",nullable=false)
private String usr_fname;
@Column(name="usr_lname",nullable=false)
private String usr_lname;
@Column(name="usreml",nullable=false,unique=true)
private String usreml;
@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name="usr_rlid", nullable=false)
private useRl usr_rlid;

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
public useRl getUsr_rlid() {
	return usr_rlid;
}
public void setUsr_rlid(useRl usr_rlid) {
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
	result = prime * result + ((usr_rlid == null) ? 0 : usr_rlid.hashCode());
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
	if (usr_rlid == null) {
		if (other.usr_rlid != null)
			return false;
	} else if (!usr_rlid.equals(other.usr_rlid))
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
