package com.pegasus.arithmetic.expression.jsptags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;

public class CustomJSPTags extends SimpleTagSupport {
	StringWriter sw = new StringWriter();

	public void doTag() throws JspException, IOException {
		getJspBody().invoke(sw);
		JspWriter out = getJspContext().getOut();
		String outputText = "Arithmetic Expressions";
		String bodyContentText = sw.toString();
		if (StringUtils.equalsIgnoreCase(bodyContentText, "heading1")) {
			outputText = "Arithmetic Expressions";
		} else if (StringUtils.equalsIgnoreCase(bodyContentText, "heading2")) {
			outputText = "Arithmetic Expressions SEPL";
		} else if (StringUtils.equalsIgnoreCase(bodyContentText, "heading3")) {
			outputText = "Arithmetic Expression History";
		}
		out.println(outputText);
	}
}