package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.enam.CategoryType;
import org.example.model.Category;
import org.example.util.FilePathUtil;
import org.example.util.JsonUtil;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CategoryRepository {
    public void add(Category category) {
        List<Category> categorys = read();
        categorys.add(category);
        write(categorys);
    }

    public List<Category> list(UUID customerId) {
        List<Category> categorys = read();
        return categorys.stream()
                .filter(l ->  l.getCategoryType().equals(CategoryType.EMPTY) && l.getCustomerId().equals("51e19df5-c4f4-4763-bdac-f0a57fd5d953"))
                .collect(Collectors.toList());
    }

    private List<Category> read() {
        return JsonUtil.readGson(FilePathUtil.getCategory(), new TypeReference<List<Category>>() {
        });
    }

    private void write(List<Category> categories) {
        JsonUtil.writeGson(categories, FilePathUtil.getCategory());
    }
}
