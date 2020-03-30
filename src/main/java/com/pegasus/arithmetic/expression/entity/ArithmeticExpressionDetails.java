package com.pegasus.arithmetic.expression.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arithmetic_expression_details")
public class ArithmeticExpressionDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "expression")
	private String expression;

	@Column(name = "output")
	private String output;

	@Column(name = "created_datetime")
	private String createdDatetime;

	@Column(name = "updated_datetime")
	private String updatedDatetime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(String createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getUpdatedDatetime() {
		return updatedDatetime;
	}

	public void setUpdatedDatetime(String updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}

	@Override
	public String toString() {
		return "ArithmeticExpressionDetails [id=" + id + ", expression=" + expression + ", output=" + output
				+ ", createdDatetime=" + createdDatetime + ", updatedDatetime=" + updatedDatetime + "]";
	}

}
