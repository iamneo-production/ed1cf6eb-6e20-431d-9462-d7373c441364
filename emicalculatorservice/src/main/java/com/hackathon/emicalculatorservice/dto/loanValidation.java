import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class loanValidation {


    private int accountNumber;
    private double loanAmount;
    private int loanTenure;
}