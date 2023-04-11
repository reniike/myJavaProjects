package DairyApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    private Diary diary;
//    private Entry entry;

    @BeforeEach
    public void startWith(){
        diary = new Diary("Renike", "0000");
        diary.createEntry("Summary of life 1", "Life is a spoon");
        diary.createEntry("Summary of life 2", "Ile aye, ile asan");
        diary.createEntry("Summary of life 3", "Ile aye, ile Asan");
    }

    @Test
    public void testThatEntryIsCreated() {
        assertEquals(3, diary.getNumberOfEntries());
    }

    @Test
    public void testThatEntryCanBeFoundWithId(){
        diary.lockDiary();
        diary.unlockDiary("0000");
        String expected = """
                ==========================================
                ID: 1
                TITLE: Summary of life 1
                ==========================================
                BODY:
                Life is a spoon
                ==========================================
                """;
        assertEquals(expected, diary.findEntryById(1).toString());
    }

    @Test
    public void testThatPasswordWorks(){
        diary.lockDiary();
        diary.unlockDiary("0000");
        String expected =  """
                ==========================================
                ID: 2
                TITLE: Summary of life 2
                ==========================================
                BODY:
                Ile aye, ile asan
                ==========================================
                """;
        assertEquals(expected, diary.findEntryById(2).toString());
    }

    @Test
    public void testThatEntryCanBeDeleted(){
        diary.lockDiary();
        diary.unlockDiary("0000");
        diary.deleteEntry(1);
        assertEquals(2, diary.getNumberOfEntries());
    }

    @Test
    public void testThatEntryThatCanBeUpdated(){
        diary.lockDiary();
        diary.unlockDiary("0000");
        System.out.println(diary.findEntryById(3).toString());
        diary.updateEntry(3, "new title", "new body");
        String expected =  """
                ==========================================
                ID: 3
                TITLE: new title
                ==========================================
                BODY:
                new body
                ==========================================
                """;
        assertEquals(expected, diary.findEntryById(3).toString());
        System.out.println(diary.findEntryById(3));
    }

}
