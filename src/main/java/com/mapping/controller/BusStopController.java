package com.mapping.controller;

import com.mapping.entity.Bus;
import com.mapping.entity.BusStop;
import com.mapping.entity.Stop;
import com.mapping.repository.BusRepository;
import com.mapping.repository.BusStopRepository;
import com.mapping.repository.StopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bus")
public class BusStopController {
    private BusRepository busRepository;
    private StopRepository stopRepository;
    public BusStopRepository busStopRepository;
    public BusStopController(BusRepository busRepository,
                             StopRepository stopRepository,
                             BusStopRepository busStopRepository){
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
        this.busStopRepository = busStopRepository;
    }
    @PostMapping
    public ResponseEntity<BusStop> allocateBusRoute(
            @RequestParam long busId,
            @RequestParam long stopId,
            @RequestBody BusStop busStop){
        Bus bus = busRepository.findById(busId).get();
        Stop stop = stopRepository.findById(stopId).get();

        busStop.setBus(bus);
        busStop.setStop(stop);
        BusStop savedEntity = busStopRepository.save(busStop);

        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

}
