package com.luancomputacao.customtags;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class WebpackManifest extends SimpleTagSupport {
    private String staticDistPath;

    public void setStaticDistPath(String staticDistPath) {
        this.staticDistPath = staticDistPath;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (staticDistPath != null) {
            JSONParser jsonParser = new JSONParser();
            final JspWriter out = getJspContext().getOut();
            Object object = null;
            String webpackManifest = String.format("src/main/webapp%s/webpack.manifest.json", staticDistPath);
            try {
                object = jsonParser.parse(new FileReader("src/main/webapp/static/dist/webpack.manifest.json"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = (JSONObject) object;
            JSONArray assetsList = (JSONArray) jsonObject.get("main");


            String htmlOutput = "";
            Pattern patternCss = Pattern.compile(".*\\.css$");
            Pattern patternJs = Pattern.compile(".*\\.js$");
            String asset;


            for (String anAssetsList : (Iterable<String>) assetsList) {
                asset = anAssetsList;
                if (patternCss.matcher(asset).matches()) {
                    htmlOutput = String.format("<link rel=\"stylesheet\" href=\"%s/%s\" />", staticDistPath, asset);
                } else if (patternJs.matcher(asset).matches()) {
                    htmlOutput = String.format("<script src=\"%s/%s\" type=\"text/javascript\"></script>", staticDistPath, asset);
                } else {
                    htmlOutput = "";
                }
                out.println(htmlOutput);
            }
        }
    }
}
