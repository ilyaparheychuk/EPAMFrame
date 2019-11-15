package com.epam.framework.user;

public class User {

    private String NumberOfInstances;
    private String TypeInstanceStandard;
    private String TypeOfGpuTesla;
    private String IDLocationDatacenter;

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
        return TypeInstanceStandard;
    }

    public String getTypeOfGpuTesla() {
        return TypeOfGpuTesla;
    }

    public String getIDLocationDatacenter() {
        return IDLocationDatacenter;
    }
}
