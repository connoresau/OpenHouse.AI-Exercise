package com.connoresau.codingtest.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "action")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id")
    private int actionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "log_id")
    private Log log;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "properties_id")
    private Properties properties;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "type")
    private String type;

    /**
     * Gets the action id
     * @return The action id
     */
    public int getActionId() {
        return actionId;
    }

    /**
     * Sets the action id
     * @param actionId The action id
     */
    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    /**
     * Gets the action's log
     * @return The action's log
     */
    public Log getLog() {
        return log;
    }

    /**
     * Sets the action's log
     * @param log The action's log
     */
    public void setLog(Log log) {
        this.log = log;
    }

    /**
     * Gets the action's properties
     * @return The action's properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets the action's properties
     * @param properties The action's properties
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * Gets the action's time
     * @return The action's time
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Sets the action's time
     * @param time The action's time
     */
    public void setTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        this.time = LocalDateTime.parse(time, formatter);
    }

    /**
     * Gets the action's type
     * @return The action's type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the action's type
     * @param type The action's type
     */
    public void setType(String type) {
        this.type = type;
    }
}
