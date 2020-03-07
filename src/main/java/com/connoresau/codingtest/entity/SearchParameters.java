package com.connoresau.codingtest.entity;

import java.time.LocalDateTime;

public class SearchParameters {
    private String userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String logType;

    /**
     * Retrieves the user id in the search parameters
     * @return The user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user id in the search parameters
     * @param userId The user id to be set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the start time in the search parameters
     * @return The start time to be retrieved
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time in the search parameters
     * @param startTime Sets the start time
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Retrieves the end time in the search parameters
     * @return The end time to be retrieved
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time in the search parameters
     * @param endTime The end time to be set
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Retrieves the Log Type in the search parameters
     * @return The log type to be retrieved
     */
    public String getLogType() {
        return logType;
    }

    /**
     * Sets the log type in the search parameters
     * @param logType The log type to be set
     */
    public void setLogType(String logType) {
        this.logType = logType;
    }
}
