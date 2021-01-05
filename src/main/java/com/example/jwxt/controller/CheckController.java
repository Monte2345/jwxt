package com.example.jwxt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface CheckController {
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
