package com.example.jobPortal.utils;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Industry {
        AGRICULTURE("Agriculture, Forestry, Fishing and Hunting"),
        MINING("Mining, Quarrying, and Oil and Gas Extraction"),
        CONSTRUCTION("Construction"),
        MANUFACTURING("Manufacturing"),
        WHOLESALE_TRADE("Wholesale Trade"),
        RETAIL_TRADE("Retail Trade"),
        TRANSPORTATION("Transportation and Warehousing"),
        INFORMATION("Information"),
        FINANCIAL_SERVICES("Finance and Insurance"),
        REAL_ESTATE("Real Estate and Rental and Leasing"),
        PROFESSIONAL_SERVICES("Professional, Scientific, and Technical Services"),
        MANAGEMENT("Management of Companies and Enterprises"),
        ADMINISTRATIVE_SUPPORT("Administrative and Support Services"),
        EDUCATION("Educational Services"),
        HEALTH_CARE("Health Care and Social Assistance"),
        ARTS("Arts, Entertainment, and Recreation"),
        ACCOMMODATION_FOOD_SERVICES("Accommodation and Food Services"),
        OTHER("Other");

        private final String label;

        Industry(String label) {
            this.label = label;
        }

        @JsonValue//needed for deserialization
        public String getLabel() {
            return label;
        }
    }
