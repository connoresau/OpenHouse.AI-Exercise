package com.connoresau.codingtest.restcontroller;

import com.connoresau.codingtest.entity.Action;
import com.connoresau.codingtest.entity.Log;
import com.connoresau.codingtest.entity.SearchParameters;
import com.connoresau.codingtest.exception.LogNotFoundException;
import com.connoresau.codingtest.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logs")
public class LogRestController {

    @Autowired
    private LogService logService;

    /**
     * The REST Get Mapping to retrieve all the logs
     * @return A list of all logs that were retrieved
     */
    @GetMapping
    public List<Log> getLogs() {
        return logService.getAll();
    }

    /**
     * The REST Get Mapping to retrieve a single log using its id
     * @param logId The id of the log to be retrieved
     * @return The log that was retrieved
     */
    @GetMapping("/{logId}")
    public Optional<Log> getLog(@PathVariable int logId) {
        Optional<Log> log =  logService.get(logId);

        if (!log.isPresent()) {
            throw new LogNotFoundException();
        }

        return log;
    }

    /**
     * The REST Get Mapping to find all the logs that match certain parameters.
     * Those parameters can be userId, a range of time that the log was saved, and log type
     * @param searchParameters The parameters to be used in the search
     * @return The list of all the logs that were retrieved
     */
    @GetMapping("/search")
    public List<Log> getSpecificLogs(@RequestBody SearchParameters searchParameters) {
        return logService.getSpecifics(searchParameters);
    }

    /**
     * The REST Post mapping to add a log to the database
     * @param log The log to be added to the database
     * @return The log that was added to the database
     */
    @PostMapping
    public Log addLog(@RequestBody Log log) {
        log.setLogId(0);

        for (Action action : log.getActions()) {
            action.setActionId(0);
            action.getProperties().setPropertiesId(0);
        }

        return logService.save(log);
    }

    /**
     * The REST Put mapping to update a log in the database
     * @param log The log to be updated
     * @return The log that was updated
     */
    @PutMapping
    public Log updateLog(@RequestBody Log log) {

        //if the log id does not exist, throw an exception
        if (!logService.get(log.getLogId()).isPresent()) {
            throw new LogNotFoundException();
        }

        return logService.save(log);
    }

    /**
     * The REST Delete Mapping to delete a log in the database
     * @param id The id of the log to be deleted
     * @return A String telling the user the id of the log that was deleted
     */
    @DeleteMapping("/{id}")
    public String deleteLog(@PathVariable int id) {
        Optional<Log> log = logService.get(id);

        if (!log.isPresent()) {
            throw new LogNotFoundException();
        }

        logService.delete(id);
        return ("Deleted Log id - " + id);
    }

}
