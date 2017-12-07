package com.team.playerservice.Domain;


import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.List;

public class PlayerSpecifications {

    public static Specification<Player> containsTextInAttributes(String text, List<String> attributes) {
        if (!text.contains("%")) {
            text = "%" + text + "%";
        }
        String finalText = text;
        return (root, query, builder) -> builder.or(root.getModel().getDeclaredSingularAttributes().stream()
                .filter(a -> attributes.contains(a.getName()))
                .map(a -> builder.like(root.get(a.getName()), finalText))
                .toArray(Predicate[]::new)
        );
    }

    public static Specification<Player> containsTextInName(String text) {
        return containsTextInAttributes(text, Arrays.asList("name", "vorname"));
    }
}
