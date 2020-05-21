package com.parksrazor.web.controllers;

import com.parksrazor.web.domains.PlayerDTO;
import com.parksrazor.web.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired PlayerService playerService;
    @Autowired PlayerDTO player;
    @GetMapping("")
    public List<PlayerDTO> list(){
        return playerService.retrieve();
    }
    @PostMapping("/{playerId}/access")
    public Map<String, Object> login(
            @PathVariable String  playerId,
            @RequestBody PlayerDTO params){
        Map<String,Object> map = new HashMap<>();
        player = playerService.login(params);
        if(player != null){
            System.out.println("로그인 정보 "+ player.toString());
            map.put("result", true);
        }else{
            map.put("result", false);
        }
        map.put("player", player);
        return map;
    }
}
