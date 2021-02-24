package com.cronparser.cronfields;

public class Day extends CronFieldBase{

	public Day(String expression) {
		super(expression);
		this.minValue = 0;
		this.maxValue = 31;
	}

}
