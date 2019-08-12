package com.splunk;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ExportSearch
{
    public static void main(String[] args) throws Exception {
        HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);

        // Section 1:  Splunk Connectivity
        Map<String, Object> connectionArgs = new HashMap<String, Object>();
        connectionArgs.put("host", "splunk url");

        connectionArgs.put("username", "username");
        connectionArgs.put("password", "password$");
        connectionArgs.put("port", port);
        connectionArgs.put("scheme", "https");
        // will login and save the session key which gets put in the HTTP Authorization header
        Service splunkService = Service.connect(connectionArgs);

        // Set up a real-time export with a 30-second window
        JobExportArgs exportArgs = new JobExportArgs();
        exportArgs.setSearchMode(JobExportArgs.SearchMode.NORMAL);
        //exportArgs.setEarliestTime("rt-30s");
        //exportArgs.setLatestTime("rt");
        //exportArgs.setOutputMode(JobExportArgs.OutputMode.XML);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a search string then press <ENTER>: ");
        String mySearch = br.readLine();

        if(!(mySearch.trim().startsWith("|")) && !(mySearch.substring(0, 6).equalsIgnoreCase("search"))) {
            mySearch = "search " + mySearch;
        }
        InputStream exportSearch = splunkService.export(mySearch, exportArgs);
        MultiResultsReaderXml resultsReader = new MultiResultsReaderXml(exportSearch);

        long counter = 0;
        for(SearchResults searchResults : resultsReader)
        {
            System.out.println("Result set " + counter++ + " ********");
            int counterEvent = 0;  // count the number of events in each set
            for (Event event : searchResults) {
                System.out.println("Event " + counterEvent++ + " --------");
                for (String key: event.keySet())
                    System.out.println("   " + key + ":  " + event.get(key));
            }
        }
        resultsReader.close();



    }
}
