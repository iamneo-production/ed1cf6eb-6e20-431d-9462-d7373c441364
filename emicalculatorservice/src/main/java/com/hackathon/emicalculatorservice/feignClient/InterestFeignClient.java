import com.emiCalculatorService.dto.InterestRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="interest-service",url = "http://localhost:8082/interest")
public interface InterestFeignClient {
    @GetMapping("/rate/{loanType}")
    public InterestRateResponse requestRate(@PathVariable String loanType);
}
