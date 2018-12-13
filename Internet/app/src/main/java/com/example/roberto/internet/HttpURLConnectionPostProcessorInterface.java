package com.example.roberto.internet;

public interface HttpURLConnectionPostProcessorInterface {
    void successHandler(String dataInXML);
    void failureHandler(Exception exception);
}
