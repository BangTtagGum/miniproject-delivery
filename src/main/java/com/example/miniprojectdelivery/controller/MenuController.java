package com.example.miniprojectdelivery.controller;

import com.example.miniprojectdelivery.dto.menu.MenuCreateRequestDto;
import com.example.miniprojectdelivery.dto.menu.MenuResponseDto;
import com.example.miniprojectdelivery.dto.menu.MenuUpdateRequestDto;
import com.example.miniprojectdelivery.dto.MessageResponseDto;
import com.example.miniprojectdelivery.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public MenuResponseDto createMenu(
            @Valid @RequestParam("image") MultipartFile image,
            @Valid @RequestParam("restaurantId") Long restaurantId,
            @Valid @RequestParam("name") String name,
            @Valid @RequestParam("cost") int cost) throws IOException {
        return menuService.createMenu(image, restaurantId, name, cost);
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
    public MenuResponseDto updateMenu(
            @PathVariable Long id,
            @RequestParam(value = "image") MultipartFile newImage,
            @RequestParam("name") String name,
            @RequestParam("cost") int cost) throws IOException {
        return menuService.update(id, newImage, name, cost);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> deleteMenu(@PathVariable Long id){
        return ResponseEntity.ok().body(menuService.deleteMenu(id));
    }
}
