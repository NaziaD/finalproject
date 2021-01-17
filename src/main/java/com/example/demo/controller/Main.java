package com.example.demo.controller;
import com.example.demo.models.covid;
import com.example.demo.models.covidrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class Main {

    @Autowired
    com.example.demo.models.covidrepo covidrepo;

    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public ModelAndView chart(){
        ModelAndView mv = new ModelAndView("chart");

        ChartData chartDataObject = new ChartData();
        List<List<Map<Object, Object>>> ChartDataList =chartDataObject.getChartDataList();
        mv.addObject("datalist", ChartDataList);
        return mv;
    }

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("covidstats", covidrepo.findAll());
        return mv;
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("covidstats", covidrepo.findAll());
        return mv;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(@RequestParam("state") String state, @RequestParam("date") Date date){
        ModelAndView mv = new ModelAndView("redirect:/home");

        String json1 = getStats(state, date);
        try {
            JSONObject json = new JSONObject(json1);
            mv.addObject("state", json.getString("state"));
            mv.addObject("date", json.getString("date"));
            mv.addObject("cases", json.getString("positive"));
            mv.addObject("deaths", json.getString("death"));
            mv.addObject("newcases", json.getString("increasedby"));
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        mv.addObject("covidstats", covidrepo.findAll());
        return mv;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("id") String id, @RequestParam("state") String state, @RequestParam("date") String date, @RequestParam("positive") String positive, @RequestParam("death") String death, @RequestParam("increasedby") String increasedby){
        ModelAndView mv = new ModelAndView("redirect:/home");
        covid db;
        if(!id.isEmpty()){
            Optional<covid> users = covidrepo.findById(id);
            db = users.get();
        }
        else {
            db = new covid();
            db.setId(UUID.randomUUID().toString());
        }
        db.setState(state);
        db.setDate(date);
        db.setPositive(positive);
        db.setDeath(death);
        db.setIncreasedby(increasedby);
        covidrepo.save(db);
        mv.addObject("covidstats", covidrepo.findAll());
        return mv;
    }
    private String getStats(String state, Date date){
        SimpleDateFormat date1 = new SimpleDateFormat("yyyyMMdd");
        String date2 = date1.format(date);

        try{
            URL getrequesturl = new URL("https://api.covidtracking.com/v1/states/" + state + "/" + date2 + ".json");
            HttpURLConnection connect = (HttpURLConnection) getrequesturl.openConnection();
            connect.setRequestMethod("GET");
            if (connect.getResponseCode() == HttpURLConnection.HTTP_OK){
                BufferedReader br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                StringBuilder response = new StringBuilder();
                String message;
                while ((message = br.readLine()) != null){
                    response.append(message);
                }
                br.close();
                return response.toString();
            } else {
                return "Unexpected response";
            }
        } catch (Exception exception) {
            return "Exception: " + exception.getMessage();
        }
    }
}
