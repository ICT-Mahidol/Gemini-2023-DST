package com.example.demo;

import edu.gemini.app.ocs.OCS;

public class ocs {
    private static OCS instance = new OCS();

    public static OCS getInstance() {
        return instance;
    }
}