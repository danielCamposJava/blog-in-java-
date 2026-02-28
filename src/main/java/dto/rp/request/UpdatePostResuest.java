package dto.rp.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdatePostResuest(
        @NotBlank String title,
        @NotBlank @Size(max = 5000) String content

)  {
}
