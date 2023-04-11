package com.Basics.CustomException;

import java.io.IOException;

public class myException extends IOException {
    public myException() {
        System.out.println("this is a custom exception");
    }
}
