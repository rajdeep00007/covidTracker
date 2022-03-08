package com.febproject.covidtracker.controllers;

import com.febproject.covidtracker.models.LocationStats;
import com.febproject.covidtracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller                                            // It's the way to get any page to show up any access URL is by creating controller
public class HomeController2 implements ErrorController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        System.out.println(allStats);
        int totalReportedCases = allStats.stream().mapToInt(stat-> Integer.parseInt(stat.getLatestTotalCases())).sum();
        int totalNewCases = allStats.stream().mapToInt(LocationStats::getDiffFromPrevDay).sum();
        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalReportedCases);

        return "home";
    }
}
