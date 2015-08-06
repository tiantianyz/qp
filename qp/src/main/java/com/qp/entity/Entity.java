package com.qp.entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;


public abstract class Entity implements Serializable {

	private static final long serialVersionUID = -1835696532319820130L;

	public String toString(){
		return ReflectionToStringBuilder.reflectionToString(this);
	}
	
	public boolean equals(Object vo) {
		return EqualsBuilder.reflectionEquals(this, vo);
	}
	
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
