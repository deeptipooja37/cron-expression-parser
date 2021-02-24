package com.cronparser.cronfields;

public class Months extends CronFieldBase{

	public Months(String expression) {
		super(expression);
		this.minValue = 1;
		this.maxValue = 12;
	}

}
