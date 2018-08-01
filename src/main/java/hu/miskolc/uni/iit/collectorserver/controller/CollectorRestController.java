package hu.miskolc.uni.iit.collectorserver.controller;

import hu.miskolc.uni.iit.collectorserver.DTO.MeasurementDTO;
import hu.miskolc.uni.iit.collectorserver.service.CollectorService;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CollectorRestController {
    @Autowired
    CollectorService collectorService;


    @RequestMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.POST})
    @ResponseBody
    public String sfd(@RequestBody final MeasurementDTO measurementRequest) {

        this.collectorService.storeAll(measurementRequest);
        return "{\"Succes\":1}";
    }

    @RequestMapping(value = "/listAll")
    @ResponseBody
    public String listAllConsole() {
        final List<MeasuringDevice> all;
        all = this.collectorService.listAll();
        System.out.println(all);
        return all.toString();
    }

}
