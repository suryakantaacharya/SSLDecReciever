package com.surya.controller;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptedPayloadHttpServletRequest extends HttpServletRequestWrapper {

    private final InputStream decryptedInputStream;

    public DecryptedPayloadHttpServletRequest(HttpServletRequest request, InputStream decryptedInputStream) {
        super(request);
        this.decryptedInputStream = decryptedInputStream;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new DecryptedPayloadServletInputStream(decryptedInputStream);
    }
}

