package model;

public class Project {
    private String name;
    private String goal;
    private int numberOfParticipants;
    private String manager;
    private String responsibleForFireSafety;
    private String scapegoat;
    private String emergencyNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getResponsibleForFireSafety() {
        return responsibleForFireSafety;
    }

    public void setResponsibleForFireSafety(String responsibleForFireSafety) {
        this.responsibleForFireSafety = responsibleForFireSafety;
    }

    public String getScapegoat() {
        return scapegoat;
    }

    public void setScapegoat(String scapegoat) {
        this.scapegoat = scapegoat;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

}
