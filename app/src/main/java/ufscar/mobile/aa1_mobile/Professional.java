package ufscar.mobile.aa1_mobile;

public class Professional {

    private String name;
    private String specialty;
    private int imageId;

    private int posicao;

    public Professional(String name, String specialty, int imageId, int posicao) {
        this.name = name;
        this.specialty = specialty;
        this.imageId = imageId;
        this.posicao = posicao;
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

    public  int getPosicao(){return posicao;}
}

