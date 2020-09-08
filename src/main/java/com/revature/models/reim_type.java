package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reim_type")
public class reim_type implements Serializable{
	private static final long serialVersionUID=1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="typeid")
private int typeid;
	@Column(name="reim_tp", nullable=false)
private String reim_tp;
	
	
	
public reim_type() {
	super();
}





public reim_type(int typeid, String reim_tp) {
	super();
	this.typeid = typeid;
	this.reim_tp = reim_tp;
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
