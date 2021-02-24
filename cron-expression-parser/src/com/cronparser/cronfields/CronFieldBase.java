package com.cronparser.cronfields;

import java.util.List;

import com.cronparser.parsers.CronParserBase;

public abstract class CronFieldBase<T> {

	Integer minValue;
	Integer maxValue;
	String expression;
	List<T> schedules;
	
	public Integer getMinValue() {
		return minValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public String getExpression() {
		return expression;
	}

	public List<T> getSchedules() {
		return schedules;
	}

	public CronFieldBase(String expression) {
		this.expression = expression;
	}
	
	public List<T> parse(){
		this.schedules = (List<T>) CronParserBase.getParser(this).getSchedules();
		return this.schedules;
	}
	
}
