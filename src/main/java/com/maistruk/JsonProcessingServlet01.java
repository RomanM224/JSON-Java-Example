package com.maistruk;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JsonProcessingServlet01
 */
public class JsonProcessingServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter printWriter = response.getWriter();
	    printWriter.println("<html>");
	    printWriter.println("<head><title>JAVA API for JSON Processing - Tutorial 01</title></head>");
	    printWriter.println("<body>");
	    handleParsing(request.getParameter("jsonData"));
	    printWriter.println("see server log console...");
	    printWriter.println("</body>");
	    printWriter.println("<html>");
	}

    private void handleParsing(String JsonData) {
        JsonParser jsonParser = Json.createParser(new StringReader(JsonData));
            while(jsonParser.hasNext()) {
                if(jsonParser.next().equals("START_OBJECT")) {
                    System.out.println("START_OBJECT");
                }
                if(jsonParser.next().equals("END_OBJECT")) {
                    System.out.println("END_OBJECT");
                }
                if(jsonParser.next().equals("START_ARRAY")) {
                    System.out.println("START_ARRAY");
                }
                if(jsonParser.next().equals("END_ARRAY")) {
                    System.out.println("END_ARRAY");
                }
                if(jsonParser.next().equals("KEY_NAME")) {
                    System.out.println("KEY_NAME: " + jsonParser.getString());
                }
                if(jsonParser.next().equals("VALUE_STRING")) {
                    System.out.println("VALUE_STRING: " + jsonParser.getString());
                }
                if(jsonParser.next().equals("VALUE_NUMBER")) {
                    System.out.println("VALUE_NUMBER: "+ jsonParser.getInt());
                }
                
                
           //write it     { "channel":"zaneacademy", "tutorials":[ "Introduction to RMI", "Introduction to WebSockets", "Command Pattern"]}
            }
        
    }

}
