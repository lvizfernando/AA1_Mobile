package ufscar.mobile.aa1_mobile.service;

import com.google.gson.annotations.SerializedName;

public class Profissional {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("speciality")
    private String speciality;
    @SerializedName("imageId")
    private String imageId;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getImageId() {
        return imageId;
    }

    @Override
    public String toString() {
        return "Profissional{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }
}
