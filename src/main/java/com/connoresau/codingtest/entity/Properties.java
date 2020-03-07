package com.connoresau.codingtest.entity;

import javax.persistence.*;

@Entity
@Table(name = "properties")
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "properties_id")
    private int propertiesId;

    @Column(name = "location_x")
    private int locationX;

    @Column(name = "location_y")
    private int locationY;

    @Column(name = "viewed_id")
    private String viewedId;

    @Column(name = "page_from")
    private String pageFrom;

    @Column(name = "page_to")
    private String pageTo;

    /**
     * Gets the properties id
     * @return the properties id
     */
    public int getPropertiesId() {
        return propertiesId;
    }

    /**
     * Sets the properties id
     * @param propertiesId The properties id
     */
    public void setPropertiesId(int propertiesId) {
        this.propertiesId = propertiesId;
    }

    /**
     * Gets the LocationX
     * @return The location x
     */
    public int getLocationX() {
        return locationX;
    }

    /**
     * Sets the locationX
     * @param locationX The location x
     */
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    /**
     * Gets the locationY
     * @return The location y
     */
    public int getLocationY() {
        return locationY;
    }

    /**
     * Sets the locationY
     * @param locactionY The location y
     */
    public void setLocationY(int locactionY) {
        this.locationY = locactionY;
    }

    /**
     * Gets the viewed id
     * @return The viewed id
     */
    public String getViewedId() {
        return viewedId;
    }

    /**
     * Sets the viewed id
     * @param viewedId The viewed id
     */
    public void setViewedId(String viewedId) {
        this.viewedId = viewedId;
    }

    /**
     * Gets the page from
     * @return The page from
     */
    public String getPageFrom() {
        return pageFrom;
    }

    /**
     * Sets the page from
     * @param pageFrom The page from
     */
    public void setPageFrom(String pageFrom) {
        this.pageFrom = pageFrom;
    }

    /**
     * Gets the page to
     * @return The page to
     */
    public String getPageTo() {
        return pageTo;
    }

    /**
     * Sets the page to
     * @param pageTo The page to
     */
    public void setPageTo(String pageTo) {
        this.pageTo = pageTo;
    }
}
