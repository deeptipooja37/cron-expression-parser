package com.cronparser.cronfields;

public class Minute extends CronFieldBase{

	public Minute(String expression) {
		super(expression);
		this.minValue = 0;
		this.maxValue = 59;
	}

}
