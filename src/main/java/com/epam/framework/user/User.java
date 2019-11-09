package com.epam.framework.user;

public class User {

    private String USER_NUMBER_OF_INSTANCES = "testdata.user.number.of.instances";
    private String NUMBER_OF_INSTANCES= TestDataReader
            .getTestData(USER_NUMBER_OF_INSTANCES);

    public String getNumberOfInstances() {
        return NUMBER_OF_INSTANCES;
    }
}
