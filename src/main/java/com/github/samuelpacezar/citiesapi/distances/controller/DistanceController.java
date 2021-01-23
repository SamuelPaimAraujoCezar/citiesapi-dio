package com.github.samuelpacezar.citiesapi.distances.controller;

import com.github.samuelpacezar.citiesapi.distances.service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceController {

    @Autowired
    private DistanceService distanceService;

    Logger log = LoggerFactory.getLogger(DistanceController.class);

    @GetMapping()
    public ResponseEntity distances(@RequestParam(name = "from") final Long city1,
                                    @RequestParam(name = "to") final Long city2) {
        log.info("Kilometers");
        return ResponseEntity.ok().body(distanceService.distanceInKilometers(city1, city2));
    }

    @GetMapping("/by-points")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return ResponseEntity.ok().body(distanceService.distanceByPointsInMiles(city1, city2));
    }

    @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return ResponseEntity.ok().body(distanceService.distanceByCubeInMeters(city1, city2));
    }

}
