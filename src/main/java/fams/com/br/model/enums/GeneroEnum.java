package fams.com.br.model.enums;

public enum GeneroEnum {
    FILME(false),
    SERIE(true),
    ANIME(true),
    MANGA(false);

    private final boolean possuiTemporada;

    GeneroEnum(boolean possuiTemporada) {
        this.possuiTemporada = possuiTemporada;
    }

    public boolean possuiTemporada() {
        return possuiTemporada;
    }
}
