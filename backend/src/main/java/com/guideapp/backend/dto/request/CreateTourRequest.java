package com.guideapp.backend.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateTourRequest {
    private String title;
    private String description;
    private String country;
    private float rating_avg;
    private Integer rating_n;
    private String thumbnail;
    private List<CreateLocationRequest> locations;
}