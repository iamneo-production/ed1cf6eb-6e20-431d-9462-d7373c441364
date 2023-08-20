import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidationResponce {

    private double loanAmount;
    private double income;
    private int creditScore;
    private boolean isValidation;
}