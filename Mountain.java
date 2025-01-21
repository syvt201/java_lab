public class Mountain {
    private String mountainCode;
    private String mountain;
    private String province;
    private String description;

    // Constructor
    public Mountain() {
        this.mountainCode = "";
        this.mountain = "";
        this.province = "";
        this.description = "";
    }

    public Mountain(String mountainCode, String mountain, String province, String description) {
        this.mountainCode = mountainCode;
        this.mountain = mountain;
        this.province = province;
        this.description = description;
    }

    // Getters and Setters
    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public String getMountain() {
        return mountain;
    }

    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() { 
        return String.format("Mountain[mountainCode=%s, mountain=%s, province=%s, description=%s]", mountainCode, mountain, province, description); 
    }
}