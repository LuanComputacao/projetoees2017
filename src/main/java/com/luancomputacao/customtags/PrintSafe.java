package com.luancomputacao.customtags;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class PrintSafe extends SimpleTagSupport {
    private String jsonString;

    public void setStaticDistPath(String jsonString) {
        this.jsonString = jsonString;
    }

    @Override
    public void doTag() throws JspException, IOException {
        final JspWriter out = getJspContext().getOut();
        String htmlOutput = "lalala";
        if (jsonString != null) {
            out.println(htmlOutput);
        }
    }
}