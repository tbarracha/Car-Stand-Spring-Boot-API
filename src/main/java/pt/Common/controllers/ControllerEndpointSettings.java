package pt.Common.controllers;

public class ControllerEndpointSettings {
    private boolean allowGet;
    private boolean allowGetAll;
    private boolean allowCreate;
    private boolean allowUpdate;
    private boolean allowDelete;

    public ControllerEndpointSettings(boolean allowGet, boolean allowGetAll, boolean allowCreate, boolean allowUpdate, boolean allowDelete) {
        this.allowGet = allowGet;
        this.allowGetAll = allowGetAll;
        this.allowCreate = allowCreate;
        this.allowUpdate = allowUpdate;
        this.allowDelete = allowDelete;
    }

    public boolean getAllowGet() {
        return allowGet;
    }
    public boolean getAllowGetAll() {
        return allowGetAll;
    }
    public boolean getAllowCreate() {
        return allowCreate;
    }
    public boolean getAllowUpdate() {
        return allowUpdate;
    }
    public boolean getAllowDelete() {
        return allowDelete;
    }
}
