package com.futuristlabs.task;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameOfLifeTest {
	
	@Test
    public void postArrayAndGenerationsJson1() throws IOException {
        String inputFile = this.getClass().getResource("/testArray1.json").getFile();
        String expected = "[[0,0,0,0,0],[0,0,0,0,0],[0,1,1,1,0],[0,0,0,0,0],[0,0,0,0,0]]";
        File input = new File(inputFile);
        PostMethod post = new PostMethod("http://localhost:8080/gameOfLife");
        post.addRequestHeader("Accept", "application/json");
        RequestEntity entity = new FileRequestEntity(input, "application/json; charset=ISO-8859-1");
        post.setRequestEntity(entity);
        HttpClient httpclient = new HttpClient();
        String result = "";

        try {
            httpclient.executeMethod(post);
            result = post.getResponseBodyAsString();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            // Release current connection to the connection pool once you are
            // done
            post.releaseConnection();
        }
        assertTrue(result.equals(expected));

    }
	
	@Test
    public void postArrayAndGenerationsJson2() throws IOException {
        String inputFile = this.getClass().getResource("/testArray2.json").getFile();
        String expected = "[[0,0,0,0,0],[0,0,1,0,0],[0,0,1,0,0],[0,0,1,0,0],[0,0,0,0,0]]";
        File input = new File(inputFile);
        PostMethod post = new PostMethod("http://localhost:8080/gameOfLife");
        post.addRequestHeader("Accept", "application/json");
        RequestEntity entity = new FileRequestEntity(input, "application/json; charset=ISO-8859-1");
        post.setRequestEntity(entity);
        HttpClient httpclient = new HttpClient();
        String result = "";

        try {
            httpclient.executeMethod(post);
            result = post.getResponseBodyAsString();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            // Release current connection to the connection pool once you are
            // done
            post.releaseConnection();
        }
        assertTrue(result.equals(expected));

    }

}
