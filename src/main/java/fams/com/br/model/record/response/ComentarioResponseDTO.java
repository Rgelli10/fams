package fams.com.br.model.record.response;

import java.time.LocalDateTime;

public record ComentarioResponseDTO(
        String usuario,
        String texto,
        LocalDateTime data
) {}

