package com.cronparser.parsers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.cronparser.cronfields.CronFieldBase;

public class Step  extends CronParserBase{

	public Step(CronFieldBase field) {
		super(field);
	}

	@Override
	public List<Integer> getSchedules() {
		String[] steps = this.field.getExpression().split("/");
		if(steps.length!=2) {
			throw new RuntimeException("Invalid steps field:"+this.field.getExpression());
		}
		
		if(steps[0].equals("*")) {
			steps[0] = this.field.getMinValue().toString();
		}
		int start = Integer.valueOf(steps[0]);
		int offset = Integer.valueOf(steps[1]);
		int limit = ( this.field.getMaxValue() - this.field.getMinValue())/offset +1;
		
		List<Integer> schedules = IntStream.iterate(start, num -> num + offset)
											.limit(limit)
											.boxed()
											.collect(Collectors.toList());
		return schedules;
	}

}
