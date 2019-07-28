package sample.validation.service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}
