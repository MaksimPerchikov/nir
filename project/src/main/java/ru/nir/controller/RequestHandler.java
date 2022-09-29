package ru.nir.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//получить хедеры из метода
@RestController
@RequestMapping("/api")
public class RequestHandler {

    private final ConverterDistributor converterDistributor;

    @Autowired
    public RequestHandler(ConverterDistributor converterDistributor) {
        this.converterDistributor = converterDistributor;
    }

    @GetMapping("/**")
    public Object getDataGet(HttpServletRequest request) throws ServletException, IOException {
        return handleRequest(request);
    }

    @PostMapping("/**")
    public Object getDataPost(HttpServletRequest request) throws ServletException, IOException {
        return handleRequest(request);
    }

    @DeleteMapping("/**")
    public Object getDataDelete(HttpServletRequest request) throws ServletException, IOException {
        return handleRequest(request);
    }

    private Object handleRequest(HttpServletRequest request) throws ServletException, IOException {
        converterDistributor.converterRequests(request);
        return null;
    }

}
