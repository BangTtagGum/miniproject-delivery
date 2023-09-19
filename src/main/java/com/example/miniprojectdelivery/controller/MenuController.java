package com.example.miniprojectdelivery.controller;

import com.example.miniprojectdelivery.dto.MenuRequestDto;
import com.example.miniprojectdelivery.dto.MenuResponseDto;
import com.example.miniprojectdelivery.dto.MessageResponseDto;
import com.example.miniprojectdelivery.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menus")
public class MemuController {

    private final MenuService menuService;

    @PostMapping
    public MenuResponseDto createMenu(@RequestBody MenuRequestDto requestDto){
        return menuService.createMenu(requestDto);
    }

    @GetMapping
    public List<MenuResponseDto> getMenus(){
        return menuService.getMenus();
    }
    @GetMapping("/{id}")
    public MenuResponseDto selectMenu(@PathVariable Long id){
        return menuService.selectMenu(id);
    }
    @PutMapping("/{id}")
    public MenuResponseDto updateMenu(@PathVariable Long id, @RequestBody MenuRequestDto requestDto){
        return menuService.update(id, requestDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> deleteMenu(@PathVariable Long id){
        return menuService.deleteMenu(id);
    }
}
