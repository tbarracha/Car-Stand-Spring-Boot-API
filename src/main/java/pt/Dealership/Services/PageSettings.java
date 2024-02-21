package pt.Dealership.Services;

public class PageSettings {
    private int page;
    private int size;
    private String sort;

    public PageSettings(int page) {
        this.page = page;
        this.size = 10;
    }

    public PageSettings(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public PageSettings(int page, int size, String sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }
}
