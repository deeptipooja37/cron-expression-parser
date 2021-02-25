package com.cronparser.cronfields;

public class Weekday extends CronFieldBase{

	public Weekday(String expression) {
		super(expression);
		this.minValue = 0;
		this.maxValue = 6;
	}

}
