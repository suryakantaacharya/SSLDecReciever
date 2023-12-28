package com.surya.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;

import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DecryptingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            // Read the encrypted payload from the request body
            InputStream encryptedInputStream = request.getInputStream();
            byte[] encryptedPayload = StreamUtils.copyToByteArray(encryptedInputStream);
            System.out.println(new String(encryptedPayload));

            // Decrypt the payload
            byte decryptedPayload[] = CryptoUtils.decrypt(encryptedPayload);

            System.out.println(new String(decryptedPayload));

            // Replace the request input stream with a new stream containing the decrypted payload
            InputStream decryptedInputStream = new ByteArrayInputStream(decryptedPayload);
            request = new DecryptedPayloadHttpServletRequest(request, decryptedInputStream);

            // Set the Content-Type header to indicate that the payload is JSON
            request.setAttribute("Content-Type", "application/json");

            // Continue with the filter chain
            filterChain.doFilter(request, response);

        } catch (Exception e) {
            // Handle decryption failure
            response.setStatus(jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Error decrypting payload");
        }
    }
}

