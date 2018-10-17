package com.luancomputacao.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PrintSafe extends SimpleTagSupport {
    private String json;

    public void setJson(String jsonString) {
        this.json = jsonString;
    }

    @Override
    public void doTag() throws JspException, IOException {
        final JspWriter out = getJspContext().getOut();
        if (json != null) {
            String s = json.replaceAll("\"", "&quot;");
            out.print(s);
        }
    }
}