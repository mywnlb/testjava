package test.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by lb on 2018/4/25.
 */
@Service
public class TestService {
    @Value("${connection.driver}")
    private  String connection_driver;

    public String getDriver(){
        return connection_driver;
    }
}
