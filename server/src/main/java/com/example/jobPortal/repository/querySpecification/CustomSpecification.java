package com.example.jobPortal.repository.querySpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.jobPortal.entity.Job;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CustomSpecification {

    public static Specification<Job> getJobs(Map<String, String> request) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (request.containsKey("workMode")) {
                String workModeValue = request.get("workMode");
                // Perform a case-insensitive search
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("workMode")), "%" + workModeValue.toLowerCase() + "%"));
            }

            if (request.containsKey("title")) {
                String titleValue = request.get("title");
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + titleValue.toLowerCase() + "%"));
            }

            if (request.containsKey("experienceRequired")) {
                String experienceValue = request.get("experienceRequired");
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("experienceRequired")), "%" + experienceValue.toLowerCase() + "%"));
            }

            if (request.containsKey("industry")) {
                String industryValue = request.get("industry");
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("industry")), "%" + industryValue.toLowerCase() + "%"));
            }

            if (request.containsKey("salaryRange")) {
                String salaryValue = request.get("salaryRange");
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("salaryRange")), "%" + salaryValue.toLowerCase() + "%"));
            }

            // Assuming "company" is a field in the Job entity
            if (request.containsKey("company")) {
                String companyValue = request.get("company");
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("company").get("companyName")), "%" + companyValue.toLowerCase() + "%"));
            }

            query.orderBy(criteriaBuilder.desc(root.get("id")));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
