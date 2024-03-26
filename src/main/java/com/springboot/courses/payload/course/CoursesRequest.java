package com.springboot.courses.payload.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.courses.entity.Category;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoursesRequest {

    private Integer id;

    @NotEmpty(message = "Title can not be empty")
    @Length(min = 5, max = 60, message = "Title must have 5 - 60 characters")
    private String title;

    private String slug;

    @NotEmpty(message = "Description can not be empty")
    @Size(min = 10, message = "Description must be at least 10 characters")
    private String description;

    private String thumbnail;

    private int price;

    private float discount;

    @JsonProperty("student_count")
    private int studentCount;

    @JsonProperty("published_at")
    private Date publishedAt;

    @JsonProperty("is_coming_soon")
    private boolean isComingSoon;

    @JsonProperty("is_published")
    private boolean isPublished;

    @NotNull(message = "Category ID can not be null")
    @JsonProperty("category_id")
    private Integer categoryId;

    @NotEmpty(message = "Course info can not be empty")
    @Valid
    @JsonProperty("info_list")
    private List<CourseInfoRequest> infoList;
}
