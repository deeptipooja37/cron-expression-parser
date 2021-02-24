package com.cronparser.parsers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.cronparser.cronfields.CronFieldBase;

public class Any extends CronParserBase{

	public Any(CronFieldBase field) {
		super(field);
	}

	@Override
	public List<Integer> getSchedules() {
		return IntStream.rangeClosed(this.field.getMinValue(), this.field.getMaxValue())
					.boxed().collect(Collectors.toList());
	}

}
