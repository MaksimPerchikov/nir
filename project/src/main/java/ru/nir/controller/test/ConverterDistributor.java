package ru.nir.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.nir.dto.TaskDTO;

/*@Log4j2
@Configuration*/
public class ConverterDistributor {

    private final static String ALL_TASK_GET = "/tasks";
    private final static String ALL_CUSTOMERS_GET = "/customers";
    private final static String TASK_BY_ID_GET = "/task/";
    private final static String CUSTOMER_BY_ID_GET = "/customer";
    private final static String ADD_TASK_POST = "/task";
    private final static String ADD_CUSTOMER_POST = "/customer";
    private final static String DELETE_TASK_DELETE = "/";

    private final CustomerTaskController controller;
    private final ObjectMapper objectMapper;

    //@Autowired
    public ConverterDistributor(CustomerTaskController controller,
        ObjectMapper objectMapper) {
        this.controller = controller;
        this.objectMapper = objectMapper;
    }

    /*public Object converterRequests(HttpServletRequest request) throws IOException {

        String path = request.getServletPath();
        String newPathS = path.substring(4);
        String method = request.getMethod();
        String port = String.valueOf(request.getLocalPort());
        String number = "1";
        String url = "http://localhost:" + port + path + number;

        switch (method) {
            case "GET":
                if (newPathS.equals(ALL_TASK_GET)) {
                    RestTemplate restTemplate = new RestTemplate();
                    List list = restTemplate.getForObject(URI.create(url), List.class);
                    //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    //log.info(string);
                    //return s;
                    return list;
                }
            case "POST":
                if (newPathS.equals(ADD_TASK_POST)) {
                    RestTemplate restTemplate = new RestTemplate();//Создаем объект шаблона REST
                    ResponseEntity<TaskDTO> response =
                        restTemplate.getForEntity(url, TaskDTO.class);
                    TaskDTO taskDTO = response.getBody();
                    log.info(taskDTO);
                }

            case "DELETE":
                if (newPathS.equals(DELETE_TASK_DELETE)) {

                }
        }

        return null;
    }
*/

}
