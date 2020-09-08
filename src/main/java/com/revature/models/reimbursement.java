package com.revature.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="reimbursement")
public class reimbursement implements Serializable {
	


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_id")
private int reimb_id;
	@Column(name="reimb_amt", nullable=false)
private double reimb_amt;
	
	@CreationTimestamp
	@Column(name="reim_submtd",nullable=false)
private Timestamp reim_submtd;
	
	@UpdateTimestamp
	@Column(name="reim_resolvd",nullable=true)
private Timestamp reim_resolvd;
	
//	@Column(name="reim_recpt")
//private int reim_recpt;
	
	
	@Column(name="reim_desc")
private String reim_desc;
	
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reim_athr",nullable=false)
private Users reim_athr;
	
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="reim_resolr")
private Users userid;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="reim_stts",nullable=false)
	private status reim_statid;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="reim_numb", nullable=false)
private reim_type typeid;

	
	
	public reimbursement() {
		super();
		
	}


public reimbursement(int reimb_id, double reimb_amt, Timestamp reim_submtd, Timestamp reim_resolvd,
			String reim_desc, Users reim_athr, Users reim_resolr, status reim_stts, reim_type reim_typeid) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amt = reimb_amt;
		this.reim_submtd = reim_submtd;
		this.reim_resolvd = reim_resolvd;
		//this.reim_recpt = reim_recpt;
		this.reim_desc = reim_desc;
		this.reim_athr = reim_athr;
		this.userid = reim_resolr;
		this.reim_statid = reim_stts;
		this.typeid = reim_typeid;
	}



public reimbursement(double remamt, Timestamp reim_submtd, Timestamp reim_resolvd, String reim_desc,
		Users reim_athr, Users reim_resolr, status reim_sttsId, reim_type reim_typId) {
	super();
	this.reimb_amt = remamt;
	this.reim_submtd = reim_submtd;
	this.reim_resolvd = reim_resolvd;
	//this.reim_recpt = reim_recpt;
	this.reim_desc = reim_desc;
	this.reim_athr = reim_athr;
	this.userid = reim_resolr;
	this.reim_statid = reim_sttsId;
	this.typeid = reim_typId;
}



public int getReimb_id() {
	return reimb_id;
}





public void setReimb_id(int reimb_id) {
	this.reimb_id = reimb_id;
}





public double getReimb_amt() {
	return reimb_amt;
}





public void setReimb_amt(double reimb_amt) {
	this.reimb_amt = reimb_amt;
}





public Timestamp getReim_submtd() {
	return reim_submtd;
}





public void setReim_submtd(Timestamp reim_submtd) {
	this.reim_submtd = reim_submtd;
}





public Timestamp getReim_resolvd() {
	return reim_resolvd;
}





public void setReim_resolvd(Timestamp reim_resolvd) {
	this.reim_resolvd = reim_resolvd;
}





//public int getReim_recpt() {
//	return reim_recpt;
//}





//public void setReim_recpt(int reim_recpt) {
//	this.reim_recpt = reim_recpt;
//}
//




public String getReim_desc() {
	return reim_desc;
}





public void setReim_desc(String reim_desc) {
	this.reim_desc = reim_desc;
}





public Users getReim_athr() {
	return reim_athr;
}





public void setReim_athr(Users reim_athr) {
	this.reim_athr = reim_athr;
}





public Users getReim_resolr() {
	return userid;
}





public void setReim_resolr(Users reim_resolr) {
	this.userid = reim_resolr;
}





public status getReim_stts() {
	return reim_statid;
}





public void setReim_sttsId(status reim_stts) {
	this.reim_statid= reim_stts;
}





public reim_type getReim_typId() {
	return typeid;
}





public void setReim_typId(reim_type reim_numb) {
	this.typeid = reim_numb;
}





public static long getSerialversionuid() {
	return serialVersionUID;
}



@Override
public String toString() {
	return "reimbursement [reimb_id=" + reimb_id + ", reimb_amt=" + reimb_amt + ", reim_submtd=" + reim_submtd
			+ ", reim_resolvd=" + reim_resolvd + ", reim_desc=" + reim_desc + ", reim_athr=" + reim_athr + ", userid="
			+ userid + ", reim_statid=" + reim_statid + ", typeid=" + typeid + "]";
}














}
