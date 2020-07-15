package koolitus.REST;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
@Service
public class MathService {
    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }
}
