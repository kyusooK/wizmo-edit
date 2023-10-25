package wizmokeycloak.infra;
import wizmokeycloak.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/salesOrders")
@Transactional
public class SalesOrderController {
    @Autowired
    SalesOrderRepository salesOrderRepository;






    @RequestMapping(value = "salesOrders/{id}/produce",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public SalesOrder produce(@PathVariable(value = "id")  id, @RequestBody ProduceCommand produceCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /salesOrder/produce  called #####");
            Optional<SalesOrder> optionalSalesOrder = salesOrderRepository.findById(id);
            
            optionalSalesOrder.orElseThrow(()-> new Exception("No Entity Found"));
            SalesOrder salesOrder = optionalSalesOrder.get();
            salesOrder.produce(produceCommand);
            
            salesOrderRepository.save(salesOrder);
            return salesOrder;
            
    }
    



}
//>>> Clean Arch / Inbound Adaptor
