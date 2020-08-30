package com.revature.models;

public class reimbursement {
private int reimb_id;
private int reimb_amt;
private int reim_submtd;
private int reim_resolvd;
private int reim_recpt;
private String reim_desc;
private int reim_athr;
private int reim_resolr;
private int reim_stts;
private int reim_numb;
public reimbursement() {
	super();
}
public int getReimb_id() {
	return reimb_id;
}
public void setReimb_id(int reimb_id) {
	this.reimb_id = reimb_id;
}
public int getReimb_amt() {
	return reimb_amt;
}
public void setReimb_amt(int reimb_amt) {
	this.reimb_amt = reimb_amt;
}
public int getReim_submtd() {
	return reim_submtd;
}
public void setReim_submtd(int reim_submtd) {
	this.reim_submtd = reim_submtd;
}
public int getReim_resolvd() {
	return reim_resolvd;
}
public void setReim_resolvd(int reim_resolvd) {
	this.reim_resolvd = reim_resolvd;
}
public int getReim_recpt() {
	return reim_recpt;
}
public void setReim_recpt(int reim_recpt) {
	this.reim_recpt = reim_recpt;
}
public String getReim_desc() {
	return reim_desc;
}
public void setReim_desc(String reim_desc) {
	this.reim_desc = reim_desc;
}
public int getReim_athr() {
	return reim_athr;
}
public void setReim_athr(int reim_athr) {
	this.reim_athr = reim_athr;
}
public int getReim_resolr() {
	return reim_resolr;
}
public void setReim_resolr(int reim_resolr) {
	this.reim_resolr = reim_resolr;
}
public int getReim_stts() {
	return reim_stts;
}
public void setReim_stts(int reim_stts) {
	this.reim_stts = reim_stts;
}
public int getReim_numb() {
	return reim_numb;
}
public void setReim_numb(int reim_numb) {
	this.reim_numb = reim_numb;
}
@Override
public String toString() {
	return "reimbursement [reimb_id=" + reimb_id + ", reimb_amt=" + reimb_amt + ", reim_submtd=" + reim_submtd
			+ ", reim_resolvd=" + reim_resolvd + ", reim_recpt=" + reim_recpt + ", reim_desc=" + reim_desc
			+ ", reim_athr=" + reim_athr + ", reim_resolr=" + reim_resolr + ", reim_stts=" + reim_stts + ", reim_numb="
			+ reim_numb + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + reim_athr;
	result = prime * result + ((reim_desc == null) ? 0 : reim_desc.hashCode());
	result = prime * result + reim_numb;
	result = prime * result + reim_recpt;
	result = prime * result + reim_resolr;
	result = prime * result + reim_resolvd;
	result = prime * result + reim_stts;
	result = prime * result + reim_submtd;
	result = prime * result + reimb_amt;
	result = prime * result + reimb_id;
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
	reimbursement other = (reimbursement) obj;
	if (reim_athr != other.reim_athr)
		return false;
	if (reim_desc == null) {
		if (other.reim_desc != null)
			return false;
	} else if (!reim_desc.equals(other.reim_desc))
		return false;
	if (reim_numb != other.reim_numb)
		return false;
	if (reim_recpt != other.reim_recpt)
		return false;
	if (reim_resolr != other.reim_resolr)
		return false;
	if (reim_resolvd != other.reim_resolvd)
		return false;
	if (reim_stts != other.reim_stts)
		return false;
	if (reim_submtd != other.reim_submtd)
		return false;
	if (reimb_amt != other.reimb_amt)
		return false;
	if (reimb_id != other.reimb_id)
		return false;
	return true;
}


}
