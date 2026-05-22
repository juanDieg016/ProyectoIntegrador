package dev.juanv.proyectointegrador.model.constant;

public enum NewsState {

    NEWS_STATE_DRAFT("Borrador"),
    NEWS_STATE_PUBLISHED("Publicado");

    private final String visualName;

    NewsState(String visualName) {
        this.visualName = visualName;
    }

    public String getVisualName() {
        return visualName;
    }
}