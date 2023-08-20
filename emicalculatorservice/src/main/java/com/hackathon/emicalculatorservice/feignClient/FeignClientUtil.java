import com.emiCalculatorService.dto.ValidationResponce;
import com.emiCalculatorService.dto.loanValidation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value="loan-validation-service",url = "http://localhost:8085/validation")
public interface FeignClientUtil {
    @PostMapping("/checkValidation")
    public ValidationResponce checkLoanAmount(loanValidation loan);
}