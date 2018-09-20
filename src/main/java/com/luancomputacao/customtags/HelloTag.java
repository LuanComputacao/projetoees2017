package com.luancomputacao.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class HelloTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        final JspWriter out = getJspContext().getOut();
        String message = System.getProperty("catalina.base");
        out.println(message);
    }
}
