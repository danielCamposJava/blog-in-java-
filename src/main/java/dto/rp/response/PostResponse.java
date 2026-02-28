package dto.rp.response;


import java.time.LocalDateTime;
import java.util.UUID;

public record PostResponse (

        UUID id,
        String title,
        String Content,
        LocalDateTime createAt
){

}
