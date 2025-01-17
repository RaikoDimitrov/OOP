package UnitTesting.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DatabaseTest {

    private static final Person person1 = new Person(1, "First");
    private static final Person person2 = new Person(2, "Second");
    private static final Person[] VALID_DATABASE = {person1, person2};
    private static final Person[] INVALID_DATABASE = new Person[17];
    private static final int PERSON_ID = 13;
    private static final String PERSON_NAME = "Raiko";
    private Database database;
    private Person person;

    //mocking
    Person mockedPerson = Mockito.mock(Person.class);
    Database mockedDatabase = Mockito.mock(Database.class);

    @BeforeEach
    void setUp() throws OperationNotSupportedException {
        this.database = new Database(VALID_DATABASE);
        this.person = new Person(PERSON_ID, PERSON_NAME);
        mockedPerson = new Person(PERSON_ID, PERSON_NAME);
    }

    //test constructor that initialize valid database
    @Test
    void testThatDatabaseInitializeValid() {
    }

    //test constructor that cant initialize out of bounds database
    @Test
    void testThatDatabaseCantInitializeInvalid() throws OperationNotSupportedException {
        assertThrows(OperationNotSupportedException.class, () -> {
            Database invalidDatabase = new Database(INVALID_DATABASE);
            Database invalidDatabaseTwo = new Database();
        });
    }

    @Test
    void testThatCanAddPerson() throws OperationNotSupportedException {
        int initialSize = this.database.getElements().length;
        database.add(mockedPerson);
        assertEquals(initialSize + 1, this.database.getElements().length, "Not added person");
    }

    @Test
    void testThatCantAddNull() {
        assertThrows(OperationNotSupportedException.class, () -> {
            database.add(null);
        });
    }

    @Test
    void testThatCanRemove() throws OperationNotSupportedException {
        this.database.remove();
        assertEquals(0, this.database.getElements().length - 1, "Could not remove person");
    }

    @Test
    void testThatCantRemoveThanTheyAre() {
        assertThrows(OperationNotSupportedException.class, () -> {
            for (int i = 0; i < database.getElements().length - 1; i++) {
                database.remove();
            }
            database.remove();
            database.remove();
        });
    }

    //using mocking
    @Test
    void testThatCanRemovePerson() throws OperationNotSupportedException {

        //arrange
        Person[] mockedElements = {person1, person2};
        Mockito.when(mockedDatabase.getElements()).thenReturn(mockedElements);
        List<Person> dynamicList = new ArrayList<>(Arrays.asList(mockedElements));
        //remove method of mocked database
        Mockito.doAnswer(invocationOnMock -> {
            if (!dynamicList.isEmpty()) dynamicList.remove(dynamicList.size() - 1);
            else throw new OperationNotSupportedException();
            return null;
        }).when(mockedDatabase).remove();

        //current stat of getElements
        Mockito.when(mockedDatabase.getElements()).thenAnswer(invocationOnMock -> dynamicList.toArray(new Person[0]));

        //act
        int initialSize = mockedDatabase.getElements().length;
        mockedDatabase.remove();

        //asser
        assertEquals(initialSize - 1, mockedDatabase.getElements().length, "Failed to remove person");
        assertEquals(person1, mockedDatabase.getElements()[mockedDatabase.getElements().length - 1], "Last removed person is incorrect!");
    }

    @Test
    void testThatCanFindByUsername() throws OperationNotSupportedException {
        this.database.add(this.person);
        Person p = this.database.findByUsername(this.person.getUsername());
        assertEquals(this.person, p, "Could not find such username");
    }

    @Test
    void testThatCantFindNullUsername() {
        assertThrows(OperationNotSupportedException.class, () -> {
            this.database.findByUsername(null);
        });
    }

    @Test
    void testThatCanTFindMoreThanOneSameUsername() {
        assertThrows(OperationNotSupportedException.class, () -> {
            this.database.add(this.person);
            this.database.add(this.person);
            this.database.findByUsername(PERSON_NAME);
        });
    }

    @Test
    void testThatCanFindByID() throws OperationNotSupportedException {
        this.database.add(this.person);
        Person p = this.database.findById(this.person.getId());
        assertEquals(this.person.getId(), p.getId(), "Could not find by ID");

    }

    @Test
    void testThatCantFindNonExistentID() {
        assertThrows(OperationNotSupportedException.class, () -> {
            this.database.findById(55);
        });
    }

    @Test
    void testThatCantFinDMoreThanOneExistentID() {
        assertThrows(OperationNotSupportedException.class, () -> {
            this.database.add(new Person(2, "Ivan"));
            this.database.findById(2);
        });
    }
}