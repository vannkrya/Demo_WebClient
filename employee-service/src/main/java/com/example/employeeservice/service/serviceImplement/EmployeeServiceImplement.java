package com.example.employeeservice.service.serviceImplement;

import com.example.employeeservice.model.entity.Employee;
import com.example.employeeservice.model.response.AddressResponse;
import com.example.employeeservice.model.response.EmployeeResponse;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplement implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final WebClient webClient;

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        //using webclient
        //make Microservices Communication using WebClient
        AddressResponse addressResponse = webClient
                .get()
                .uri("/addresses/" + id)
                .retrieve().bodyToMono(AddressResponse.class)
                .block();

        System.out.println("addressResponse: " + addressResponse);


        WebClient client = WebClient.create();
        Flux<String> responseBody = client
                .get()
                .uri("http://localhost:8080/employee-service/employees/1")
                .retrieve()
                .bodyToFlux(String.class);

//        responseBody.subscribe(body -> {
//            System.out.println("subscribe: " + body);
//        });

        System.out.println("testing retrieve: " + responseBody);


        Mono<String> stringMono = Mono.just("testing mono").log();
        stringMono.subscribe(System.out::println);


        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }



}
