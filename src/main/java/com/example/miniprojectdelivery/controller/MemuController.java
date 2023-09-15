package com.example.miniprojectdelivery.controller;

import com.example.miniprojectdelivery.dto.MemuResponseDto;
import com.example.miniprojectdelivery.dto.MenuRequestDto;
import com.example.miniprojectdelivery.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemuController {

    private final MenuService menuService;

    @PostMapping("/menus")
    public MemuResponseDto createMenu(@RequestBody MenuRequestDto requestDto){
        return menuService.createMenu(requestDto);
    }

    @GetMapping("/menus")
    public List<MemuResponseDto> getMenus(){
        return menuService.getMenus();
    }
    @GetMapping("/menus/{id}")
    public MemuResponseDto selectMenu(@PathVariable Long id){
        return menuService.selectMenu(id);
    }

}
