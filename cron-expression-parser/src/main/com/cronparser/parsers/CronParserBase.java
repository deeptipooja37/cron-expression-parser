package com.cronparser.parsers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.cronparser.cronfields.CronFieldBase;

public abstract class CronParserBase {

	protected static String EXACT="e";
	protected static String STEP="/";
	protected static String ANY="*";
	protected static String LIST=",";
	protected static String RANGE="-";
	
	protected CronFieldBase field;
	
	public CronParserBase(CronFieldBase field) {
		this.field = field;
	}
	protected static final Map<String, Class> parserMap = Map.ofEntries(
			Map.entry(ANY, Any.class),
			Map.entry(EXACT, Exact.class),
			Map.entry(STEP, Step.class),
			Map.entry(LIST, FieldList.class),
			Map.entry(RANGE, Range.class)
		); 
	
	public static CronParserBase getParser(CronFieldBase field) {
		String exp = null;
		if(field.getExpression().equals(ANY)) {
			exp = ANY;
		}else if(field.getExpression().matches("^[0-9]+$")){
			exp = EXACT;
		}else if(field.getExpression().matches(".*\\/.*")){
			exp = STEP;
		}else if(field.getExpression().matches(".*,.*")){
			exp = LIST;
		}else if(field.getExpression().matches("[0-9]+-[0-9]+")){
			exp = RANGE;
		}
		if(exp == null) {
			throw new RuntimeException("Invalid field expression "+field.getExpression());
		}
		
		CronParserBase parser =  null;
		try {
			 parser =  (CronParserBase) parserMap.get(exp).getConstructor(CronFieldBase.class).newInstance(field);

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		return parser;
	}
	public abstract List<Integer> getSchedules();
}
