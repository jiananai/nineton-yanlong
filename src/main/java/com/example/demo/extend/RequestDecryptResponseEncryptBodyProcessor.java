package com.example.demo.extend;

import com.example.demo.utils.AesUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author sdcuike
 * <p>
 * Created At 2016年10月26日 下午11:59:07
 */
public class RequestDecryptResponseEncryptBodyProcessor {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    public final String decryptRequestBody(HttpInputMessage inputMessage, Charset charset) throws IOException {
        InputStream inputStream = inputMessage.getBody();
        String input = IOUtils.toString(inputStream, charset);
        HttpHeaders httpHeaders = inputMessage.getHeaders();
        return doDecryptRequestBody(input, httpHeaders, charset);
    }

    public final String encryptResponseBody(String input, HttpHeaders httpHeaders, Charset charset) {
        //System.out.println(input);
        return doEncryptResponseBody(input, httpHeaders, charset);
    }

    protected String doDecryptRequestBody(String input, HttpHeaders httpHeaders, Charset charset) {
        //System.out.println(input+"|||");
        //Map<String,String> map = JsonUtils.jsonToPojo(input, Map.class);
        //String decrypt = AesUtils.decrypt(input, "youllikefollower", "likethisverymuch");
        //System.out.println(decrypt);
        return input;
    }

    protected String doEncryptResponseBody(String input, HttpHeaders httpHeaders, Charset charset) {
        String encrypt = AesUtils.encrypt(input, "youllikefollower", "likethisverymuch");
        return encrypt;
    }

}
