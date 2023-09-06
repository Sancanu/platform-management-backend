package com.management.platform.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Data
@Entity
@Table(name="Project")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;

    @Column(unique = true,nullable = false)
    private String title;

    private String description;

    private String typeProject;

    private Date startDate;

    private Date finishDate;

    private double amount;

    private double totalCost;

    private double expenseAmount;

    private String directorName;


}
