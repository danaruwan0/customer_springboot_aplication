package lk.customer.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;


@AllArgsConstructor
@NoArgsConstructor
@Lazy
@Data
public class CustomerDto {

    private int Id;
    private String Name;
    private String Address;
    private int CustomerId;
    private int Age;

}
