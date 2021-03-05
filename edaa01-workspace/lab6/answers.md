# Laboration 6 – hashtabell

## Förberedelser

### F1. Betrakta följande kodavsnitt:

```java
public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.get("A") + " " + map.size());
        map.put("A", 43);
        System.out.println(map.get("A") + " " + map.size());
        map.put("A", 42);
        System.out.println(map.get("A") + " " + map.size());
    }
}
```

a) Vad har nycklarna för typ?

**Svar**:

`String`

b) Vad har värdena för typ?

**Svar**:

`Ìnteger`

c) Vad skrivs ut?

**Svar**:

`null 0`

`43 1`

`42 1`
