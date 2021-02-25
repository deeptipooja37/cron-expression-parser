package com.cronparser.parsers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.cronparser.cronfields.CronFieldBase;

public class Range  extends CronParserBase{

	public Range(CronFieldBase field) {
		super(field);
	}

	@Override
	public List<Integer> getSchedules() {
		String[] range = this.field.getExpression().split("-");
		
		if(range.length!=2) {
			throw new RuntimeException("Range field is not in valid formate:"+this.field.getExpression());
		}
		int start = Integer.valueOf(range[0]);
		int end = Integer.valueOf(range[1]);
		if( end> Integer.valueOf(this.field.getMaxValue()) 
				|| start < Integer.valueOf(this.field.getMinValue())) {
			throw new RuntimeException("Range field is not in valid formate:"+this.field.getExpression());
		}
		return IntStream.rangeClosed(start, end)
				.boxed().collect(Collectors.toList());
	}

}
