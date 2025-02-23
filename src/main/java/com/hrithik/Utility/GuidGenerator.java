package com.hrithik.Utility;

import java.util.UUID;

public class GuidGenerator {

    public static String getGuid(){
        return UUID.randomUUID().toString();
    }
}
