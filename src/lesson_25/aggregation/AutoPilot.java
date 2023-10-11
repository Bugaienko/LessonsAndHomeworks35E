package lesson_25.aggregation;
/*
@date 10.10.2023
@author Sergey Bugaienko
*/

public class AutoPilot {
    private String softwareVersion;



    public AutoPilot(String softwareVersion) {
        this.softwareVersion = softwareVersion;

    }

    public String toString() {
        return "{AP: version: " + softwareVersion +"}";
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }


}
