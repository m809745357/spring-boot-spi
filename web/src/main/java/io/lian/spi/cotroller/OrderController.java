package io.lian.spi.cotroller;

import io.lian.spi.service.OrderService;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/**
 * @author m809745357
 */
@RestController
public class OrderController {

    @RequestMapping(value = "/order/create", method = RequestMethod.GET)
    public String order() {
        List<OrderService> orderServiceList = SpringFactoriesLoader.loadFactories(OrderService.class, this.getClass().getClassLoader());
        Iterator<OrderService> iterator = orderServiceList.iterator();
        OrderService orderService = iterator.next();
        return orderService.create();
    }
}
