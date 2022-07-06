package com.qisstpay.utalities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class DataUtalities {

    //Read loginjson file and get admin related data
    @DataProvider
    public Object[] adminCredentials() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        // Read JSON file and after parsing store in java object
        //java object
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(".\\TestData\\logindata.json"));
            //Parse java object to json object
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }
        jsonObject = (JSONObject) obj;

        // Extract array data from JSONObject
        assert jsonObject != null;
        JSONArray adminInfo = (JSONArray) jsonObject.get("admin");
        // String array to store JSONArray data
        String[] dataArray = new String[adminInfo.size()];

        // JSONObject to read each JSONArray object
        JSONObject formInfoData;
        String _email, _password, _role, _machineReadableName;

        // Get data from JSONArray and store it in String array
        for (int i = 0; i < adminInfo.size(); i++) {
            formInfoData = (JSONObject) adminInfo.get(i);
            _email = (String) formInfoData.get("email");
            _password = (String) formInfoData.get("password");


            dataArray[i] = _email + "," + _password;
        }
        return dataArray;
    }

}