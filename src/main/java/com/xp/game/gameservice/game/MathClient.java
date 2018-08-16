package com.xp.game.gameservice.game;

import com.xp.game.gameservice.level.Level;
import feign.Param;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name= "math" ,url = "http://192.168.0.6:8810/api")
public interface MathClient {
    @RequestMapping(method = RequestMethod.GET, value = "operation")
    List<Valuable> getEquations(@RequestParam("min")int min,
                                @RequestParam(value = "max") int max,
                                @RequestParam("equations")int equations);
}