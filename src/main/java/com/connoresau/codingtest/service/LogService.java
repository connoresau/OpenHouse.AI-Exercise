package com.connoresau.codingtest.service;

import com.connoresau.codingtest.dao.LogDAO;
import com.connoresau.codingtest.entity.Log;
import com.connoresau.codingtest.entity.SearchParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    private LogDAO logDAO;

    /**
     * Retrieves all logs from the LogDAO
     * @return All Logs
     */
    @Transactional
    public List<Log> getAll() {
        return logDAO.findAll();
    }

    /**
     * Retrieves logs from the LogDAO based on specific parameters
     * @param searchParameters The parameters to narrow the search
     * @return The logs that follow the specified parameters
     */
    @Transactional
    public List<Log> getSpecifics(SearchParameters searchParameters) {
        List<Log> logs = logDAO.findAll();

        List<Log> metCriteria = new ArrayList<>();

        for (Log log : logs) {

            //if userid is null, or it is not null and equals the user id of the log in the loop
            if (searchParameters.getUserId() == null || searchParameters.getUserId() != null &&
                    searchParameters.getUserId().equals(log.getUserId())) {

                // if the start time is either null or not null and before the save date of the log
                if (searchParameters.getStartTime() == null || searchParameters.getStartTime() != null &&
                        searchParameters.getStartTime().isBefore(log.getSaveDate())) {

                    // if the end time is either null or not null and after the save date of the log
                    if (searchParameters.getEndTime() == null || searchParameters.getEndTime() != null &&
                            searchParameters.getEndTime().isAfter(log.getSaveDate())) {

                        // if the log type is either null or not null and the same as the log
                        if (searchParameters.getLogType() == null || searchParameters.getLogType() != null &&
                                searchParameters.getLogType().equals(log.getLogType())) {

                            metCriteria.add(log);
                        }
                    }
                }
            }
    }

        return metCriteria;
}

    /**
     * Saves a log to the database using LogDAO
     * @param log The log to be saved
     * @return The log that was saved
     */
    @Transactional
    public Log save(Log log) {
        log.setSaveDate(LocalDateTime.now());
        return logDAO.save(log);
    }

    /**
     * Retrieves a log from the database using LogDAO
     * @param id The id of the log to be retrieved
     * @return The log that was retrieved
     */
    @Transactional
    public Optional<Log> get(int id) {
        return logDAO.findById(id);
    }

    /**
     * Deletes a log from the database using an id
     * @param id The id of the log to be deleted
     */
    @Transactional
    public void delete(int id) {
        logDAO.deleteById(id);
    }
}
