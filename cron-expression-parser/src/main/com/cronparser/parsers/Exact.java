package com.cronparser.parsers;

import java.util.List;

import com.cronparser.cronfields.CronFieldBase;

public class Exact  extends CronParserBase{

	public Exact(CronFieldBase field) {
		super(field);
	}

	@Override
	public List<Integer> getSchedules() {
		Integer value = Integer.valueOf(this.field.getExpression());
		if( value>field.getMaxValue() || value<field.getMinValue() ) {
			throw new RuntimeException("Exact value out of valid range:"+value);
		}
		return List.of(value);
	}

}
