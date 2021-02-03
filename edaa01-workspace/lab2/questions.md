# Laboration 2 - länkad lista

## Förberedelser

### F1. Läs igenom texten under rubriken ”Bakgrund”.

### F2. Läs texten till uppgift D3 och studera fig. 1. Svara på följande frågor:

a. Vilket värde ska attributet last ha i en tom lista?

**Svar**:

```java
null
```

b. Antag att listan inte är tom. Skriv klart följande tilldelningssats så att variabeln n refererar till första noden i kön. Svar

**Svar**:

```java
QueueNode<E> n = last.next;
```

c. Antag att listan inte är tom. Skriv klart följande tilldelningssats så att variabeln e
refererar till första elementet i kön.

**Svar**

```java
	E e = last.next.element;
```

### F3. Läs PM om jUnit som finns på kursens webbsida. Svara på följande frågor med hjälp av dokumentationen av jUnits klass Assert. Länk finns på kursens webbsida.

a. Vilken metod är lämplig att använda om man vill kontrollera att ett logiskt uttryck
har värdet false?

```java
assertFalse(boolean condition, String message);
```

b. Vilken metod är lämplig att använda om man vill kontrollera att två vektorer har
identiskt innehåll?

```java
assertArrayEquals(TYPE[] expected, TYPE[] actual, String message);
```

### F4. Lös uppgifterna D1, D2, D3 och D4.

### F5. Läs igenom övriga uppgifter.
