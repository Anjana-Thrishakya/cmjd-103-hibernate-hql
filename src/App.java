import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import entity.CustomerEntity;
import entity.OrderEntity;
import repository.CustomerRepository;

public class App {
    public static void main(String[] args) throws Exception {
        CustomerRepository repository = new CustomerRepository();

        // CustomerEntity c1 = repository.getCustomer("C005");
        // System.out.println(c1.toString());

        // List<CustomerEntity> customerEntities = repository.getAllCustomers();
        // customerEntities.forEach(e -> {
        // System.out.println(e);
        // });

        // List<Object[]> data = repository.getAllCustomersByNative();
        // data.forEach(e-> {
        // System.out.println(Arrays.toString(e));
        // });

        // List<Object[]> data = repository.getCustomerNameAndDob();
        // data.forEach(e-> {
        // System.out.println(Arrays.toString(e));
        // });

        // CustomerEntity c1 = repository.getCustomerByHQL("C005");
        // System.out.println(c1.toString());

        // CustomerEntity c1 = repository.getCustomerByHQLUsingNamedParameterd("C005");
        // System.out.println(c1.toString());

        // List<CustomerEntity> customerEntities =
        // repository.getAllCustomersOrderByNameDesc();
        // customerEntities.forEach(e -> {
        // System.out.println(e);
        // });

        // Object[] data = repository.getCustomerSummery();
        // System.out.println(Arrays.toString(data));

        // List<Object[]> data = repository.getCustomerSummeryByProvince();
        // data.forEach(e -> {
        //     System.out.println(Arrays.toString(e));
        // });

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2009-01-01");
        List<OrderEntity> orderEntities = repository.getOrdersBeforeAndProvince(date , "Western");
        orderEntities.forEach(e->{
            System.out.println(e.toString());
        });

    }
}
