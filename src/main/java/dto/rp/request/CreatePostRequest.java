package dto.rp.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePostRequest (

    @NotBlank String title,
    @NotBlank @Size(max = 3000) String content
){}


