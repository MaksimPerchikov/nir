package ru.nir.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterDistributor {

    private final static String ALL_TASK_GET = "/tasks";
    private final static String ALL_CUSTOMERS_GET = "/customers";
    private final static String TASK_BY_ID_GET = "/task/";
    private final static String CUSTOMER_BY_ID_GET = "/customer";
    private final static String ADD_TASK_POST = "/task";
    private final static String ADD_CUSTOMER_POST = "/customer";
    private final static String DELETE_TASK_DELETE = "/";

    private final CustomerTaskController controller;

    @Autowired
    public ConverterDistributor(CustomerTaskController controller) {
        this.controller = controller;
    }

    public Object converterRequests(HttpServletRequest request) throws IOException {

        String s = request.getServletPath();
        String s1 = request.getRequestURI();
        String method = request.getMethod();
        List<Object> s3 = request.getReader().lines().collect(Collectors.toList());

        switch (method){
            case "GET":

            case "POST":

            case "DELETE":
        }

        return null;
    }



}
