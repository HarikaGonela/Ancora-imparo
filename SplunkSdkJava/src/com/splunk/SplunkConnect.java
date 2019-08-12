package com.splunk;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SplunkConnect {
    public static void main(String[] args) throws Exception {
        HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);

        // Section 1:  Splunk Connectivity
        Map<String, Object> connectionArgs = new HashMap<String, Object>();
        connectionArgs.put("host", "splunk url");

        connectionArgs.put("username", "username");
        connectionArgs.put("password", "password");
        connectionArgs.put("port", port);
        connectionArgs.put("scheme", "https");
        // will login and save the session key which gets put in the HTTP Authorization header
        Service splunkService = Service.connect(connectionArgs);

        Job job = splunkService.getJobs().create("search index=* *summaryrequest success | head 1");
        while (!job.isDone()) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                // e.printStackTrace();
                job.refresh();
            }

        }

        Args outputArgs = new Args();
        outputArgs.put("output_mode", "json");
        InputStream stream = job.getResults(outputArgs);

        //print search output to the console
        byte[] buffer = new byte[4096];

        String json = "";

        while (stream.read(buffer) != -1) {
            json = new String(buffer);
            //String output = new String(buffer.getBytes());

            System.out.println(json);


        }

/*
        BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF8"));
        StringBuilder sb = new StringBuilder();
        String line=null;
        while ((line=br.readLine()) != null) {
            System.out.println(line);
            //sb.append(line);
        }
//        System.out.println(sb.toString());
//        JSONObject jo = new JSONObject(sb.toString());
//        System.out.println(jo.get("results"));

   }
   //List<Byte> buffer = new ArrayList<Byte>();
        //InputStream is;
        //byte[] buffer = ByteStreams.toByteArray(is);

        */


    }

}



