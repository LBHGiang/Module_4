package email_setting.model;

public class Setting {
    private String language;
    private Integer pageSize;
    private Integer spamsFilter;
    private String signature;

    public Setting() {
    }

    public Setting(String language, Integer pageSize, Integer spamsFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(Integer spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
