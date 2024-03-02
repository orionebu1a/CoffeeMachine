package com.test.testTask.client.domain;

import com.test.testTask.shared.dtos.CoffeeDTO;
import org.fusesource.restygwt.client.MethodCallback;

import javax.ws.rs.QueryParam;

public interface CoffeeClient {
    void makeCoffee(@QueryParam("type") String type,
                    @QueryParam("grade") String grade,
                    @QueryParam("size") String size,
                    @QueryParam("sugar") int sugarAmount,
                    MethodCallback<CoffeeDTO> callback);
}
