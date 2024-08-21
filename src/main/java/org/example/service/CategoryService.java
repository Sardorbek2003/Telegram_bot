package org.example.service;

import org.example.contener.ComponentContainer;
import org.example.model.Category;

import java.util.List;
import java.util.UUID;

public class CategoryService {
    public void add(Category category) {
        if (!isValid(category)) {
            System.out.println("category is wrong");
            return;
        }
        ComponentContainer.categoryRepository.add(category);
    }

    private boolean isValid(Category category) {
        List<Category> categories = ComponentContainer.categoryRepository.list(category.getCustomerId());
        categories.stream().filter(l -> l.getName().equals(category.getName()));
        if (categories.size() > 0) {
            return false;
        }
        if (category.getName() == null || category.getName().equals("")) {
            System.out.println("name is wrong");
            return false;
        }
        if (category.getCategoryType() == null) {
            System.out.println("type is wrong");
            return false;
        }
        if (category.getParentId() == null || category.getCustomerId() == null) {
            System.out.println("name is wrong");
            return false;
        }
        return true;
    }

    public List<Category> list(UUID customerId) {
        return ComponentContainer.categoryRepository.list(customerId);
    }
}
