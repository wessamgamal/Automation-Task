package com.cc.utils;

import org.json.JSONObject;

import java.io.*;

import org.json.JSONTokener;

public class JsonReader {

    LoggerManager utils = new LoggerManager();

    public JSONObject readJson(String fileName) throws IOException {

        InputStream is = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "testData" + File.separator+fileName+".json");
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + fileName);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject jsonObject = new JSONObject(tokener);

        return jsonObject;

    }
    public String getValue(String file,String key) {
        JSONObject jo = null;
        try {
            jo = readJson(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jo.getJSONObject(key).getString(new GlobalParams().getLanguage());
    }
}
