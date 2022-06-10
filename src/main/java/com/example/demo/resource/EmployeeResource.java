package com.example.demo.resource;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.MySqlEmployeeModel;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private final EmployeeModel employeeModel;

    public EmployeeResource() {
        this.employeeModel = new MySqlEmployeeModel();
    }

    @GET
    public List<Employee> findAll(){
        return employeeModel.findAll();
    }
    @POST
    public Employee save(Employee employee){
        return employeeModel.save(employee);
    }
}
