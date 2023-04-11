package DairyApp;

public class Entry {
    private int id;
    private String title;
    private String body;

    public Entry(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString(){
        return String.format("""
                ==========================================
                ID: %s
                TITLE: %s
                ==========================================
                BODY:
                %s
                ==========================================
                """, id, title, body);
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setBody(String body){
        this.body = body;
    }
}