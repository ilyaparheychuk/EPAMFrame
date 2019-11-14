package com.epam.framework.user;

public class UserCreator {

    public static final String USER_NUMBER_OF_INSTANCES = "testdata.user.number.of.instances";
    public static final String USER_TYPE_INSTANCE_STANDARD = "testdata.user.type.instance.standard";
    public static final String USER_TYPE_OF_GPU_TESLA = "testdata.user.type.of.gpu.tesla";
    public static final String USER_LOCATION_DATACENTER = "testdata.user.location.datacenter";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(USER_NUMBER_OF_INSTANCES)
                , TestDataReader.getTestData(USER_TYPE_INSTANCE_STANDARD)
                , TestDataReader.getTestData(USER_TYPE_OF_GPU_TESLA)
                , TestDataReader.getTestData(USER_LOCATION_DATACENTER));
    }
}
