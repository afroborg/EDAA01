#F1
| Feltyp | Felet uppträder i klassen | I metoden | på raden | orsak till felet |
| ------------- | ------------- | ------------- | ------------- | ------------- | 
| NullPointerException  | Scheduler  | machineWithLeastToDo | 19 | this.machines är null när man försöker läsa array.length
| ArrayIndexOutOfBoundsException | Scheduler | printSchedule | 49 | Index 3 out of bounds for length 3

### Q: Kör programmet igen och fyll i informationen om det nya exekveringsfel i tabellen. I det andra felmeddelandet visas ett tal sist på raden med feltypen. Vad betyder detta tal? Rätta felet.
A: Talet 3 innebär att längden på listan är 3, vilket då innebär att den innehåller index [0,1,2].

#F2
### 4
Sorteringen är på fel håll, den går från lägsta till högsta istället för tvärtom. Rättas genom en att byta plats på j1 och j2 i DescTimeComps compare-metod

### 5
assignJob-metoden i Machine.java definierar om scheduleTime-attributet istället för att öka det varje gång en ett nytt jobb skapas.

#F3
En prioriteringslista (PriorityQueue)

#F4
a)
- 20
-  ja

b)
- 10
- nej

c) 
- <String, Integer>
- 7

d) containsKey()

#D2
if-satsen på rad 13 bör använda string.equals() istället för ==


#D10
WordCountComparator implementerar inte Comparator-klassen från java.util

#D13
1. 598ms
2. 591ms <-- Median
3. 517ms

#D14
- ja
- Sorterad baserad på nycklar
-   Exekveringstiden blir längre
    1. 562ms
    2. 618ms
    3. 782ms
    
#D15
- Map är ett interface som HashMap och TreeMap båda implementerar
- TreeMap sorterar sin data baserat på nycklarna, vilket medför performance-dropp
- Mängd är lämplig för att den sorterar ut dubbletter, map var lämpligt för att spara nycklar med tillhörande värden
- Array.sort-funktionen tar ett comparator-objekt och utför en operation på två värden. Beroende på comparatorns compare-klass returneras en integer som bestämmer hur värden ska sorteras i listan. 