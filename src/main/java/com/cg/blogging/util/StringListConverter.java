package com.cg.blogging.util;

import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static java.util.Collections.*;

/**
 * 
 * <h1>String List Converter</h1>
 * <p>
 * This class allows conversion to insert data into database.
 * 
 * @author SKSSS
 *
 */
@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {
	private static final String SPLIT_CHAR = ";";

	/**
	 * To convert List of String elements into a String.
	 */
	@Override
	public String convertToDatabaseColumn(List<String> stringList) {
		return stringList != null ? String.join(SPLIT_CHAR, stringList) : "";
	}

	/**
	 * To convert String into a List of String elements.
	 */
	@Override
	public List<String> convertToEntityAttribute(String string) {
		return string != null ? Arrays.asList(string.split(SPLIT_CHAR)) : emptyList();
	}
}