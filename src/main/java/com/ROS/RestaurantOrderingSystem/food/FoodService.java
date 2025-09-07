package com.ROS.RestaurantOrderingSystem.food;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodItemRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public FoodService(FoodRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    // ➡ Add Food
    public FoodItem addFood(String name, String description, Double price, Integer stock, MultipartFile image) throws IOException {
        // ensure upload dir exists
        Path uploadPath = Paths.get(uploadDir).toAbsolutePath();
        Files.createDirectories(uploadPath);

        // generate unique filename
        String originalFilename = StringUtils.cleanPath(image.getOriginalFilename());
        String fileName = System.currentTimeMillis() + "_" + originalFilename;

        // save file
        Path target = uploadPath.resolve(fileName);
        Files.copy(image.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

        // create entity
        FoodItem item = new FoodItem();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setStock(stock);
        item.setImageUrl("/images/" + fileName);

        return foodItemRepository.save(item);
    }

    // ➡ Get all foods
    public List<FoodItem> getAllFoods() {
        return foodItemRepository.findAll();
    }

    // ➡ Get one food
    public Optional<FoodItem> getFoodById(Long id) {
        return foodItemRepository.findById(id);
    }

    // ➡ Update food
    public Optional<FoodItem> updateFood(Long id, String name, String description, Double price, Integer stock, MultipartFile image) throws IOException {
        Optional<FoodItem> opt = foodItemRepository.findById(id);
        if (!opt.isPresent()) return Optional.empty();

        FoodItem item = opt.get();
        if (name != null) item.setName(name);
        if (description != null) item.setDescription(description);
        if (price != null) item.setPrice(price);
        if (stock != null) item.setStock(stock);

        if (image != null && !image.isEmpty()) {
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath();
            Files.createDirectories(uploadPath);

            String originalFilename = StringUtils.cleanPath(image.getOriginalFilename());
            String fileName = System.currentTimeMillis() + "_" + originalFilename;
            Path target = uploadPath.resolve(fileName);
            Files.copy(image.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

            // delete old file
            if (item.getImageUrl() != null) {
                String oldFileName = item.getImageUrl().substring(item.getImageUrl().lastIndexOf("/") + 1);
                Path oldPath = uploadPath.resolve(oldFileName);
                try { Files.deleteIfExists(oldPath); } catch (IOException ignored) {}
            }

            item.setImageUrl("/images/" + fileName);
        }

        return Optional.of(foodItemRepository.save(item));
    }

    // ➡ Delete food
    public boolean deleteFood(Long id) {
        Optional<FoodItem> opt = foodItemRepository.findById(id);
        if (!opt.isPresent()) return false;

        FoodItem item = opt.get();

        // delete file
        if (item.getImageUrl() != null) {
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath();
            String fileName = item.getImageUrl().substring(item.getImageUrl().lastIndexOf("/") + 1);
            try { Files.deleteIfExists(uploadPath.resolve(fileName)); } catch (IOException ignored) {}
        }

        foodItemRepository.delete(item);
        return true;
    }
}
