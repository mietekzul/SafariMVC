package pl.raziel.mvc.data.entities;

import org.hibernate.validator.constraints.NotBlank;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "project")
public class Project {
    private Long projectId;
    private String name;
    @NotBlank(message = "You must provide description.")
    private String description;
    private Sponsor sponsor;
    private BigDecimal authorizedHours;
    private BigDecimal authorizedFunds;
    private String year;
    private boolean special;
    private String type;
    private List<String> pointsOfContact;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Spring MVC Databinding in Action");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public BigDecimal getAuthorizedHours() {
        return authorizedHours;
    }

    public void setAuthorizedHours(BigDecimal authorizedHours) {
        this.authorizedHours = authorizedHours;
    }

    public BigDecimal getAuthorizedFunds() {
        return authorizedFunds;
    }

    public void setAuthorizedFunds(BigDecimal authorizedFunds) {
        this.authorizedFunds = authorizedFunds;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getPointsOfContact() {
        return pointsOfContact;
    }

    public void setPointsOfContact(List<String> pointsOfContact) {
        this.pointsOfContact = pointsOfContact;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Project{");
        sb.append("projectId=").append(projectId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", sponsor=").append(sponsor);
        sb.append(", authorizedHours=").append(authorizedHours);
        sb.append(", authorizedFunds=").append(authorizedFunds);
        sb.append(", year='").append(year).append('\'');
        sb.append(", special=").append(special);
        sb.append(", type='").append(type).append('\'');
        sb.append(", pointsOfContact=").append(pointsOfContact);
        sb.append('}');
        return sb.toString();
    }
}
