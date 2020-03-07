package com.connoresau.codingtest.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private int logId;

    @NotNull
    @Column(name = "user_id")
    private String userId;

    @NotNull
    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "save_date")
    private LocalDateTime saveDate;

    @Column(name = "log_type")
    private String logType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "log")
    private List<Action> actions;

    /**
     * Gets the log id
     * @return The log id
     */
    public int getLogId() {
        return logId;
    }

    /**
     * Sets the log id
     * @param logId The log id
     */
    public void setLogId(int logId) {
        this.logId = logId;
    }

    /**
     * Gets the save date
     * @return The save date
     */
    public LocalDateTime getSaveDate() {
        return saveDate;
    }

    /**
     * Sets the save date
     * @param saveDate The save date
     */
    public void setSaveDate(LocalDateTime saveDate) {
        this.saveDate = saveDate;
    }

    /**
     * Gets the list of actions
     * @return The list of actions
     */
    public List<Action> getActions() {
        return actions;
    }

    /**
     * Sets the list of actions
     * @param actions The list of actions
     */
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    /**
     * Gets the user id
     * @return The user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user id
     * @param userId The user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the session id
     * @return The session id
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the session id
     * @param sessionId The session id
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * Gets the log type
     * @return The log type
     */
    public String getLogType() {
        return logType;
    }

    /**
     * Sets the log type
     * @param logType The log type
     */
    public void setLogType(String logType) {
        this.logType = logType;
    }
}
