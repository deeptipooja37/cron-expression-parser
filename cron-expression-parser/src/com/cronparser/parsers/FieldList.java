package com.cronparser.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.cronparser.cronfields.CronFieldBase;

public class FieldList  extends CronParserBase{

	// Considering List contains comma separated integers only not range
	public FieldList(CronFieldBase field) {
		super(field);
	}

	@Override
	public List<Integer> getSchedules() {
		String[] values = this.field.getExpression().split(",");
		Set<String> set = new HashSet<String>(List.of(values));
		List<Integer> list = set.stream()
				.map(num -> Integer.valueOf(num))
				.sorted()
				.collect(Collectors.toList());
				
		return list;
	}

}
