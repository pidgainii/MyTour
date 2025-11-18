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
public class CreateLocationRequest {
    private String name;
    private double latitude;
    private double longitude;
    private String description;
    private String category;
    private List<String> mediaUrls;
}