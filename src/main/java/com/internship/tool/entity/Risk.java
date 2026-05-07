package com.internship.tool.entity;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "risks", indexes = {
        @Index(name = "idx_status", columnList = "status"),
        @Index(name = "idx_created_at", columnList = "createdAt")
})
@NotBlank(message = "Title is required")
private String title;

@NotBlank(message = "Status is required")
private String status;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Risk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String status;

    private int score;
}