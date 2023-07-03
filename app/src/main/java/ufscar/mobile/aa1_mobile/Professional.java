package ufscar.mobile.aa1_mobile;

public class Professional {

    private String name;
    private String specialty;
    private int imageId;

    public Professional(String name, String specialty, int imageId) {
        this.name = name;
        this.specialty = specialty;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getImageId() {
        return imageId;
    }
}

