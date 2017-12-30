package yi.igemer;

/**
 * Created by yimo on 2017-12-30.
 */

public class Team {
    private int teamID;
    private String logo;
    private String description;
    private String name;
    private String school;
    private String wiki;
    private String region;
    private String country;
    private String track;
    private String kind;
    private String application;
    private String serial;
    private String attend;
    private String createdAt;

    public Team(){

    }

    public Team(int teamID, String logo, String description, String name, String school, String wiki, String region, String country,
                String track, String kind, String application, String serial, String attend, String createdAt){
        this.teamID = teamID;
        this.logo=logo;
        this.description=description;
        this.name = name;
        this.name = school;
        this.name = wiki;
        this.name = region;
        this.name = country;
        this.name = track;
        this.name = kind;
        this.name = application;
        this.name = serial;
        this.name = attend;
        this.name = createdAt;
    }


    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
