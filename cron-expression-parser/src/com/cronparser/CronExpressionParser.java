package com.cronparser;

import java.util.List;
import java.util.stream.Collectors;

import com.cronparser.cronfields.Day;
import com.cronparser.cronfields.Hour;
import com.cronparser.cronfields.Minute;
import com.cronparser.cronfields.Months;
import com.cronparser.cronfields.Weekday;

public class CronExpressionParser {

	String expression;
	List minute;
	List hour;
	List day;
	List month;
	List weekday;
	String command;
	
	public CronExpressionParser(String expression) {
		this.expression = expression;
		this.parse();
	}
	
	private void parse() {
		String[] fields = this.expression.split("\\s+");
		if(fields.length != 6) {
			throw new RuntimeException("Invalid Expression: expression must contain 6 fields");
		}
		
		this.minute = new Minute(fields[0]).parse();
		this.hour = new Hour(fields[1]).parse();
		this.day = new Day(fields[2]).parse();
		this.month = new Months(fields[3]).parse();
		this.weekday = new Weekday(fields[4]).parse();
		this.command = fields[5];
	}

	public String toString() {
		StringBuilder displayTable = new StringBuilder();
		
		displayTable.append(String.format("minute        %s", this.minute.stream().map(i -> i.toString()).collect(
			      Collectors.joining(" "))));
		displayTable.append(System.getProperty("line.separator"));
		
		displayTable.append(String.format("hour          %s", this.hour.stream().map(i -> i.toString()).collect(
			      Collectors.joining(" "))));
		displayTable.append(System.getProperty("line.separator"));
		
		displayTable.append(String.format("day of month  %s", this.day.stream().map(i -> i.toString()).collect(
			      Collectors.joining(" "))));
		displayTable.append(System.getProperty("line.separator"));
		
		displayTable.append(String.format("month         %s", this.month.stream().map(i -> i.toString()).collect(
			      Collectors.joining(" "))));
		displayTable.append(System.getProperty("line.separator"));
		
		displayTable.append(String.format("day of week   %s", this.weekday.stream().map(i -> i.toString()).collect(
			      Collectors.joining(" "))));
		displayTable.append(System.getProperty("line.separator"));
		
		displayTable.append(String.format("command       %s", this.command));
		return displayTable.toString();
	}

	public static void main(String[] args) {

		if(args.length != 1) {
			throw new RuntimeException("One parameter should be passed");
		}
		String exp = args[0];
		CronExpressionParser parser = new CronExpressionParser(exp);
		System.out.print(parser.toString());
	}

}
