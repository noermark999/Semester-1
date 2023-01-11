/*

2. Enkeltrettet til-mange associering

public class Group {
    // association --> 0..* Person
    private final ArrayList<Person> persons = new ArrayList<>();

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }

     * Adds the person to this group,
     * if they aren't connected.
     * Pre: The person isn't connected to another group.

public void addPerson(Person person) {
        if (!persons.contains(person)) {
        persons.add(person);
        }
        }


 * Removes the person from this group,
 * if they are connected.

public void removePerson(Person person) {
        if (persons.contains(person)) {
        persons.remove(person);
        }
     }
  }
___________________________________________________________________________

3.  Enkeltrettet til-0..1 associering

public class Person {
    private String name;
    // association --> 0..1 Group
    private Group group;

    public Group getGroup() {
        return group;
    }

     * Sets the group as this person's group.

public void setGroup(Group group) {
        if (this.group != group) {
        this.group = group;
        }
     }
  }
__________________________________________________________________________

4.  Enkeltrettet tvungen associering

public class Person {
    private String name;
    // forced association --> 1 Group
    private Group group;
       public Person(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }
}

Eller den anden vej:

public class Person {
    private String name;

        * Pre: group != null
public Person(String name, Group group) {
        this.name = name;
        group.addPerson(this);
        }
    }
________________________________________________________________________________

5.  Enkeltrettet komposition

public class Group {
    private String name;
    // composition --> 0..* Person
    private final ArrayList<Person> persons = new ArrayList<>();

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    public Person createPerson(String personName) {
        Person person = new Person(personName);
        persons.add(person);
        return person;
    }
}

___________________________________________________________________________________

6.  Enkeltrettet aggregering

public class Group {
    // aggregering --> 0..* Person
    private final ArrayList<Person> persons = new ArrayList<>();

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    public Person createPerson(String personName) {
        Person person = new Person(personName);
        persons.add(person);
        return person;
    }

     * Adds the person to this group,
     * if they aren't connected.
     * Pre: The person isn't connected to another group.

public void addPerson(Person person) {
        if (!persons.contains(person)) {
        persons.add(person)
        }
     }

 * Removes the person from this group,
 * if they are connected.

public void removePerson(Person person) {
        if (persons.contains(person)) {
        persons.remove(person);
        }
    }
  }

______________________________________________________________________________

8.  Dobbeltrettet mange-til-mange associering

public class Group {
    private String name;
    // association: --> 0..* Person
    private final ArrayList<Person> persons = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }


     * Adds the person to this group and the group to the person,
     * if they aren't connected.

public void addPerson(Person person) {
        if (!persons.contains(person)) {
        persons.add(person);
        person.addGroup(this);
        }
    }

 * Removes the person from this group and the grop from the person,
 * if they are connected.

public void removePerson(Person person) {
        if (persons.contains(person)) {
        persons.remove(person);
        person.removeGroup(this);
        }

     }
}
public class Person {
    private String name;
    // association: --> 0..1 Group
    private final ArrayList<Group> groups = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public ArrayList<Group> getGroups() {
        return new ArrayList<Group>(groups);
    }

     * Adds the group to this person and the person to the group,
     * if they aren't connected

public void addGroup(Group group) {
        if (!groups.contains(group)) {
        groups.add(group);
        group.addPerson(this);
        }
    }

 * Removes the group from this person and the person from the group,
 * if they are connected

public void removeGroup(Group group) {
        if (groups.contains(group)) {
        groups.remove(group);
        group.removePerson(this);
        }
      }
   }
__________________________________________________________________________________

9.  Dobbeltrettet 0..1-til-mange associering

public class Group {
    // association --> 0..* Person
    private final ArrayList<Person> persons = new ArrayList<>();
    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }


     * Adds the person to this group,
     * if they aren't connected.

public void addPerson(Person person) {
        if (!persons.contains(person)) {
        persons.add(person);
        person.setGroup(this);
        }
        }


 * Removes the person from this group,
 * if they are connected.

public void removePerson(Person person) {
        if (persons.contains(person)) {
        persons.remove(person);
        person.setGroup(null);
        }
       }
     }


public class Person {
   private String name;
    // association --> 0..1 Group
    private Group group; // nullable

    Note: Nullable return value.
public Group getGroup() {
        return group;
        }

 * Sets the group as this person's group,
 * if they aren't connected.

public void setGroup(Group group) {
        if (this.group != group) {
        Group oldGroup = this.group;
        if (oldGroup != null) {
        oldGroup.removePerson(this);
        }
        this.group = group;
        if (group != null) {
        group.addPerson(this);
        }
      }
    }
  }

Da en person kun kan være tilknyttet til en gruppe, har metoden setGroup() ansvar for at fjerne en eventuelt
eksisterende tilknytning til en anden gruppe, inden personen tilknyttes en ny gruppe. Det sker i denne del af
koden:

Group oldGroup = this.group;
 if (oldGroup != null) {
    oldGroup.removePerson(this);
 }

Dernæst opdateres linkattributten i begge retninger:
this.group = group;
 if (group != null) {
    group.addPerson(this);
 }

___________________________________________________________________________________

10. Dobbeltrettet 0..1-til-mange komposition

public class Group {
    private String name;
    // composition: --> 0..* Person
    private final ArrayList<Person> persons = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    public Person createPerson(String personName) {
        Person person = new Person(personName, this);
        persons.add(person);
        return person;
    }

    public void removePerson(Person person) {
        if (persons.contains(person)) {
            persons.remove(person);
        }
    }
}

public class Person {
    private String name;
    // composition: --> 1 Group
    private Group group;

    Person(String name, Group group) { // package visibility
        this.name = name;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }
}




        */
