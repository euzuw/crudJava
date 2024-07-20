package com.example.crud.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequestProduct{

        @NotBlank
        String name;

        Integer priceInCents;

        public RequestProduct(String name, Integer priceInCents) {
                this.name = name;
                this.priceInCents = priceInCents;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getPriceInCents() {
                return priceInCents;
        }

        public void setPriceInCents(Integer priceInCents) {
                this.priceInCents = priceInCents;
        }
}
