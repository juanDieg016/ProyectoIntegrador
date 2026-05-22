package dev.juanv.proyectointegrador.model.constant;

public enum ContactRequestPurpose {

    CONTACT_REQUEST_PURPOSE_SERVICE("Servicio"),
    CONTACT_REQUEST_PURPOSE_EDIFICA_PROGRAM("Programa Edifica"),
    CONTACT_REQUEST_PURPOSE_SHOWS_AND_CONFERENCES("Conferencias y shows");

    private final String visualName;

    ContactRequestPurpose(String visualName) {
        this.visualName = visualName;
    }

    public String getVisualName() {
        return visualName;
    }
}