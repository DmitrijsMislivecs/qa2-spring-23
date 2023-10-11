package model;

import java.math.BigDecimal;
import java.util.Date;

public class Planet {
    private String name;
    private String inhabited;
    private Boolean livable;
    private float oxygenContent;
    private Boolean presenceOfWater;
    private BigDecimal population;
    private Date dateOfRegistration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInhabited() {
        return inhabited;
    }

    public void setInhabited(String inhabited) {
        this.inhabited = inhabited;
    }

    public Boolean getLivable() {
        return livable;
    }

    public void setLivable(Boolean livable) {
        this.livable = livable;
    }

    public float getOxygenContent() {
        return oxygenContent;
    }

    public void setOxygenContent(float oxygenContent) {
        this.oxygenContent = oxygenContent;
    }

    public Boolean getPresenceOfWater() {
        return presenceOfWater;
    }

    public void setPresenceOfWater(Boolean presenceOfWater) {
        this.presenceOfWater = presenceOfWater;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    public void setPopulation(BigDecimal population) {
        this.population = population;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
