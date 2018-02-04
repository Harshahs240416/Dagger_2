package myrecyclerview;

/**
 * Created by HARSHA H S on 04-02-2018.
 */

public class RecyclerData {

    private String icon;

    private String id;

    private String name;

    public RecyclerData (String id, String name, String icon){
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
