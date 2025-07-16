package lk.customer.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor


@Data
public class CustomerDto {

    private  int Id;
    private  String Name;
    private  String Address;
    private int CustomerId;
    private  int Age;

    public void update(CustomerDto customerDto) {
    }
}
