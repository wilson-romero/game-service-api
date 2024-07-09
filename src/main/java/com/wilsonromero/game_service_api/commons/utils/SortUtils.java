package com.wilsonromero.game_service_api.commons.utils;

import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class SortUtils {

    private SortUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Sort.Order> createSortOrdersFromCriteria(String[] sortCriteria) {
        List<Sort.Order> orders = new ArrayList<>();
        if (sortCriteria != null) {
            for (String criteria : sortCriteria) {
                var direction = Sort.Direction.ASC;
                var criteriaParts = criteria.split(":");
                if (criteriaParts.length == 2 && criteriaParts[1].trim().equalsIgnoreCase("desc")) {
                    direction = Sort.Direction.DESC;
                }
                orders.add(new Sort.Order(direction, criteriaParts[0].trim()));
            }
        }
        return orders;
    }
}
