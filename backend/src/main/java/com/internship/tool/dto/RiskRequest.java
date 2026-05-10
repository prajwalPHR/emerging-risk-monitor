package com.internship.tool.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RiskRequest {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    public String title;

    @NotBlank(message = "Status is required")
    public String status;
}