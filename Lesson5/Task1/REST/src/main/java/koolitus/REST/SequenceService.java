package koolitus.REST;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
@Service
public class SequenceService {

    public boolean isPrime(int arv) {
        int jagaja = 2;
/// kui arvestada ka sellega et kui 2'ga juba ei jagu, siis pole mõtet kontrollida, kas 4,6,8,10 jne paarisarvuga jagub
        while ( jagaja <= arv/2 ) {
            if (arv % jagaja == 0) {
                return false;
            }
            jagaja++;
        }
        return true;
    }


}
