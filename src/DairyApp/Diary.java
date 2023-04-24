package DairyApp;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private List<Entry> entries = new ArrayList<>();
    private int idCount = 1;
    private String username;
    private String password;
    private boolean islocked = true;

//    private int id;

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void createEntry(String title, String body) {
        if(!islocked){
        Entry entry = new Entry(idCount, title, body);
        entries.add(entry);
        idCount++;
        }
    }

    public int getNumberOfEntries() {
        return entries.size();
    }


    public Entry findEntryById(int id) {
        if (!islocked) {
        if(entries.isEmpty())return null;
        for (Entry entry : entries) {
                if (entry.getId() == id) {
                    return entry;
                }
            }
            throw new IllegalArgumentException("Entry doesn't exist");
        }
        throw new RuntimeException("Wrong Password");
    }


    public void unlockDiary(String password) {
        if (this.password.equals(password)) islocked = false;
        throw new IllegalArgumentException("Wrong password");
    }

    public void lockDiary(){
        islocked = true;
       throw new IllegalArgumentException("Wrong password! Enter password: ");
    }

    public void deleteEntry(int id) {
        if (!islocked){
            entries.remove(findEntryById(id));
        }
    }
    public void updateEntry(int id, String title, String body) {
       Entry foundEntry = findEntryById(id);
       foundEntry.setTitle(title);
       foundEntry.setBody(body);
    }

}