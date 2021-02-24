package com.cronparser.cronfields;

public class Hour extends CronFieldBase{

	public Hour(String expression) {
		super(expression);
		this.minValue = 0;
		this.maxValue = 23;
	}

}
