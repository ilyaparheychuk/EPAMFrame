package com.epam.framework.user;

public class User {

    private String NumberOfInstances;
    private String TypeInstanceStandard;
    private String TypeOfGpuTesla;
    private String IDLocationDatacenter;

    private final String xpathTypeInstanceStandard = "//*[contains(text(),'%s')]";
    private final String xpathTypeOfGpuTesla = ".//md-option[@value='%s']";
    private final String xpathLocationDatacenter = "(//*[contains(text(),'%s')])[4]";

    public User(String NumberOfInstances, String TypeInstanceStandard,
                String TypeOfGpuTesla, String LocationDatacenter) {

        this.NumberOfInstances = NumberOfInstances;
        this.TypeInstanceStandard = TypeInstanceStandard;
        this.TypeOfGpuTesla = TypeOfGpuTesla;
        this.IDLocationDatacenter = LocationDatacenter;
    }

    public String getNumberOfInstances() {
        return NumberOfInstances;
    }

    public String getTypeInstanceStandard() {
        return String.format(xpathTypeInstanceStandard, TypeInstanceStandard);
    }

    public String getTypeOfGpuTesla() {
        return String.format(xpathTypeOfGpuTesla, TypeOfGpuTesla);
    }

    public String getIDLocationDatacenter() {
        return String.format(xpathLocationDatacenter, IDLocationDatacenter);
    }
}
