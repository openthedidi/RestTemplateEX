package com.example.bank.coindeskAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import com.alibaba.fastjson.JSON;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;

@Component
public class RestTemplateUtil {
    /**
     * 解決no suitable HttpMessageConverter found for response type的問題
     * */
    public static RestTemplate getInstance(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new Json2HttpMessageConverter());
        return restTemplate;
    }

}

class Json2HttpMessageConverter extends AbstractHttpMessageConverter {


    public Json2HttpMessageConverter(){
        super(new MediaType("application","javascript"));
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream body = inputMessage.getBody();
        return JSON.parseObject(body,clazz);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }

    @Override
    protected boolean supports(Class clazz) {
        return true;
    }
}
