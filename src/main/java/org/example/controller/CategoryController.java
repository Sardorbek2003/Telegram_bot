package org.example.controller;

import org.example.contener.ComponentContainer;
import org.example.enam.CategoryType;
import org.example.model.Category;
import org.example.util.ActionUtil;

import java.util.List;
import java.util.UUID;

public class CategoryController {
    public void add(UUID customerId) {
        Category category = new Category();
        System.out.println("0.  category in parent costumer");
        System.out.println("1.  category in parent category");
        int n = ActionUtil.getAction(2);
        Category myCategory;
        if (n == 0) {
            category.setParentId(customerId);
        } else {
            int index = 0;
            List<Category> list = ComponentContainer.categoryService.list(customerId);
            if (list.isEmpty()){
                return;
            }
            for (Category category1 : list) {
                System.out.println(index + "  " + category1.getName());
                index++;
            }
            index = ActionUtil.getAction(list.size());
            myCategory = list.get(index);
            category.setParentId(myCategory.getId());
        }
        System.out.print("enter category name:  ");
        String name = ComponentContainer.scannerStr.nextLine();
        category.setName(name);
        category.setCustomerId(customerId);
        category.setCategoryType(CategoryType.EMPTY);
        category.setId(UUID.randomUUID());
        ComponentContainer.categoryService.add(category);

    }
}
