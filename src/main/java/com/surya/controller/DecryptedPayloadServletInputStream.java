package com.surya.controller;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptedPayloadServletInputStream extends ServletInputStream {

    private final InputStream decryptedInputStream;

    public DecryptedPayloadServletInputStream(InputStream decryptedInputStream) {
        this.decryptedInputStream = decryptedInputStream;
    }

    @Override
    public int read() throws IOException {
        return decryptedInputStream.read();
    }

    @Override
    public boolean isFinished() {
        // Implement if needed
        return false;
    }

    @Override
    public boolean isReady() {
        // Implement if needed
        return false;
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        // Implement if needed
    }
}

