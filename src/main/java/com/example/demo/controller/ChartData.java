package com.example.demo.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartData {

    static Map<Object,Object> map = null;
    static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
    static List<Map<Object,Object>> data = new ArrayList<Map<Object,Object>>();

    static {
        //data is coded to show chart is working
        double mdCases = 856479.0;
        double caCases = 1421457.0;
        double nyCases = 1986557.0;
        double txCases = 1258923.0;
        double wiCases = 987561.0;
        double flCases = 985213.0;

        map = new HashMap<Object,Object>(); map.put("label", "Maryland"); map.put("y", mdCases);data.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "California"); map.put("y", caCases);data.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "New York"); map.put("y", nyCases);data.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "Texas"); map.put("y", txCases);data.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "Wisconsin"); map.put("y", wiCases);data.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "Florida"); map.put("y", flCases);data.add(map);

        list.add(data);
    }

    public static List<List<Map<Object, Object>>> getChartDataList() {
        return list;
    }
}
