package com.verint.api.xml.writer;

import com.google.gson.Gson;
import com.verint.api.xml.dl.WebPlatform;
import com.verint.api.xml.dl.XmlFileTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;

/**
 * Created by obranopolsky on 17/06/2015.
 */

public class Generator {

    public static void main(String[] args) throws Exception {
        String filePath = "c:/1/out.txt";
        String data[] = {"1", "22", "333", "4444", "555"};

        Gson gson = new Gson();


        BufferedReader br = new BufferedReader(new FileReader("c:/1/data.json"));

        //convert the json string back to object
        WebPlatform paramsData = gson.fromJson(br, WebPlatform.class);
        System.out.println(paramsData.getUserIdentifier());
        System.out.println(paramsData.getTime());
        System.out.println(paramsData.getUserIdentifier());
        System.out.println(paramsData.getWebPlatforms());
        System.out.println(paramsData.getId());

        String outStr = String.format(XmlFileTemplate.REQ_WEBPLATFORM_TEMLATE, data[0], data[1], data[2], data[3], data[4]);
        RandomAccessFile outFile = new RandomAccessFile(filePath, "rw");
        outFile.writeBytes(outStr);
        outFile.close();

        System.out.print("===END==");
    }

}
